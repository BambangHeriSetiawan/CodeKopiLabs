package com.example.simx.codekopilabs.qrcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.simx.codekopilabs.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class QrCodeActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, QrCodeActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnGenerate, R.id.btnRead})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnGenerate:
                GenerateQrCodeActivity.start(this);
                break;
            case R.id.btnRead:
                ReadQrCodeActivity.start(this);
                break;
        }
    }
}
