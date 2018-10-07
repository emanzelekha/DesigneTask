package emanzelekha.com.designetask.MVP.Presenter;


import android.os.Bundle;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import emanzelekha.com.designetask.MVP.View.MyListHelpView;
import emanzelekha.com.designetask.MVP.Model.adapter.ViewPagerAdapter;
import emanzelekha.com.designetask.R;
import emanzelekha.com.designetask.UI.Activites.MyListHelp;
import emanzelekha.com.designetask.UI.Base.BasePresenter;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpParentTab;

public class MyListHelpImpPresnter<V extends MyListHelpView> extends BasePresenter<V> implements MyListHelpPresnter<V> {

    @Inject
    ViewPagerAdapter adapter;

    @Override

    public void setupViewPager(ViewPager viewPager, MyListHelp context) {
        adapter = new ViewPagerAdapter(context.getSupportFragmentManager());
        MyListHelpParentTab fragment = new MyListHelpParentTab();

        Bundle bundle = new Bundle();
        bundle.putInt("Position", 0);
        fragment.setArguments(bundle);
        adapter.addFragment(fragment, context.getString(R.string.calling));
        MyListHelpParentTab fragment1 = new MyListHelpParentTab();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("Position", 1);
        fragment1.setArguments(bundle1);
        adapter.addFragment(fragment1, context.getString(R.string.other));
        viewPager.setAdapter(adapter);
    }


}
