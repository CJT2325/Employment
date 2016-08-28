package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cjt.employment.R;
import com.cjt.employment.ui.fragment.ExploreFragment;
import com.cjt.employment.ui.fragment.HomeFragment;
import com.cjt.employment.ui.fragment.MessageFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private ExploreFragment exploreFragment;

    private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        fm=getSupportFragmentManager();
        initBottomNavigationBar();
        setDefaultFragment();
    }
    //初始化BottomNavigationBar
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
                            homeFragment=HomeFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,homeFragment);
                        break;
                    case 1:
                        if (messageFragment==null){
                            messageFragment=MessageFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame,messageFragment);
                        break;
                    case 2:
                        if (exploreFragment==null){
                            exploreFragment=ExploreFragment.newInstance();
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
    //设置默认Fragment
    private void setDefaultFragment() {
        FragmentTransaction transaction = fm.beginTransaction();
        homeFragment = HomeFragment.newInstance();
        transaction.replace(R.id.layout_frame, homeFragment);
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_seacher) {
            return true;
        }else if(id == R.id.action_user){
            Intent loginIntent=new Intent(this,LoginActivity.class);
//            Intent userInfoIntent=new Intent(this,UserInfoActivity.class);
            startActivity(loginIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}
