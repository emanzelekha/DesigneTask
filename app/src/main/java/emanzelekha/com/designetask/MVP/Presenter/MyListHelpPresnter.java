package emanzelekha.com.designetask.MVP.Presenter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import emanzelekha.com.designetask.MVP.View.MyListHelpView;
import emanzelekha.com.designetask.UI.Activites.MyListHelp;
import emanzelekha.com.designetask.UI.Base.MvpPresenter;

public interface MyListHelpPresnter<V extends MyListHelpView> extends MvpPresenter<V> {

    void setupViewPager(ViewPager viewPager, MyListHelp context);
}
