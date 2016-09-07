package com.cjt.employment.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.LoginFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjt.employment.R;
import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.common.Config;
import com.cjt.employment.common.ImageUtil;
import com.cjt.employment.model.server.ServerAPI;
import com.cjt.employment.presenter.UserEditPresenter;
import com.cjt.employment.ui.view.UserEditView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class UserEditActivity extends BaseActivity<UserEditActivity, UserEditPresenter> implements View.OnClickListener, UserEditView {
    private static final int OPEN_CAMERA_CODE = 1;
    private static final int OPEN_ALBUM_CODE = 2;
    private static final int OPEN_EDITNAME_CODE = 3;
    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;

    private RelativeLayout photo_bottomsheet;
    private BottomSheetDialog dialog;
    private RelativeLayout bs_photograph;
    private RelativeLayout bs_album;
    private RelativeLayout bs_cancel;
    private RelativeLayout layout_usercover;
    private RelativeLayout layout_name;
    private ProgressBar progressbar;
    private RelativeLayout layout_;

    private ImageView iv_cover;
    private TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("个人信息");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initView();
        getPresenter().getAccountInfoById("getAccountInfo", 1);
    }

    @Override
    protected UserEditPresenter creatPresenter() {
        return new UserEditPresenter();
    }

    private void initView() {
        photo_bottomsheet = (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.photo_bottomsheet, null);
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(photo_bottomsheet);

        bs_photograph = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_photograph);
        bs_album = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_album);
        bs_cancel = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_cancel);
        layout_usercover = (RelativeLayout) findViewById(R.id.layout_usercover);
        layout_name = (RelativeLayout) findViewById(R.id.layout_name);
        iv_cover = (ImageView) findViewById(R.id.iv_cover);
        tv_name = (TextView) findViewById(R.id.tv_name);
        progressbar = (ProgressBar) findViewById(R.id.progressbar);

        bs_photograph.setOnClickListener(this);
        bs_album.setOnClickListener(this);
        bs_cancel.setOnClickListener(this);
        layout_usercover.setOnClickListener(this);
        layout_name.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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
            case R.id.layout_usercover:
                dialog.show();
                break;
            case R.id.layout_name:
                Intent editNameIntent = new Intent(this, AccountNameEditActivity.class);
                editNameIntent.putExtra("name", tv_name.getText().toString());
                startActivityForResult(editNameIntent, OPEN_EDITNAME_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        dialog.hide();
        if (resultCode == RESULT_OK) {
            File myCaptureFile = new File("sdcard/usercover.jpg");//将要保存图片的路径
            if (requestCode == OPEN_CAMERA_CODE) {
                //直接通过返回的intent获取图片，较为不清晰
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                //显示到imageView上
                iv_cover.setImageBitmap(bitmap);
                //保存到本地
                try {
                    if (!myCaptureFile.exists()) {
                        myCaptureFile.createNewFile();
                    }
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                    bos.flush();
                    bos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                getPresenter().upLoadImage("upLoadAccountCover", 1, myCaptureFile);
            }
            if (requestCode == OPEN_ALBUM_CODE) {
                Uri uri = data.getData();
                Log.i("CJT", uri.toString());
                Bitmap bitmap = ImageUtil.handleImageOnKitKat(this, data);
                iv_cover.setImageBitmap(bitmap);
                try {
                    if (!myCaptureFile.exists()) {
                        myCaptureFile.createNewFile();
                    }
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bos);
                    bos.flush();
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                getPresenter().upLoadImage("upLoadAccountCover", Integer.parseInt(Config.getValueByKey(this,Config.KEY_USERID)), myCaptureFile);
            }
            if (requestCode == OPEN_EDITNAME_CODE) {
                tv_name.setText(data.getStringExtra("name"));
                getPresenter().updateName("updateName", 1, data.getStringExtra("name"));
            }
        }
    }

    @Override
    public void upLoadImageSuccess() {
        Log.i("CJT", "Success");
        hideProgressBar();
    }

    @Override
    public void updateAccountInfo(AccountInfo.DataBean dataBean) {
        Picasso.with(this).load(ServerAPI.baseUrl+"image/accountCover/" + dataBean.getCover())
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(iv_cover);
        tv_name.setText(dataBean.getName());
        hideProgressBar();
    }

    @Override
    public void upLoadImageFail() {
        Log.i("CJT", "Fail");
    }

    @Override
    public void showProgressBar() {
        progressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void updateNameSuccess() {
        hideProgressBar();
    }
}
