package com.example.hotel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class Reserve extends AppCompatActivity {
    EditText date;
    DatePickerDialog datepicker;
    Spinner occasionSpinner,numberSpinner,childrenSpinner;
    boolean isAllFieldsChecked = false;
    Button reserve;
    String reserve_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reserve);

        occasionSpinner =(Spinner) findViewById(R.id.occasionSpinner);
        String[] occasions = new String[]{"Select type of occasion","Casual","Breakfast","Lunch","Dinner","Birthday", "Business-meet", "Family-time","Date Night","Custom/Other"};
        ArrayAdapter<String> Adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, occasions);
        occasionSpinner.setAdapter(Adapter);


        numberSpinner =(Spinner) findViewById(R.id.numberSpinner);
        String[] numbers = new String[]{"Select number","1","2","3","4", "5", "6","7","8","9","10"};
        ArrayAdapter<String> Adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        numberSpinner.setAdapter(Adapter1);

        childrenSpinner =(Spinner) findViewById(R.id.childrenSpinner);
        String[] children = new String[]{"Select number","1","2","3","4", "5", "6","7","8","9","10"};
        ArrayAdapter<String> Adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, children);
        childrenSpinner.setAdapter(Adapter2);

        reserve = (Button) findViewById(R.id.reserve);
        reserve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                isAllFieldsChecked= checkAllFields();
                if(isAllFieldsChecked){
                    String message= "-Your reservation date is on " + reserve_date + "\n- Have a Great Day!!";
                    showMessage(message);
                }

            };
        });

        date = (EditText)findViewById(R.id.date_text);

        date.setInputType(InputType.TYPE_NULL);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                datepicker = new DatePickerDialog(Reserve.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                reserve_date= dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                                date.setText(reserve_date);
                            }
                        }, year, month, day);
                datepicker.show();
            }
        });

    }

    public boolean checkAllFields(){
        if (occasionSpinner.getSelectedItemPosition() > 0) {
            String itemvalue = String.valueOf(occasionSpinner.getSelectedItem());

        }
        else {
            TextView errorTextview = (TextView) occasionSpinner.getSelectedView();
            errorTextview.setError("Please select the occasion");
            return false;
        }
        if (numberSpinner.getSelectedItemPosition() > 0) {
            String itemvalue = String.valueOf(numberSpinner.getSelectedItem());
            return true;
        }
        else {
            TextView errorTextview = (TextView) numberSpinner.getSelectedView();
            errorTextview.setError("Please select the number");
            return false;

        }
    }

    public void showMessage(String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("RESERVATION CONFIRMED");
        builder.setMessage(message);
        builder.show();
    }
}
