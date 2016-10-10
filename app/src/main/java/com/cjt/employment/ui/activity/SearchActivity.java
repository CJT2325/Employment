package com.cjt.employment.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cjt.employment.R;
import com.cjt.employment.adapter.SearchRearchAdapter;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.SearchPresenter;
import com.cjt.employment.ui.view.SearchView;

import java.util.ArrayList;
import java.util.List;

import br.com.mauker.materialsearchview.MaterialSearchView;


public class SearchActivity extends BaseActivity<SearchActivity,SearchPresenter> implements SearchView {
    private ProgressBar progressbar;
    private MaterialSearchView searchView;
    private RecyclerView recyclerview_seach;
    private SearchRearchAdapter mSearchRearchAdapter;
    private List<Recruit.DataBean> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("搜索结果");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
        initView();
        initSearchView();
        String query=getIntent().getStringExtra("query");
        Log.i("CJT",query);
        getPresenter().searchRecruitment("searchRecruitment",query);
    }

    private void initData() {
        datas=new ArrayList<>();
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
        progressbar= (ProgressBar) findViewById(R.id.progressbar);
        recyclerview_seach= (RecyclerView) findViewById(R.id.recyclerview_seach);

        mSearchRearchAdapter=new SearchRearchAdapter(datas, this, new SearchRearchAdapter.OnItemClickListener() {
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
