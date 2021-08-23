package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Select_room extends AppCompatActivity {
    Button single_b, double_b, queen_b, king_b, suite_b, msuite_b;
    Integer price, room_price;
    TextView single_p, double_p, queen_p, king_p, msuite_p, suite_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);

        single_b= (Button) findViewById(R.id.single_b);
        double_b= (Button) findViewById(R.id.double_b);
        queen_b= (Button) findViewById(R.id.queen_b);
        king_b= (Button) findViewById(R.id.king_b);
        suite_b= (Button) findViewById(R.id.suite_b);
        msuite_b= (Button) findViewById(R.id.msuite_b);

        Bundle bundle = getIntent().getExtras();
        Integer total_day= bundle.getInt("total_day");
        Integer total_room= bundle.getInt("total_room");

        single_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 5400;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

        double_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 6300;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

        queen_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 7000;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

        king_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 7200;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

        suite_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 8000;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });

        msuite_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price= total_day * total_room * 9500;
                Intent intent= new Intent(Select_room.this, Booking.class);
                Bundle mybundle = new Bundle();
                mybundle.putInt("price", price );
                intent.putExtras(mybundle);
                startActivity(intent);
            }
        });


    }
}