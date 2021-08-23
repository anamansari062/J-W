package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper user;
    Button login, register;
    TextView phone, pass;
    Boolean check=false;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login= (Button) findViewById(R.id.login_b);
        register= (Button) findViewById(R.id.register_b);
        phone= (TextView) findViewById(R.id.phone_t);
        pass= (TextView) findViewById(R.id.pass_t);

        user= new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkData()) {
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, MainPage.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username", username );
                    i.putExtras(bundle);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j= new Intent(MainActivity.this, Register.class);
                startActivity(j);
            }
        });
    }

    public boolean checkData(){
        Cursor res = user.getAllData();
        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            if(res.getString(0).equals(phone.getText().toString()) && res.getString(2).equals(pass.getText().toString()))
            {
                username= res.getString(1);
                check= true;
                break;
            }
        }
        return check;
    }
}