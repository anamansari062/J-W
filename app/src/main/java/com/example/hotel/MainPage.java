package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {
    TextView username_t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");

        username_t= (TextView) findViewById(R.id.username_t);
        username_t.setText("Welcome, " + username+ "  ");

        Button rb= (Button) findViewById(R.id.rb);
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rp = new Intent(MainPage.this, Book.class);
                startActivity(rp);
            }
        });

        Button tb= (Button) findViewById(R.id.tb);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tp = new Intent(MainPage.this, Reserve.class);
                startActivity(tp);
            }
        });



    }
}