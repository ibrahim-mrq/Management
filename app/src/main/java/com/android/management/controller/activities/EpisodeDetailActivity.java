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
import com.android.management.model.Center;
import com.android.management.model.Episodes;
import com.bumptech.glide.Glide;
import com.github.dhaval2404.imagepicker.ImagePicker;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class EpisodeDetailActivity extends BaseActivity {

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
    private TextInputLayout tvCount;
    private TextInputEditText etCount;
    private TextInputLayout tvCenter;
    private AutoCompleteTextView etCenter;
    private TextInputLayout tvDesc;
    private TextInputEditText etDesc;
    private AppCompatButton btnAddAdmin;
    private AppCompatButton btn_save;
    private SpinKitView progressBar;
    private FloatingActionButton fabStudent;
    private FloatingActionButton fabWallet;

    private String type = "";
    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

        initView();
    }

    private void initView() {
        type = getIntent().getStringExtra(Constants.KEY);

        toolbar = findViewById(R.id.toolbar);
        tvTool = findViewById(R.id.tv_tool);
        imgBackTool = findViewById(R.id.img_back_tool);
        image = findViewById(R.id.episodeDetail_image);
        imgDelete = findViewById(R.id.episodeDetail_img_delete);
        imgCamera = findViewById(R.id.episodeDetail_img_camera);
        tvName = findViewById(R.id.episodeDetail_tv_name);
        etName = findViewById(R.id.episodeDetail_et_name);
        tvAddress = findViewById(R.id.episodeDetail_tv_address);
        etAddress = findViewById(R.id.episodeDetail_et_address);
        tvCount = findViewById(R.id.episodeDetail_tv_count);
        etCount = findViewById(R.id.episodeDetail_et_count);
        tvCenter = findViewById(R.id.episodeDetail_tv_center);
        etCenter = findViewById(R.id.episodeDetail_et_center);
        tvDesc = findViewById(R.id.episodeDetail_tv_desc);
        etDesc = findViewById(R.id.episodeDetail_et_desc);
        btnAddAdmin = findViewById(R.id.episodeDetail_btn_add_admin);
        btn_save = findViewById(R.id.episodeDetail_btn);
        progressBar = findViewById(R.id.progressBar);
        fabStudent = findViewById(R.id.fab_student);
        fabWallet = findViewById(R.id.fab_wallet);

        imgBackTool.setOnClickListener(view -> onBackPressed());

        if (type.equals(Constants.TYPE_ADD)) {
            fabStudent.setVisibility(View.GONE);
            fabWallet.setVisibility(View.GONE);
            imgDelete.setVisibility(View.GONE);
            tvTool.setText("اضافة حلقة جديدة");
        } else {
            tvTool.setText("تعديل بيانات الحلقة");
            Episodes model = (Episodes) getIntent().getSerializableExtra(Constants.TYPE_MODEL);
            initData(model);
        }

        imgCamera.setOnClickListener(v ->
                ImagePicker.Companion.with(this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(Constants.REQUEST_GALLERY_CODE)
        );

        fabWallet.setOnClickListener(view -> {
            startActivity(new Intent(this, WalletActivity.class)
                    .putExtra(Constants.KEY, type)
            );
        });
    }

    private void initData(Episodes model) {
        Glide.with(this).load(model.getPhoto()).placeholder(R.drawable.logo).into(image);
        etName.setText(model.getName());
        etAddress.setText(model.getAddress());
        etCount.setText(model.getNumber_students() + "");
        etCenter.setText(model.getCenter_name());
        etDesc.setText(model.getDescription());
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
        etCount.setEnabled(enable);
        etCenter.setEnabled(enable);
        etDesc.setEnabled(enable);
        btnAddAdmin.setEnabled(enable);
        fabStudent.setEnabled(enable);
        fabWallet.setEnabled(enable);
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