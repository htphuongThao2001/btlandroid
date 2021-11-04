package com.example.truyenchu.object;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.truyenchu.R;
import com.example.truyenchu.activity.DangNhapActivity;
import com.example.truyenchu.activity.MainActivity;
import com.example.truyenchu.activity.SplashActivity;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;

public class PushKitActivity extends AppCompatActivity {
    Button btnPushkit;

    private static final String TAG = "PushKitActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_kit);
        btnPushkit = findViewById(R.id.btnPushkit);
        btnPushkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PushKitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
            getPushToken();

    }


    private void sendRedTokenToServer(String token) {
        Log.i(TAG, "sending token to server. token:" + token);
    }


    private void getPushToken() {

        showLog("getToken:begin");

        new Thread() {
            @Override
            public void run() {
                try {
                    // read from agconnect-services.json
                    String appId = "Please enter your App_Id from agconnect-services.json ";
                    String token = HmsInstanceId.getInstance(PushKitActivity.this).getToken(appId, "HCM");
                    Log.i(TAG, "get token:" + token);
                    if(!TextUtils.isEmpty(token)) {
                        sendRedTokenToServer(token);
                    }

                    showLog("get token:" + token);
                } catch (ApiException e) {
                    Log.e(TAG, "get token failed, " + e);
                    showLog("get token failed, " + e);
                }
            }
        }.start();
    }

    private void showLog(String s) {
    }
}
