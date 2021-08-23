package com.example.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Book extends AppCompatActivity {
    Button rmin, rplus, amin, aplus, cmin, cplus, find;
    TextView room, adult, child;
    EditText date_in, date_out;
    Integer num_room=0, num_adult=0, num_child=0, total_room, num1, num2;
    String room_text, adult_text, child_text;
    DatePickerDialog datepicker1, datepicker2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        rmin = (Button) findViewById(R.id.rmin);
        rplus = (Button) findViewById(R.id.rplus);
        amin = (Button) findViewById(R.id.amin);
        cmin = (Button) findViewById(R.id.cmin);
        aplus = (Button) findViewById(R.id.aplus);
        cplus = (Button) findViewById(R.id.cplus);

        room = (TextView) findViewById(R.id.room);
        adult = (TextView) findViewById(R.id.adult);
        child= (TextView) findViewById(R.id.child);

        date_in = (EditText)findViewById(R.id.date_in_t);
        date_out = (EditText)findViewById(R.id.date_out_t);

        find= (Button) findViewById(R.id.find);

        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");

        rplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_room+= 1;
                room_text= Integer.toString(num_room);
                room.setText(room_text);
            }
        });

        date_in.setInputType(InputType.TYPE_NULL);
        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                datepicker1 = new DatePickerDialog(Book.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String check_in= dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                date_in.setText(check_in);
                                num1= dayOfMonth;
                            }
                        }, year, month, day);
                datepicker1.show();
            }
        });

        date_out.setInputType(InputType.TYPE_NULL);
        date_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                datepicker2 = new DatePickerDialog(Book.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String check_out= dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                date_out.setText(check_out);
                                num2= dayOfMonth;
                            }
                        }, year, month, day);
                datepicker2.show();
            }
        });

        aplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_adult+= 1;
                adult_text= Integer.toString(num_adult);
                adult.setText(adult_text);
            }
        });

        cplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num_child+= 1;
                child_text= Integer.toString(num_child);
                child.setText(child_text);
            }
        });

        rmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(room.getText()!="0") {
                    num_room -= 1;
                    room_text = Integer.toString(num_room);
                    room.setText(room_text);
                }
            }
        });

        amin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult_text!="0") {
                    num_adult -= 1;
                    adult_text = Integer.toString(num_adult);
                    adult.setText(adult_text);
                }
            }
        });

        cmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(child_text!="0") {
                    num_child -= 1;
                    child_text = Integer.toString(num_child);
                    child.setText(child_text);
                }
            }
        });

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer total_day= num2- num1;
                total_room= Integer.parseInt(room.getText().toString());
                Intent myIntent = new Intent(Book.this, Select_room.class);
                Bundle bundle = new Bundle();
                bundle.putInt("total_day", total_day );
                bundle.putInt("total_room", total_room );
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });




    }
}