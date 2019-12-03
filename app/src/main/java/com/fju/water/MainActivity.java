package com.fju.water;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText edMonth;
boolean isNext = false;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG,getResources().getStringArray(R.array.cities)[position]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Switch sw =findViewById(R.id.sw);
                sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        isNext = isChecked;
                        TextView text = findViewById(R.id.type);
                        text.setText(isNext ? getString(R.string.every_other_month): getString(R.string.monthly));
                    }
                });

                    if (!TextUtils.isEmpty(edMonth.getText().toString())) {
                        float degree = Float.parseFloat(edMonth.getText().toString());
                        float fee = 0;
                        if (0 < degree && degree < 11) {
                            fee = 7.35f * degree;
                        } else if (10 < degree && degree < 31) {
                            fee = (9.45f * degree) - 21;
                        } else if (30 < degree && degree < 51) {
                            fee = (11.55f * degree) - 84;
                        } else {
                            fee = (12.075f * degree) - 220.5f;
                         /*new AlertDialog.Builder(MainActivity.this)
                                .setTitle("每月抄表費用")
                                .setMessage(getString(R.string.fee) +fee)
                                .setPositiveButton(getString(R.string.ok), null)
                                .show();
                          */
                        }
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("FEE", fee);
                        startActivity(intent);
                    }

                /*else{
                    if (!TextUtils.isEmpty(edNext.getText().toString())) {
                        float degree = Float.parseFloat(edNext.getText().toString());
                        float fee = 0;
                        if (0 < degree && degree < 21) {
                            fee = 7.35f * degree;
                        } else if (20 < degree && degree < 61) {
                            fee = (9.45f * degree) - 21;
                        } else if (60 < degree && degree < 101) {
                            fee = (11.55f * degree) - 84;
                        } else {
                            fee = (12.075f * degree) - 220.5f;
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("隔月抄表費用")
                                    .setMessage("費用:" + money2)
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                        intent.putExtra("FEE",fee);
                        startActivity(intent);
                    }
                }
                */
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
