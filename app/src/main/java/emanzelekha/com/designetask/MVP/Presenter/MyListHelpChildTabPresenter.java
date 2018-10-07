package emanzelekha.com.designetask.MVP.Presenter;

import android.support.v7.widget.RecyclerView;

import emanzelekha.com.designetask.MVP.View.MyListHelpChildTabView;
import emanzelekha.com.designetask.UI.Base.MvpPresenter;
import emanzelekha.com.designetask.UI.Fragments.MyListHelpChildTab;

public interface MyListHelpChildTabPresenter<V extends MyListHelpChildTabView> extends MvpPresenter<V> {

    void AddAdapterHelp(RecyclerView recyclerView, MyListHelpChildTab context);


}
