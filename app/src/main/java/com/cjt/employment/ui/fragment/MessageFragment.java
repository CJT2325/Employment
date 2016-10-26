package com.cjt.employment.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjt.employment.R;
import com.cjt.employment.adapter.MessageAdapter;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.DividerItemDecoration;
import com.cjt.employment.presenter.MessagePresenter;

import java.util.ArrayList;
import java.util.List;

public class MessageFragment extends BaseFragment<HomeFragment, MessagePresenter> {
    private RecyclerView mRecyclerView;
    private List<UserBean> mDatas;
    private MessageAdapter mMessageAdapter;

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public MessageFragment() {

    }

    @Override
    protected MessagePresenter creatPresenter() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        initDatas();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_message);
        mMessageAdapter = new MessageAdapter(mDatas, getActivity(), new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mMessageAdapter.startChatRoom(position);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setAdapter(mMessageAdapter);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST));
        return view;
    }

    private void initDatas() {
        mDatas = Config.getList(getContext());
        if (mDatas==null) {
            mDatas = new ArrayList<UserBean>();
//            for (int i = 0; i < 4; i++) {
//                UserBean userBean = new UserBean();
//                userBean.setId(i + "");
//                userBean.setCover("afasfafas");
//                userBean.setCompanyName("Tencent");
//                userBean.setName("CJT");
//                mDatas.add(userBean);
//            }
            Config.saveList(getContext(),mDatas);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (Config.getList(getContext())!=null){
            mMessageAdapter.updata(Config.getList(getContext()));
        }
        if (getPresenter() != null) {
//            getPresenter().getShopList();
        } else {
            Log.i("CJT", "presenter is null");
        }
    }
}