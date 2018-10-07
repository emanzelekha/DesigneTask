package emanzelekha.com.designetask.MVP.Presenter;

import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import emanzelekha.com.designetask.MVP.Model.Recycer.HelpModel;
import emanzelekha.com.designetask.MVP.Model.adapter.HelpListAdapter;
import emanzelekha.com.designetask.MVP.View.MyListHelpChildTabView;
import emanzelekha.com.designetask.UI.Base.BasePresenter;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpChildTab;

public class MyListHelpChildTabImpPresenter<V extends MyListHelpChildTabView> extends BasePresenter<V> implements MyListHelpChildTabPresenter<V> {
    @Inject
    HelpListAdapter helpListAdapter;
    @Override
    public void AddAdapterHelp(RecyclerView recyclerView, MyListHelpChildTab context) {

        Gson gson = new Gson();

        Type type = new TypeToken<List<HelpModel>>(){}.getType();
        List<HelpModel> inpList = new Gson().fromJson(context.getArguments().getString("RecyclerData"), type);
//        List<HelpModel> DataValues = (List<HelpModel>) gson.fromJson(context.getArguments().getString("RecyclerData"), HelpModel.class);
        helpListAdapter=new HelpListAdapter(inpList,context.getArguments().getInt("Mode"));
        recyclerView.setAdapter(helpListAdapter);

    }
}
