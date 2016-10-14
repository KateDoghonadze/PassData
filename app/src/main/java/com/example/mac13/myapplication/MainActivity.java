package com.example.mac13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button buttonGetData;
    public static final int DataActivity = 1;
    String FirstName, LastName, Gender;
    Integer Age;
    TextView textViewFirstName, textViewLastName, textViewAge, textViewGender;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById();
        buttonGetData.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonGetData:
                startActivityForResult(new Intent(MainActivity.this, GetDataActivity.class), DataActivity);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK:
                FirstName = data.getStringExtra("firstName");
                LastName = data.getStringExtra("lastName");
                Age = data.getIntExtra("age", 0);
                Gender = data.getStringExtra("gender");


                buttonGetData.setVisibility(View.INVISIBLE);
                textViewFirstName.setVisibility(View.VISIBLE);
                textViewLastName.setVisibility(View.VISIBLE);
                textViewAge.setVisibility(View.VISIBLE);
                textViewGender.setVisibility(View.VISIBLE);
                imageView.setVisibility(View.VISIBLE);

                textViewFirstName.setText(FirstName);
                textViewLastName.setText(LastName);
                textViewAge.setText(Age.toString());
                textViewGender.setText(Gender);

                if (Gender.equals("Female")) {
                    imageView.setImageResource(R.drawable.woman);

                } else {
                    imageView.setImageResource(R.drawable.man);
                }
                break;
        }


    }


    public void findViewById() {
        textViewFirstName = (TextView) findViewById(R.id.textViewFirstName);
        textViewLastName = (TextView) findViewById(R.id.textViewLastName);

        textViewAge = (TextView) findViewById(R.id.textViewAge);
        textViewGender = (TextView) findViewById(R.id.textViewGender);
        buttonGetData = (Button) findViewById(R.id.buttonGetData);
        imageView = (ImageView) findViewById(R.id.imageView);
    }
}

