package com.cjt.employment.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.common.Config;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.EnterpriseInfoPresenter;
import com.cjt.employment.ui.view.EnterpriseInfoView;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class EnterpriseInfoFragment extends BaseFragment<EnterpriseInfoFragment, EnterpriseInfoPresenter> implements EnterpriseInfoView,View.OnClickListener {
    private static final int OPEN_CAMERA_CODE = 1;
    private static final int OPEN_ALBUM_CODE = 2;
    private static final int OPEN_EDITNAME_CODE = 3;

    private RelativeLayout layout_cover;
    private RelativeLayout layout_name;
    private RelativeLayout layout_condition;
    private RelativeLayout layout_product;
    private RelativeLayout layout_controduce;

    private ImageView iv_cover;
    private TextView tv_name;
    private TextView tv_condition;

    private ProgressBar progressbar;
    private RelativeLayout photo_bottomsheet;
    private BottomSheetDialog dialog;
    private RelativeLayout bs_photograph;
    private RelativeLayout bs_album;
    private RelativeLayout bs_cancel;

    public static EnterpriseInfoFragment newInstance() {
        EnterpriseInfoFragment fragment = new EnterpriseInfoFragment();
        Bundle args = new Bundle();
        args.putString("agrs1", "text");
        fragment.setArguments(args);
        return fragment;
    }

    public EnterpriseInfoFragment() {

    }

    @Override
    protected EnterpriseInfoPresenter creatPresenter() {
        return new EnterpriseInfoPresenter(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_enterprise_info, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        photo_bottomsheet = (RelativeLayout) LayoutInflater.from(getContext()).inflate(R.layout.photo_bottomsheet, null);
        dialog = new BottomSheetDialog(getContext());
        dialog.setContentView(photo_bottomsheet);

        bs_photograph = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_photograph);
        bs_album = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_album);
        bs_cancel = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_cancel);
        bs_photograph.setOnClickListener(this);
        bs_album.setOnClickListener(this);
        bs_cancel.setOnClickListener(this);

        layout_cover= (RelativeLayout) view.findViewById(R.id.layout_cover);
        layout_name= (RelativeLayout) view.findViewById(R.id.layout_name);
        layout_condition= (RelativeLayout) view.findViewById(R.id.layout_condition);
        layout_product= (RelativeLayout) view.findViewById(R.id.layout_product);
        layout_controduce= (RelativeLayout) view.findViewById(R.id.layout_controduce);

        layout_cover.setOnClickListener(this);
        layout_name.setOnClickListener(this);
        layout_condition.setOnClickListener(this);
        layout_product.setOnClickListener(this);
        layout_controduce.setOnClickListener(this);

        iv_cover= (ImageView) view.findViewById(R.id.iv_cover);
        tv_name= (TextView) view.findViewById(R.id.tv_name);
        tv_condition= (TextView) view.findViewById(R.id.tv_condition);
        progressbar= (ProgressBar) view.findViewById(R.id.progressbar);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getPresenter() != null) {
            getPresenter().getPositionByCompanyId("getCompanyInfoByUserId", Config.getValueByKey(getContext(),Config.KEY_USERID));
        } else {
            Log.i("CJT", "presenter is null");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_cover:
                dialog.show();
                break;
            case R.id.layout_name:
                break;
            case R.id.layout_condition:
                break;
            case R.id.layout_product:
                break;
            case R.id.layout_controduce:
                break;
            case R.id.bs_photograph:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, OPEN_CAMERA_CODE);
                break;
            case R.id.bs_album:
                Intent albumIntent = new Intent(Intent.ACTION_PICK);
                albumIntent.setType("image/*");
                startActivityForResult(albumIntent, OPEN_ALBUM_CODE);
                break;
            case R.id.bs_cancel:
                dialog.hide();
                break;
        }
    }

    @Override
    public void getCompanyInfoSuccess(CompanyInfo.DataBean dataBean) {
        Picasso.with(getContext()).load(ServerAPI.baseUrl+"image/companyCover/"+dataBean.getLogo()).into(iv_cover);
        tv_name.setText(dataBean.getCompany());
        tv_condition.setText(dataBean.getFinancing() + " | " + dataBean.getEmployenumber() + "人 | " + dataBean.getPattern());
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