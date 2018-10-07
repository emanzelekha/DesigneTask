package emanzelekha.com.designetask.UI.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duolingo.open.rtlviewpager.RtlViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpParentTabImpPresenter;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpParentTabPresenter;
import emanzelekha.com.designetask.MVP.View.MyListHelpChildTabView;
import emanzelekha.com.designetask.MVP.View.MyListHelpParentTabView;
import emanzelekha.com.designetask.R;
import emanzelekha.com.designetask.UI.Base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListHelpParentTab extends BaseFragment implements MyListHelpParentTabView {
    View view;
    @Inject
    MyListHelpParentTabPresenter<MyListHelpParentTabView> mPresenter;

    @BindView(R.id.MyListHelp_child_viewpager)
    RtlViewPager MyListHelp_child_viewpager;
    @BindView(R.id.MyListHelp_child_tabs)
    TabLayout MyListHelp_child_tabs;

    public MyListHelpParentTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my_list_help_parent_tab, container, false);

        setUnBinder(ButterKnife.bind(this, view));
        mPresenter = new MyListHelpParentTabImpPresenter<>();
        mPresenter.onAttach(this);
        return view;
    }


    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    protected void setUp(View view) {
        mPresenter.setupViewPager(MyListHelp_child_viewpager, this);
        MyListHelp_child_tabs.setupWithViewPager(MyListHelp_child_viewpager);

    }
}
