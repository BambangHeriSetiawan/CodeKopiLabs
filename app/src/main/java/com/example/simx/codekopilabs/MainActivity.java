package com.example.simx.codekopilabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.simx.codekopilabs.qrcode.QrCodeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnQrCode)
    Button btnQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnQrCode)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnQrCode:
                QrCodeActivity.start(this);
                break;
        }

    }
}
