package com.example.truyenchu.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.truyenchu.R;
import com.example.truyenchu.object.PushKitActivity;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.account.AccountAuthManager;
import com.huawei.hms.support.account.request.AccountAuthParams;
import com.huawei.hms.support.account.request.AccountAuthParamsHelper;
import com.huawei.hms.support.account.result.AuthAccount;
import com.huawei.hms.support.account.service.AccountAuthService;

public class DangNhapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dkdnactivity);
        AccountAuthParams authParams = new AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM).setIdToken().createParams();
        AccountAuthService service = AccountAuthManager.getService(DangNhapActivity.this, authParams);
        startActivityForResult(service.getSignInIntent(), 8888);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 8888) {
            Task<AuthAccount> authAccountTask = AccountAuthManager.parseAuthResultFromIntent(data);
            if (authAccountTask.isSuccessful()) {
                AuthAccount authAccount = authAccountTask.getResult();
                Log.i("Admin", "idToken:" + authAccount.getIdToken());
                Intent intent = new Intent(DangNhapActivity.this, PushKitActivity.class);
                startActivity(intent);

            } else {
                // The sign-in failed. No processing is required. Logs are recorded for fault locating.
                Log.e("Admin", "sign in failed : " +((ApiException) authAccountTask.getException()).getStatusCode());
            }

        }
    }
}
