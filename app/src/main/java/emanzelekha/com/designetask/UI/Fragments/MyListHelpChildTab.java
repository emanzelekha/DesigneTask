package emanzelekha.com.designetask.UI.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpChildTabImpPresenter;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpChildTabPresenter;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpParentTabImpPresenter;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpParentTabPresenter;
import emanzelekha.com.designetask.MVP.View.MyListHelpChildTabView;
import emanzelekha.com.designetask.MVP.View.MyListHelpParentTabView;
import emanzelekha.com.designetask.R;
import emanzelekha.com.designetask.UI.Base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListHelpChildTab extends BaseFragment implements MyListHelpChildTabView {
    View view;
    @Inject
    MyListHelpChildTabPresenter<MyListHelpChildTabView> mPresenter;

    @BindView(R.id.HelpRecyclerView)
    RecyclerView HelpRecyclerView;

    public MyListHelpChildTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_my_list_help_child_tab, container, false);

        setUnBinder(ButterKnife.bind(this, view));
        mPresenter = new MyListHelpChildTabImpPresenter<>();
        mPresenter.onAttach(this);
        return view;
    }

    @Override
    protected void setUp(View view) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        HelpRecyclerView.setLayoutManager(mLayoutManager);
        HelpRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mPresenter.AddAdapterHelp(HelpRecyclerView,this);
    }
}
