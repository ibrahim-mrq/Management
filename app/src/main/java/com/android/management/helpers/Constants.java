package com.android.management.helpers;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.android.management.R;
import com.android.management.controller.activities.LoginActivity;
import com.orhanobut.hawk.Hawk;

public class Constants {

    public final static String USER_TOKEN = "user_token";
    public final static String USER_ID = "user_id";
    public final static String USER_NAME = "user_name";
    public final static String USER = "user";
    public final static String IS_LOGIN = "is_login";

    public final static String KEY = "key";
    public final static String TYPE = "type";
    public final static String TYPE_ADD = "type_add";
    public final static String TYPE_EDIT = "type_edit";
    public final static String TYPE_MODEL = "type_mode;";

    public final static int REQUEST_GALLERY_CODE = 10001;

    public static void logout(Activity context) {
        Hawk.deleteAll();
        Toast.makeText(context, context.getString(R.string.logout_successfully), Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, LoginActivity.class));
        context.finish();
    }

}
