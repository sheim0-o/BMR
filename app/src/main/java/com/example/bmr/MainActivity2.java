package com.example.bmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private static final String TAG = "Activity2";

    private TextView outputBMR;

    private TextView outputCal1;
    private TextView outputCal2;
    private TextView outputCal3;
    private TextView outputCal4;
    private TextView outputCal5;

    public Double BMR;
    public String gen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        outputBMR = (TextView) findViewById(R.id.outputBMR);

        outputCal1 = (TextView) findViewById(R.id.outputCal1);
        outputCal2 = (TextView) findViewById(R.id.outputCal2);
        outputCal3 = (TextView) findViewById(R.id.outputCal3);
        outputCal4 = (TextView) findViewById(R.id.outputCal4);
        outputCal5 = (TextView) findViewById(R.id.outputCal5);

        String txtHeight = getIntent().getStringExtra("height");
        String txtWeight = getIntent().getStringExtra("weight");
        String txtAge = getIntent().getStringExtra("age");

        gen = getIntent().getStringExtra("gen");

        double numWeight = Double.parseDouble(txtWeight);
        double numHeight = Double.parseDouble(txtHeight);
        double numAge = Double.parseDouble(txtAge);

        if(gen.equals("m"))
            BMR = 66 + (13.7 * numWeight) + (5 * numHeight) - (6.8 * numAge);
        else if(gen.equals("w"))
            BMR = 655 + (9.6 * numWeight) + (1.8 * numHeight) - (4.7 * numAge);

        BMR = (Math.floor(BMR))/1000;
        outputBMR.setText(String.valueOf(BMR));

        outputCal1.setText(String.valueOf((Math.floor(BMR * 1200))/1000));
        outputCal2.setText(String.valueOf((Math.floor(BMR * 1375))/1000));
        outputCal3.setText(String.valueOf((Math.floor(BMR * 1550))/1000));
        outputCal4.setText(String.valueOf((Math.floor(BMR * 1725))/1000));
        outputCal5.setText(String.valueOf((Math.floor(BMR * 1900))/1000));
    }

    public void onClickInfo(View v) {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.act2_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.info:
                Intent intent = new Intent(this, MainActivity4.class);
                startActivity(intent);
                return true;
            case R.id.log:
                Log.i(TAG, "Пол: " + gen + ", BMR: " + BMR);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}