package com.example.mac13.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetDataActivity extends AppCompatActivity implements View.OnClickListener {


    Button pass, m, f;
    EditText firstName, lastName, age;
    String FirstName, LastName, Gender;
    Integer Age;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_data);

        findViewById();

        i = new Intent();
        pass.setOnClickListener(this);
        m.setOnClickListener(this);
        f.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonPass:
                if (validate()) {
                    FirstName = firstName.getText().toString();

                    LastName = lastName.getText().toString();
                    Age = Integer.parseInt(age.getText().toString());

                    if (m.isSelected()) {
                        Gender = "Male";
                    }
                    if (f.isSelected()) {
                        Gender = "Female";
                    }
                    i.putExtra("firstName", FirstName);
                    i.putExtra("lastName", LastName);
                    i.putExtra("age", Age);
                    i.putExtra("gender", Gender);

                    setResult(RESULT_OK, i);
                    finish();
                } else {
                    Toast.makeText(GetDataActivity.this, "Values aren't valid!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonF:
                f.setSelected(true);
                m.setSelected(false);
                break;
            case R.id.buttonM:
                f.setSelected(false);
                m.setSelected(true);
                break;
        }
    }


    public void findViewById() {

        firstName = (EditText) findViewById(R.id.editTextFirstName);
        lastName = (EditText) findViewById(R.id.editTextLastName);

        age = (EditText) findViewById(R.id.editTextAge);

        pass = (Button) findViewById(R.id.buttonPass);
        f = (Button) findViewById(R.id.buttonF);
        m = (Button) findViewById(R.id.buttonM);
    }

    public boolean validate() {
        boolean valid = true;
        if(firstName.getText().length()==0){
            firstName.setError("First Name is required!");
            valid = false;
        }
        if(lastName.getText().length()==0){
            lastName.setError("Last Name is required!");
            valid = false;
        }
        if(age.getText().length()==0){
            age.setError("Age is required!");
            valid = false;
        }
        if (!f.isSelected() && !m.isSelected()) {
            valid = false;
        }
        return valid;
    }
}
