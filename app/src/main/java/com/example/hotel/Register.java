package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    DatabaseHelper user;
    boolean isAllFieldsChecked=false, check= false, genderchecked=false;
    Button register;
    EditText fullName,email,age,phone,pass,confpass;
    Spinner genderSpinner;
    String[] gender = new String[]{"Gender", "male", "female", "transgender", "preferred not to say"};
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName = findViewById(R.id.fullnameText);
        email= findViewById(R.id.emailText);
        age = findViewById(R.id.ageText);
        phone = findViewById(R.id.phoneText);
        pass =  findViewById(R.id.passText);
        confpass =  findViewById(R.id.confPassText);

        genderSpinner =  findViewById(R.id.genderSpinner);

        user = new DatabaseHelper(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);

        genderSpinner.setAdapter(adapter);
        genderSpinner.setPrompt("Gender");
        register = (Button) findViewById(R.id.register);

        checkData();

    }
    private boolean CheckAllFields() {

        if (fullName.length() == 0) {
            fullName.setError("This field is required!");
            return false;
        }

        if (email.length() == 0) {
            email.setError("Email is required!");
            return false;
        }

        if (pass.length() == 0) {
            pass.setError("Password is required!");
            return false;
        } else if (pass.length() < 5) {
            pass.setError("Password must be minimum 6 characters!");
        }

        if(confpass.getText().toString().equals(pass.getText().toString())){
            return true;
        }
        else {
            confpass.setError("Both passwords must match!");
            return false;
        }

    }

    public void checkData()
    {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (genderSpinner.getSelectedItemPosition() > 0) {
                    String item = String.valueOf(genderSpinner.getSelectedItem());
                    genderchecked= true;
                }
                else {
                    // set error message on spinner
                    TextView errorTextview = (TextView) genderSpinner.getSelectedView();
                    errorTextview.setError("This field is required");
                }

                isAllFieldsChecked = CheckAllFields();



                if (isAllFieldsChecked && genderchecked) {
                    Cursor res = user.getAllData();
                    StringBuffer buffer = new StringBuffer();
                    while (res.moveToNext()) {
                        if(res.getString(0).equals(phone.getText().toString()))
                        {
                            check= true;
                            break;
                        }
                    }
                    if(check){
                        Toast.makeText(getApplicationContext(), "This phone number already exists", Toast.LENGTH_LONG).show();}
                    else{
                        AddData();
                    }
                    Intent i = new Intent(Register.this, MainPage.class);
                    startActivity(i);
                }
            }
        });
    }

    public void AddData() {
        boolean isInserted = user.insertData(phone.getText().toString(), fullName.getText().toString(), pass.getText().toString());
        if (isInserted = true)
            Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getApplicationContext(), "Registration failed", Toast.LENGTH_LONG).show();
    }


}
