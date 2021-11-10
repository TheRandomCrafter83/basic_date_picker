package com.coderz.f1.basicdatepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    NumberPicker month1, month2, day1, day2, year1, year2 = null;
    Button btnStartDate, btnEndDate = null;
    TextView tvStartDate, tvEndDate = null;

    String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        month1 = findViewById(R.id.month1);
        month2 = findViewById(R.id.month2);
        day1 = findViewById(R.id.day1);
        day2 = findViewById(R.id.day2);
        year1 = findViewById(R.id.year1);
        year2 = findViewById(R.id.year2);

        month1.setMinValue(0);
        month1.setMaxValue(11);
        month1.setDisplayedValues(monthNames);
        month2.setMinValue(0);
        month2.setMaxValue(11);
        month2.setDisplayedValues(monthNames);

        year1.setMinValue(2021);
        year1.setMaxValue(2021+8);
        year2.setMinValue(2021);
        year2.setMaxValue(2021+8);

        loadDays1();
        loadDays2();

        month1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                loadDays1();
            }
        });
        month2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                loadDays2();
            }
        });
        year1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                loadDays1();
            }
        });
        year2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                loadDays2();
            }
        });


        btnStartDate = findViewById(R.id.button_choose_date_start);
        btnEndDate = findViewById(R.id.button_choose_date_end);
        tvStartDate = findViewById(R.id.tv_start);
        tvEndDate = findViewById(R.id.tv_end);

        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this);
                dialog.setTitle("Choose Start Date");
                dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvStartDate.setText(new StringBuilder().append(i).append("/").append(i1).append("/").append(i2).toString());
                    }
                });
                dialog.show();
            }
        });

        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this);
                dialog.setTitle("Choose End Date");
                dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        tvEndDate.setText(new StringBuilder().append(i).append("/").append(i1).append("/").append(i2).toString());
                    }
                });
                dialog.show();
            }
        });
    }



    void loadDays1(){
        day1.setMinValue(1);
        if (year1.getValue() % 4 == 0 && month1.getValue() == 1){
            day1.setMaxValue(29);
            return;
        }
        if (month1.getValue()==1){
            day1.setMaxValue(28);
            return;
        }
        if ((month1.getValue()-1)%2==0){
            day1.setMaxValue(30);
            return;
        }
        day1.setMaxValue(31);
    }

    void loadDays2(){
        day2.setMinValue(1);
        if (year2.getValue() % 4 == 0 && month2.getValue() == 1){
            day2.setMaxValue(29);
            return;
        }
        if (month2.getValue()==1){
            day2.setMaxValue(28);
            return;
        }
        if ((month2.getValue()-1)%2==0){
            day2.setMaxValue(30);
            return;
        }
        day2.setMaxValue(31);
    }
}