package com.example.hotel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Booking extends AppCompatActivity {
    TextView price_t;
    Integer price;
    Button confirm_b, back_b;
    RadioButton online, offline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        Bundle bundle = getIntent().getExtras();
        price= bundle.getInt("price");

        price_t= (TextView) findViewById(R.id.price_t);
        confirm_b= (Button) findViewById(R.id.confirm_b);
        back_b= (Button) findViewById(R.id.back);

        online= (RadioButton) findViewById(R.id.radioButton);
        online.setEnabled(false);
        offline= (RadioButton) findViewById(R.id.radioButton2);

        price_t.setText(String.valueOf(price)+ " INR");

        confirm_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(offline.isChecked() || online.isChecked())
                {
                    String message= "- CHECK-IN TIME IS 12PM\n- CHECK-OUT TIME IS 1PM\n- Enjoy your stay!!";
                    showMessage(message);
                }
                else
                    Toast.makeText(getApplicationContext(), "Add payment method", Toast.LENGTH_SHORT).show();

            }
        });

        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Booking.this, MainPage.class);
                startActivity(intent);
            }
        });
    }

    public void showMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("BOOKING CONFIRMED");
        builder.setMessage(message);
        builder.show();
    }
}