package emanzelekha.com.designetask.UI.Activites;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.duolingo.open.rtlviewpager.RtlViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpImpPresnter;
import emanzelekha.com.designetask.MVP.Presenter.MyListHelpPresnter;
import emanzelekha.com.designetask.MVP.View.MyListHelpView;
import emanzelekha.com.designetask.R;
import emanzelekha.com.designetask.UI.Base.BaseActivity;

public class MyListHelp extends BaseActivity implements MyListHelpView {

    @BindView(R.id.MyListHelp_add_btn)
    ImageView MyListHelp_add_btn;
    @BindView(R.id.MyListHelp_back_btn)
    ImageView MyListHelp_back_btn;
    @BindView(R.id.MyListHelp_parent_viewpager)
    RtlViewPager MyListHelp_parent_viewpager;
    @BindView(R.id.MyListHelp_parent_tabs)
    TabLayout MyListHelp_parent_tabs;
    @Inject
    MyListHelpPresnter<MyListHelpView> mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUnBinder(ButterKnife.bind(this));
        mPresenter = new MyListHelpImpPresnter<>();
        mPresenter.onAttach(MyListHelp.this);
        setUp();
    }

    @Override
    protected void setUp() {
        mPresenter.setupViewPager(MyListHelp_parent_viewpager,this);
        MyListHelp_parent_tabs.setupWithViewPager(MyListHelp_parent_viewpager);

    }


    @Override
    public void Add_btn() {

    }

    @Override
    public void Back_btn() {

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }
}
