package com.cjt.employment.ui.activity;

import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cjt.employment.R;
import com.cjt.employment.common.Config;
import com.cjt.employment.ui.fragment.ExploreFragment;
import com.cjt.employment.ui.fragment.HomeFragment;
import com.cjt.employment.ui.fragment.MessageFragment;

import br.com.mauker.materialsearchview.MaterialSearchView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationBar bottomNavigationBar;
    private MaterialSearchView searchView;

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
        fm = getSupportFragmentManager();
        initBottomNavigationBar();
        initSearchView();
        setDefaultFragment();
    }

    private void initSearchView() {
        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //这里发起查询
                Intent searchIntent = new Intent(MainActivity.this, SearchActivity.class);
                searchIntent.putExtra("query",query);
                startActivity(searchIntent);
                Log.i("CJT", "query    " + query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("CJT", "newText     " + newText);
                return false;
            }
        });

        searchView.setSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewOpened() {
                // Do something once the view is open.
            }

            @Override
            public void onSearchViewClosed() {
                // Do something once the view is closed.
            }
        });

        searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Do something when the suggestion list is clicked.
                String suggestion = searchView.getSuggestionAtPosition(position);

                searchView.setQuery(suggestion, false);
            }
        });


        final Context context = this;
        searchView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, "Long clicked position: " + i, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        searchView.setOnVoiceClickedListener(new MaterialSearchView.OnVoiceClickedListener() {
            @Override
            public void onVoiceClicked() {
                Toast.makeText(context, "Voice clicked!", Toast.LENGTH_SHORT).show();
            }
        });
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
                FragmentTransaction transaction = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            homeFragment = HomeFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame, homeFragment);
                        break;
                    case 1:
                        if (messageFragment == null) {
                            messageFragment = MessageFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame, messageFragment);
                        break;
                    case 2:
                        if (exploreFragment == null) {
                            exploreFragment = ExploreFragment.newInstance();
                        }
                        transaction.replace(R.id.layout_frame, exploreFragment);
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

            searchView.openSearch();
            return true;
        } else if (id == R.id.action_user) {
            Intent intent;
            if (Config.getValueByKey(this, Config.KEY_TOKEN).equals("")) {
                intent = new Intent(this, LoginActivity.class);
            } else {
                intent = new Intent(this, UserInfoActivity.class);
            }
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
