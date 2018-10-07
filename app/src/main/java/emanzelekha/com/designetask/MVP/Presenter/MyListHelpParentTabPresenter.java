package emanzelekha.com.designetask.MVP.Presenter;

import android.support.v4.view.ViewPager;

import emanzelekha.com.designetask.MVP.View.MyListHelpParentTabView;
import emanzelekha.com.designetask.UI.Activites.MyListHelp;
import emanzelekha.com.designetask.UI.Base.MvpPresenter;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpParentTab;

public interface MyListHelpParentTabPresenter<V extends MyListHelpParentTabView> extends MvpPresenter<V> {
    void setupViewPager(ViewPager viewPager, MyListHelpParentTab context);

}
