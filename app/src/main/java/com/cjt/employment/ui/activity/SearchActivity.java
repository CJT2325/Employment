package com.cjt.employment.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.adapter.GirdDropDownAdapter;
import com.cjt.employment.adapter.ListDropDownAdapter;
import com.cjt.employment.adapter.SearchRearchAdapter;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.SearchPresenter;
import com.cjt.employment.ui.view.SearchView;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.mauker.materialsearchview.MaterialSearchView;


public class SearchActivity extends BaseActivity<SearchActivity, SearchPresenter> implements SearchView {
    private ProgressBar progressbar;
    private MaterialSearchView searchView;
    private RecyclerView recyclerview_seach;
    private SearchRearchAdapter mSearchRearchAdapter;
    private List<Recruit.DataBean> datas;

    private String query = "";

    //下拉菜单
    private DropDownMenu mDropDownMenu;
    private String headers[] = {"城市", "类型", "学历"};
    private String result[] = {"城市", "类型", "学历"};
    private List<View> popupViews = new ArrayList<>();

    private GirdDropDownAdapter cityAdapter;
    private ListDropDownAdapter ageAdapter;
    private ListDropDownAdapter educationAdapter;

    private String citys[] = {"不限", "武汉", "北京", "上海", "成都", "广州", "深圳", "重庆", "天津", "西安", "南京", "杭州"};
    private String ages[] = {"不限", "全职", "实习", "兼职", "应届毕业生"};
    private String sexs[] = {"不限", "大专", "本科", "硕士", "博士", "其他"};

    private int constellationPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("搜索结果");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerview_seach = new RecyclerView(this);
        recyclerview_seach.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        initData();
        initView();
        initSearchView();
        query = getIntent().getStringExtra("query");
        Log.i("CJT", query);
        toolbar.setTitle("搜索结果(" + query + ")");
        initDropDownMenu();
        getPresenter().searchRecruitment("searchRecruitment", query, result[0], result[1], result[2]);
    }

    private void initDropDownMenu() {


        mDropDownMenu = (DropDownMenu) findViewById(R.id.dropDownMenu);
        final ListView cityView = new ListView(this);
        cityAdapter = new GirdDropDownAdapter(this, Arrays.asList(citys));
        cityView.setDividerHeight(0);
        cityView.setAdapter(cityAdapter);

        //init age menu
        final ListView ageView = new ListView(this);
        ageView.setDividerHeight(0);
        ageAdapter = new ListDropDownAdapter(this, Arrays.asList(ages));
        ageView.setAdapter(ageAdapter);

        //init sex menu
        final ListView sexView = new ListView(this);
        sexView.setDividerHeight(0);
        educationAdapter = new ListDropDownAdapter(this, Arrays.asList(sexs));
        sexView.setAdapter(educationAdapter);

        //init popupViews
        popupViews.add(cityView);
        popupViews.add(ageView);
        popupViews.add(sexView);

        //add item click event
        cityView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cityAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[0] : citys[position]);
                result[0] = position == 0 ? headers[0] : citys[position];
                mDropDownMenu.closeMenu();
                Log.i("CJT", result[0] + " " + result[1] + " " + result[2]);
                getPresenter().searchRecruitment("searchRecruitment", query, result[0], result[1], result[2]);
            }
        });

        ageView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ageAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : ages[position]);
                result[1] = position == 0 ? headers[1] : ages[position];
                mDropDownMenu.closeMenu();
                Log.i("CJT", result[0] + " " + result[1] + " " + result[2]);
                getPresenter().searchRecruitment("searchRecruitment", query, result[0], result[1], result[2]);
            }
        });

        sexView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                educationAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[2] : sexs[position]);
                result[2] = position == 0 ? headers[2] : sexs[position];
                mDropDownMenu.closeMenu();
                Log.i("CJT", result[0] + " " + result[1] + " " + result[2]);
                getPresenter().searchRecruitment("searchRecruitment", query, result[0], result[1], result[2]);
            }
        });

        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, recyclerview_seach);
    }

    private void initData() {
        datas = new ArrayList<>();
    }

    @Override
    protected SearchPresenter creatPresenter() {
        return new SearchPresenter();
    }

    private void initSearchView() {
        searchView = (MaterialSearchView) findViewById(R.id.search_view);

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //这里发起查询
                Log.i("CJT", "query    " + query);
                SearchActivity.this.query=query;
                getSupportActionBar().setTitle("搜索结果(" + query + ")");
                getPresenter().searchRecruitment("searchRecruitment", query, result[0], result[1], result[2]);
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

    private void initView() {
        progressbar = (ProgressBar) findViewById(R.id.progressbar);
//        recyclerview_seach= (RecyclerView) findViewById(R.id.recyclerview_seach);

        mSearchRearchAdapter = new SearchRearchAdapter(datas, this, new SearchRearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mSearchRearchAdapter.startActivityByRecruitId(position);
            }
        });
        recyclerview_seach.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerview_seach.setAdapter(mSearchRearchAdapter);
        recyclerview_seach.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (mDropDownMenu.isShowing()) {
            mDropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void searchSuccess(List<Recruit.DataBean> data) {
        mSearchRearchAdapter.updataRecruit(data);
    }

    @Override
    public void searchFail() {

    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.GONE);
    }
}
