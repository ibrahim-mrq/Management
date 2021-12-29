package com.android.management.controller.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.android.management.R;
import com.android.management.helpers.BaseActivity;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends BaseActivity {

    private Toolbar toolbar;
    private TextView tvTool;
    private TextInputLayout loginTvId;
    private TextInputEditText loginEtId;
    private TextInputLayout loginTvPassword;
    private TextInputEditText loginEtPassword;
    private AppCompatButton loginBtn;
    private SpinKitView progressBar;
    private TextView loginTvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        tvTool = findViewById(R.id.tv_tool);
        loginTvId = findViewById(R.id.login_tv_id);
        loginEtId = findViewById(R.id.login_et_id);
        loginTvPassword = findViewById(R.id.login_tv_password);
        loginEtPassword = findViewById(R.id.login_et_password);
        loginBtn = findViewById(R.id.login_btn);
        progressBar = findViewById(R.id.progressBar);
        loginTvSignup = findViewById(R.id.login_tv_signup);

        tvTool.setText(getString(R.string.login));

        String styledText = "مستخدم جديد ؟ <font color='#ca1313'> سجل الان </font>";
        loginTvSignup.setText(Html.fromHtml(styledText), TextView.BufferType.SPANNABLE);

        loginTvSignup.setOnClickListener(view -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        loginBtn.setOnClickListener(view -> login());

    }

    private void login() {
        if (isNotEmpty(loginEtId, loginTvId)
                && isNotEmpty(loginEtPassword, loginTvPassword)
        ) {
//            enableElements(false);
            startActivity(new Intent(this, MainActivity.class));
        }

    }

    private void enableElements(boolean enable) {
        loginBtn.setEnabled(enable);
        if (!enable) {
            loginBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_grey));
            progressBar.setVisibility(View.VISIBLE);
        } else {
            loginBtn.setBackground(ContextCompat.getDrawable(this, R.drawable.shape_blue));
            progressBar.setVisibility(View.INVISIBLE);
        }
        loginEtId.setEnabled(enable);
        loginEtPassword.setEnabled(enable);
        loginTvSignup.setEnabled(enable);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}