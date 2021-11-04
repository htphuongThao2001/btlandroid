package com.example.truyenchu;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class DemoHmsMessageService extends com.huawei.hms.push.HmsMessageService {

        @Override
        public void onMessageSent(String s) {
            super.onMessageSent(s);
        }
        //private static final String TAG = "PushDemoLog";




    }
