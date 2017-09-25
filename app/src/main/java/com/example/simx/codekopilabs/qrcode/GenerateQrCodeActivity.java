package com.example.simx.codekopilabs.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.simx.codekopilabs.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class GenerateQrCodeActivity extends AppCompatActivity {
    @BindView(R.id.etQr)
    TextInputEditText etQr;
    @BindView(R.id.imgQr)
    ImageView imgQr;
    @BindView(R.id.btnGenerateCode)
    Button btnGenerateCode;

    public static void start(Context context) {
        Intent starter = new Intent(context, GenerateQrCodeActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qr_code);
        ButterKnife.bind(this);
    }
    private String code;
    @OnTextChanged(value = R.id.etQr, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void GenerateCode(CharSequence sequence) {
        code = etQr.getText().toString();
        if (code.length() > 6) {
           btnGenerateCode.setVisibility(View.VISIBLE);
        } else {
            btnGenerateCode.setVisibility(View.GONE);
        }
    }

    private Thread thread;
    private Bitmap bitmap;

    private void gengerateQR(String code) {
        try {
            bitmap = textToImageEncode(code);
            imgQr.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public Bitmap textToImageEncode(String s) throws WriterException {
        BitMatrix bitMatrix;

        try {
            bitMatrix = new MultiFormatWriter().encode(s, BarcodeFormat.QR_CODE, 500, 500, null);
        } catch (IllegalArgumentException e) {
            Log.e(GenerateQrCodeActivity.class.getCanonicalName(), "textToImageEncode: " + e.getMessage());
            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];
        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.colorBlack) : getResources().getColor(R.color.colorWhite);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }

    public static ProgressDialog showProgre(Context context) {
        ProgressDialog p = new ProgressDialog(context);
        p.setMessage("loadin...");
        p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return p;
    }

    @OnClick(R.id.btnGenerateCode)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnGenerateCode:
                gengerateQR(code);
                break;
        }
    }
}
