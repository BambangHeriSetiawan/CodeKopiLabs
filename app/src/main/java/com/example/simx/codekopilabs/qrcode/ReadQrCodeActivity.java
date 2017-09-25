package com.example.simx.codekopilabs.qrcode;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.simx.codekopilabs.R;

public class ReadQrCodeActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, ReadQrCodeActivity.class);
        context.startActivity(starter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_qr_code);
    }
}
