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
import com.cjt.employment.ui.fragment.ExploreFragment;
import com.cjt.employment.ui.fragment.HomeFragment;
import com.cjt.employment.ui.fragment.MessageFragment;

public class EnterpriseHomeActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private ExploreFragment exploreFragment;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("企业版");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initBottomNavigationBar();
    }
    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "Home"))
                .addItem(new BottomNavigationItem(R.drawable.ic_message_black_24dp, "Message"))
                .addItem(new BottomNavigationItem(R.drawable.ic_public_black_24dp, "Explore"))
                .initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                FragmentTransaction transaction=fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (homeFragment==null){
                            homeFragment= HomeFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,homeFragment);
                        break;
                    case 1:
                        if (messageFragment==null){
                            messageFragment= MessageFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,messageFragment);
                        break;
                    case 2:
                        if (exploreFragment==null){
                            exploreFragment= ExploreFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,exploreFragment);
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
}
