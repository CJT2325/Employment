package com.cjt.employment.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cjt.employment.R;
import com.cjt.employment.ui.fragment.EnterpriseInfoFragment;
import com.cjt.employment.ui.fragment.EnterprisePositionFragment;
import com.cjt.employment.ui.fragment.EnterpriseVitageFragment;
import com.cjt.employment.ui.fragment.ExploreFragment;
import com.cjt.employment.ui.fragment.HomeFragment;
import com.cjt.employment.ui.fragment.MessageFragment;

public class EnterpriseHomeActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    private EnterprisePositionFragment enterprisePositionFragment;
    private EnterpriseVitageFragment enterpriseVitageFragment;
    private EnterpriseInfoFragment enterpriseInfoFragment;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("职位管理");
        setSupportActionBar(toolbar);
        fm = getSupportFragmentManager();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initBottomNavigationBar();
        setDefaultFragment();
    }
    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_card_travel_black_24dp1, "Position"))
                .addItem(new BottomNavigationItem(R.drawable.ic_insert_drive_file_black_24dp, "Vitage"))
                .addItem(new BottomNavigationItem(R.drawable.ic_public_black_24dp, "Explore"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction transaction=fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (enterprisePositionFragment==null){
                            enterprisePositionFragment= EnterprisePositionFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,enterprisePositionFragment);
                        getSupportActionBar().setTitle("职位管理");
                        break;
                    case 1:
//                        if (enterpriseVitageFragment==null){
                            enterpriseVitageFragment= EnterpriseVitageFragment.newInstance();
//                        }
                        transaction.replace(R.id.layout_frame,enterpriseVitageFragment);
                        getSupportActionBar().setTitle("简历管理");
                        break;
                    case 2:
                        if (enterpriseInfoFragment==null){
                            enterpriseInfoFragment= EnterpriseInfoFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,enterpriseInfoFragment);
                        getSupportActionBar().setTitle("公司信息");
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {
                Log.i("CJT", position + " onTabUnselected");
            }

            @Override
            public void onTabReselected(int position) {
                Log.i("CJT", position + " onTabReselected");
            }
        });
    }
    //设置默认Fragment
    private void setDefaultFragment() {
        FragmentTransaction transaction = fm.beginTransaction();
        enterprisePositionFragment = EnterprisePositionFragment.newInstance();
        transaction.replace(R.id.layout_frame, enterprisePositionFragment);
        transaction.commit();
    }
}
