package com.fju.water;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText edMonth;
EditText edNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth=findViewById(R.id.month);
        edNext=findViewById(R.id.next);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void result(View view) {
            float number = Float.parseFloat(edMonth.getText().toString());
            if (0 < number && number < 11) {
                double money = 7.35 * number;
                new AlertDialog.Builder(this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", null)
                        .show();
            } else if (10 < number && number < 31) {
                double money = (9.45 * number) - 21;
                new AlertDialog.Builder(this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", null)
                        .show();
            } else if (30 < number && number < 51) {
                double money = (11.55 * number) - 84;
                new AlertDialog.Builder(this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", null)
                        .show();
            } else {
                double money = (12.075 * number) - 220.5;
                new AlertDialog.Builder(this)
                        .setTitle("每月抄表費用")
                        .setMessage("費用:" + money)
                        .setPositiveButton("OK", null)
                        .show();

                if (!TextUtils.isEmpty(edNext.getText().toString())) {
                    float number2 = Float.parseFloat(edNext.getText().toString());
                    if (0 < number2 && number2 < 21) {
                        double money2 = 7.35 * number2;
                        new AlertDialog.Builder(this)
                                .setTitle("隔月抄表費用")
                                .setMessage("費用:" + money2)
                                .setPositiveButton("OK", null)
                                .show();
                    } else if (20 < number2 && number2 < 61) {
                        double money2 = (9.45 * number2) - 21;
                        new AlertDialog.Builder(this)
                                .setTitle("隔月抄表費用")
                                .setMessage("費用:" + money2)
                                .setPositiveButton("OK", null)
                                .show();
                    } else if (60 < number2 && number2 < 101) {
                        double money2 = (11.55 * number2) - 84;
                        new AlertDialog.Builder(this)
                                .setTitle("隔月抄表費用")
                                .setMessage("費用:" + money2)
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        double money2 = (12.075 * number2) - 220.5;
                        new AlertDialog.Builder(this)
                                .setTitle("隔月抄表費用")
                                .setMessage("費用:" + money2)
                                .setPositiveButton("OK", null)
                                .show();
                    }
                }
            }
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
