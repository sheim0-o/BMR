package com.example.bmr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private EditText age;

    private String gen = "";

    private ImageView imageGenM;
    private ImageView imageGenW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.inputHeight);
        weight = (EditText) findViewById(R.id.inputWeight);
        age = (EditText) findViewById(R.id.inputAge);

        imageGenM = (ImageView) findViewById(R.id.genM);
        imageGenW = (ImageView) findViewById(R.id.genW);
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.btnCalculate:
                if(height.getText().toString().equals("") || weight.getText().toString().equals("")
                        || age.getText().toString().equals("") || gen.equals("")) {
                    Toast toast = Toast.makeText(this, "Введите данные!",Toast.LENGTH_LONG);
                    toast.show();
                }
                else
                {
                    Intent intent = new Intent(this, MainActivity2.class);

                    intent.putExtra("height", height.getText().toString());
                    intent.putExtra("weight", weight.getText().toString());
                    intent.putExtra("age", age.getText().toString());

                    intent.putExtra("gen", gen);

                    startActivity(intent);
                }
                break;
            case R.id.btnDelete:
                height.setText(""); weight.setText(""); age.setText("");
                break;
            case R.id.genM:
                gen = "m";
                imageGenM.setBackgroundColor(Color.parseColor("#D5D5D5"));
                imageGenW.setBackgroundColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.genW:
                gen = "w";
                imageGenM.setBackgroundColor(Color.parseColor("#FFFFFF"));
                imageGenW.setBackgroundColor(Color.parseColor("#D5D5D5"));
                break;
            default:
                break;
        }
    }
}