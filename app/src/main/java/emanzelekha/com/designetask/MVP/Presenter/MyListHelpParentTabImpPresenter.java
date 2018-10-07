package emanzelekha.com.designetask.MVP.Presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import emanzelekha.com.designetask.MVP.Model.Recycer.HelpModel;
import emanzelekha.com.designetask.MVP.Model.adapter.ViewPagerAdapter;
import emanzelekha.com.designetask.MVP.View.MyListHelpParentTabView;
import emanzelekha.com.designetask.R;
import emanzelekha.com.designetask.UI.Activites.MyListHelp;
import emanzelekha.com.designetask.UI.Base.BasePresenter;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpChildTab;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpParentTab;

public class MyListHelpParentTabImpPresenter<V extends MyListHelpParentTabView> extends BasePresenter<V> implements MyListHelpParentTabPresenter<V> {
    @Inject
    ViewPagerAdapter adapter;

    @Override
    public void setupViewPager(ViewPager viewPager, MyListHelpParentTab context) {
        List<String> ListData = PrepareData(context.getArguments().getInt("Position"), context.getContext());
        adapter = new ViewPagerAdapter(context.getChildFragmentManager());
        MyListHelpChildTab fragment = new MyListHelpChildTab();
        Bundle bundle = new Bundle();
        bundle.putString("RecyclerData", ListData.get(0));
        bundle.putInt("Mode", 0);

        fragment.setArguments(bundle);
        adapter.addFragment(fragment, context.getString(R.string.waiting));
        MyListHelpChildTab fragment1 = new MyListHelpChildTab();
        Bundle bundle1 = new Bundle();
        bundle1.putString("RecyclerData", ListData.get(1));
        bundle1.putInt("Mode", 0);
        fragment1.setArguments(bundle1);
        adapter.addFragment(fragment1, context.getString(R.string.accept));

        MyListHelpChildTab fragment2 = new MyListHelpChildTab();
        Bundle bundle2 = new Bundle();
        bundle2.putString("RecyclerData", ListData.get(2));
        bundle2.putInt("Mode", 1);
        fragment2.setArguments(bundle2);
        adapter.addFragment(fragment2, context.getString(R.string.reject));
        viewPager.setAdapter(adapter);
    }


    private List<String> PrepareData(int Mode, Context context) {//for my help and other call service base on this
        List<String> list = new ArrayList<>();
        String[] helpTitleAccept = context.getResources().getStringArray(R.array.Help_title_waite);
        String[] helpTitletypeAccept = context.getResources().getStringArray(R.array.Help_title_waite_type);
        String[] helpTitletimeAccept = context.getResources().getStringArray(R.array.Help_title_waite_time);
        String[] helpTitleinfoAccept = context.getResources().getStringArray(R.array.Help_title_waite_info);
//WaitModelData
        List<HelpModel> WaiteList = new ArrayList<>();
        for (int i = 0; i < helpTitleAccept.length; i++) {

            HelpModel Waite = new HelpModel();
            Waite.setActive(true);
            Waite.setAttend(i + "");
            Waite.setInfo(helpTitleinfoAccept[i]);
            Waite.setTime(helpTitletimeAccept[i]);
            Waite.setType(helpTitletypeAccept[i]);
            Waite.setTitle(helpTitleAccept[i]);
            WaiteList.add(Waite);


        }
        Gson gson = new Gson();
        list.add(gson.toJson(WaiteList));

        String[] helpTitleConfirm = context.getResources().getStringArray(R.array.Help_title_accepted);
        String[] helpTitletypeConfirm = context.getResources().getStringArray(R.array.Help_title_accepted_type);
        String[] helpTitletimeConfirm = context.getResources().getStringArray(R.array.Help_title_accepted_time);
        String[] helpTitleinfoConfirm = context.getResources().getStringArray(R.array.Help_title_accepted_info);
//ModelconfirmData
        List<HelpModel> ConfirmList = new ArrayList<>();
        for (int i = 0; i < helpTitleConfirm.length; i++) {

            HelpModel Confirm = new HelpModel();
            Confirm.setActive(true);
            Confirm.setAttend(i + "");
            Confirm.setInfo(helpTitleinfoConfirm[i]);
            Confirm.setTime(helpTitletimeConfirm[i]);
            Confirm.setType(helpTitletypeConfirm[i]);
            Confirm.setTitle(helpTitleConfirm[i]);
            ConfirmList.add(Confirm);


        }
        Gson gson2 = new Gson();
        list.add(gson2.toJson(ConfirmList));

        String[] helpTitlecancle = context.getResources().getStringArray(R.array.Help_title_cancel);
        String[] helpTitletypecancle = context.getResources().getStringArray(R.array.Help_title_cancel_type);
        String[] helpTitletimecancle = context.getResources().getStringArray(R.array.Help_title_cancel_time);
        String[] helpTitleinfocancle = context.getResources().getStringArray(R.array.Help_title_cancel_info);
//ModelcancleData
        List<HelpModel> cancleList = new ArrayList<>();
        for (int i = 0; i < helpTitlecancle.length; i++) {

            HelpModel cancle = new HelpModel();
            cancle.setActive(false);
            cancle.setAttend(i + "");
            cancle.setInfo(helpTitleinfocancle[i]);
            cancle.setTime(helpTitletimecancle[i]);
            cancle.setType(helpTitletypecancle[i]);
            cancle.setTitle(helpTitlecancle[i]);
            cancleList.add(cancle);


        }
        Gson gson3 = new Gson();
        list.add(gson3.toJson(cancleList));

        //just rearrange data to show diffrent
        switch (Mode) {
            case 0:

                break;
            case 1:
                Collections.reverse(list);
                break;
        }

        return list;

    }
}
