package com.fju.water;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private static final String TAG = ResultActivity.class.getSimpleName();
    private static final float DEFAULT_FEE = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        float fee = getIntent().getFloatExtra(getString(R.string.extra_fee),DEFAULT_FEE);
        Log.d(TAG,fee + "");
        TextView feeText = findViewById(R.id.fee);
        int n =(int)(fee + 0.5f);
        feeText.setText(fee + " ");
    }
}
