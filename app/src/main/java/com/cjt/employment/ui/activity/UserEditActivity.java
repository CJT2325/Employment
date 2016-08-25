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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cjt.employment.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class UserEditActivity extends AppCompatActivity implements View.OnClickListener {
    private CoordinatorLayout coordinatorLayout;
    private BottomSheetBehavior behavior;

    private RelativeLayout photo_bottomsheet;
    private BottomSheetDialog dialog;
    private RelativeLayout bs_photograph;
    private RelativeLayout bs_album;
    private RelativeLayout bs_cancel;
    private RelativeLayout layout_usercover;
    private RelativeLayout layout_;

    private ImageView iv_cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_edit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initView();

//        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cl);
//        View bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);
//        behavior = BottomSheetBehavior.from(bottomSheet);
//        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
//                Log.i("TAG", "newState--->" + newState);
////                ViewCompat.setScaleX(bottomSheet,1);
////                ViewCompat.setScaleY(bottomSheet,1);
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//                //这里是拖拽中的回调，根据slideOffset可以做一些动画
//                Log.i("TAG", "slideOffset=====》" + slideOffset);
//            }
//        });
//
////        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
//////                if (behavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
//////                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//////                } else {
//////                    behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//////                }
////            }
////        });
//        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);


    }

    private void initView() {
        photo_bottomsheet= (RelativeLayout) LayoutInflater.from(this).inflate(R.layout.photo_bottomsheet,null);
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(photo_bottomsheet);

        bs_photograph = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_photograph);
        bs_album = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_album);
        bs_cancel = (RelativeLayout) photo_bottomsheet.findViewById(R.id.bs_cancel);
        layout_usercover = (RelativeLayout) findViewById(R.id.layout_usercover);
        iv_cover= (ImageView) findViewById(R.id.iv_cover);

        bs_photograph.setOnClickListener(this);
        bs_album.setOnClickListener(this);
        bs_cancel.setOnClickListener(this);
        layout_usercover.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_useredit, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bs_photograph:
                Intent photoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                //拍照完成之后图片将保存到该路径
                Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "usercover.jpg"));
                photoIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(photoIntent, 1);
//                dialog.hide();
                break;
            case R.id.bs_album:
                dialog.hide();
                break;
            case R.id.bs_cancel:
                dialog.hide();
                break;
            case R.id.layout_usercover:
                dialog.show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(Environment.getExternalStorageDirectory() + "/workupload.jpg");
        } catch (IOException e) {
            e.printStackTrace();
            exif = null;
        }
        int degree = 0;
        if (exif != null) {
            // 读取图片中相机方向信息
            int ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION,ExifInterface.ORIENTATION_UNDEFINED);
            // 计算旋转角度
            switch (ori) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    degree = 90;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_180:
                    degree = 180;
                    break;
                case ExifInterface.ORIENTATION_ROTATE_270:
                    degree = 270;
                    break;
                default:
                    degree = 0;
                    break;
            }
            //将保存在本地的图片取出并缩小后显示在界面上
            //Bitmap camorabitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/workupload.jpg");
            try {
                //直接到本地获取图片
                InputStream in = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/workupload.jpg"));
                Bitmap bm = BitmapFactory.decodeStream(in);
                if (degree != 0) {
                    // 旋转图片
                    Matrix m = new Matrix();
                    m.postRotate(degree);
                    bm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), m, true);
                }
                iv_cover.setImageBitmap(bm);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
