package com.android.management.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.android.management.R;
import com.android.management.helpers.BaseActivity;
import com.android.management.helpers.Constants;
import com.android.management.model.Episodes;
import com.android.management.model.User;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class WalletDetailActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView tvTool;
    private ImageView imgBackTool;
    private ImageView image;
    private ImageView imgDelete;
    private ImageView imgCamera;
    private TextInputLayout tvName;
    private TextInputEditText etName;
    private TextInputLayout tvAddress;
    private TextInputEditText etAddress;
    private TextInputLayout tvPhone;
    private TextInputEditText etPhone;
    private TextInputLayout tvPassword;
    private TextInputEditText etPassword;
    private TextInputLayout tvBranch;
    private AutoCompleteTextView etBranch;
    private TextInputLayout tvEpisode;
    private AutoCompleteTextView etEpisode;
    private TextInputLayout tvCenter;
    private AutoCompleteTextView etCenter;
    private AppCompatButton btn_save;
    private SpinKitView progressBar;

    private String type = "";
    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet_detail);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tvTool = findViewById(R.id.tv_tool);
        imgBackTool = findViewById(R.id.img_back_tool);
        image = findViewById(R.id.walletDetail_image);
        imgDelete = findViewById(R.id.walletDetail_img_delete);
        imgCamera = findViewById(R.id.walletDetail_img_camera);
        tvName = findViewById(R.id.walletDetail_tv_name);
        etName = findViewById(R.id.walletDetail_et_name);
        tvAddress = findViewById(R.id.walletDetail_tv_address);
        etAddress = findViewById(R.id.walletDetail_et_address);
        tvPhone = findViewById(R.id.walletDetail_tv_phone);
        etPhone = findViewById(R.id.walletDetail_et_phone);
        tvPassword = findViewById(R.id.walletDetail_tv_password);
        etPassword = findViewById(R.id.walletDetail_et_password);
        tvBranch = findViewById(R.id.walletDetail_tv_branch);
        etBranch = findViewById(R.id.walletDetail_et_branch);
        tvEpisode = findViewById(R.id.walletDetail_tv_episode);
        etEpisode = findViewById(R.id.walletDetail_et_episode);
        tvCenter = findViewById(R.id.walletDetail_tv_center);
        etCenter = findViewById(R.id.walletDetail_et_center);
        btn_save = findViewById(R.id.walletDetail_btn);
        progressBar = findViewById(R.id.progressBar);

        imgBackTool.setOnClickListener(view -> onBackPressed());

        if (type.equals(Constants.TYPE_ADD)) {
            imgDelete.setVisibility(View.GONE);
            tvTool.setText("اضافة حلقة جديدة");
        } else {
            tvTool.setText("تعديل بيانات الحلقة");
            User model = (User) getIntent().getSerializableExtra(Constants.TYPE_MODEL);
            initData(model);
        }

        imgCamera.setOnClickListener(v ->
                ImagePicker.Companion.with(this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(Constants.REQUEST_GALLERY_CODE)
        );

        btn_save.setOnClickListener(view -> {
        });

    }

    private void initData(User model) {
        Glide.with(this).load(model.getPhoto()).placeholder(R.drawable.logo).into(image);
        etName.setText(model.getFullName());
        etAddress.setText(model.getAddress());
        etPhone.setText(model.getPhone());
        etPassword.setText(model.getPassword());
        etBranch.setText(model.getBranch_name());
        etEpisode.setText(model.getEpisode_name());
        etCenter.setText(model.getCenter_name());
    }

    private void enableElements(boolean enable) {
        btn_save.setEnabled(enable);
        if (!enable) {
            btn_save.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_grey));
            progressBar.setVisibility(View.VISIBLE);
        } else {
            btn_save.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_blue));
            progressBar.setVisibility(View.INVISIBLE);
        }

        imgBackTool.setEnabled(enable);
        imgDelete.setEnabled(enable);
        imgCamera.setEnabled(enable);
        etName.setEnabled(enable);
        etAddress.setEnabled(enable);
        etPhone.setEnabled(enable);
        etPassword.setEnabled(enable);
        etBranch.setEnabled(enable);
        etEpisode.setEnabled(enable);
        etCenter.setEnabled(enable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == Constants.REQUEST_GALLERY_CODE) {
                Glide.with(this).load(ImagePicker.Companion.getFilePath(data)).into(image);
                path = ImagePicker.Companion.getFilePath(data);
                Log.e("response -> path", "path = " + path);
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}