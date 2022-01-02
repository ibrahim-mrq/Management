package com.android.management.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.android.management.R;
import com.android.management.helpers.BaseActivity;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView tvTool;
    private ImageView imgBackTool;

    private CircleImageView registerImg;
    private ImageView registerImgCamera;
    private TextInputLayout registerTvName;
    private TextInputEditText registerEtName;
    private TextInputLayout registerTvEmail;
    private TextInputEditText registerEtEmail;
    private TextInputLayout registerTvPhone;
    private TextInputEditText registerEtPhone;
    private TextInputLayout registerTvDate;
    private TextInputEditText registerEtDate;
    private TextInputLayout registerTvBranch;
    private AutoCompleteTextView registerEtBranch;
    private TextInputLayout registerTvAddress;
    private TextInputEditText registerEtAddress;
    private TextInputLayout registerTvId;
    private TextInputEditText registerEtId;
    private TextInputLayout registerTvPassword;
    private TextInputEditText registerEtPassword;
    private TextInputLayout registerTvConfPassword;
    private TextInputEditText registerEtConfPassword;
    private AppCompatButton registerBtn;
    private SpinKitView progressBar;

    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();

    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tvTool = findViewById(R.id.tv_tool);
        imgBackTool = findViewById(R.id.img_back_tool);

        registerImg = findViewById(R.id.register_img);
        registerImgCamera = findViewById(R.id.register_img_camera);
        registerTvName = findViewById(R.id.register_tv_name);
        registerEtName = findViewById(R.id.register_et_name);
        registerTvEmail = findViewById(R.id.register_tv_email);
        registerEtEmail = findViewById(R.id.register_et_email);
        registerTvPhone = findViewById(R.id.register_tv_phone);
        registerEtPhone = findViewById(R.id.register_et_phone);
        registerTvDate = findViewById(R.id.register_tv_date);
        registerEtDate = findViewById(R.id.register_et_date);
        registerTvBranch = findViewById(R.id.register_tv_branch);
        registerEtBranch = findViewById(R.id.register_et_branch);
        registerTvAddress = findViewById(R.id.register_tv_address);
        registerEtAddress = findViewById(R.id.register_et_address);
        registerTvId = findViewById(R.id.register_tv_id);
        registerEtId = findViewById(R.id.register_et_id);
        registerTvPassword = findViewById(R.id.register_tv_password);
        registerEtPassword = findViewById(R.id.register_et_password);
        registerTvConfPassword = findViewById(R.id.register_tv_conf_password);
        registerEtConfPassword = findViewById(R.id.register_et_conf_password);
        registerBtn = findViewById(R.id.register_btn);
        progressBar = findViewById(R.id.progressBar);

        imgBackTool.setOnClickListener(view -> onBackPressed());
        tvTool.setText(getString(R.string.register));

        registerBtn.setOnClickListener(view -> register());

        registerTvDate.setOnClickListener(view -> {
            DatePickerDialog.newInstance((view1, year, monthOfYear, dayOfMonth) -> {
                registerEtDate.setText(year + "/" + monthOfYear + "/" + dayOfMonth);
                setCalendar(year, monthOfYear, dayOfMonth);
            }, Calendar.getInstance());
        });

    }

    private void setCalendar(int year, int month, int day) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }

    private void register() {
        if (isNotEmpty(registerEtName, registerTvName)
                && isNotEmpty(registerEtEmail, registerTvEmail)
                && isNotEmpty(registerEtPhone, registerTvPhone)
                && isNotEmpty(registerEtDate, registerTvDate)
                && isNotEmpty(registerEtBranch, registerTvBranch)
                && isNotEmpty(registerEtAddress, registerTvAddress)
                && isNotEmpty(registerEtId, registerTvId)
                && isNotEmpty(registerEtPassword, registerTvPassword)
                && isNotEmpty(registerEtConfPassword, registerTvConfPassword)
                && isValidEmail(registerEtEmail, registerTvEmail)
                && isConfirmPassword(registerEtPassword, registerTvPassword,
                registerEtConfPassword, registerTvConfPassword)
        ) {
//            enableElements(false);
            startActivity(new Intent(this, MainActivity.class));

        }

    }

    private void enableElements(boolean enable) {
        registerBtn.setEnabled(enable);
        if (!enable) {
            registerBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_grey));
            progressBar.setVisibility(View.VISIBLE);
        } else {
            registerBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_blue));
            progressBar.setVisibility(View.INVISIBLE);
        }

        registerImg.setEnabled(enable);
        registerImgCamera.setEnabled(enable);
        registerEtName.setEnabled(enable);
        registerEtEmail.setEnabled(enable);
        registerEtPhone.setEnabled(enable);
//        registerEtDate.setEnabled(enable);
        registerTvBranch.setEnabled(enable);
        registerEtBranch.setEnabled(enable);
        registerEtAddress.setEnabled(enable);
        registerEtId.setEnabled(enable);
        registerEtPassword.setEnabled(enable);
        registerEtConfPassword.setEnabled(enable);
        imgBackTool.setEnabled(enable);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}