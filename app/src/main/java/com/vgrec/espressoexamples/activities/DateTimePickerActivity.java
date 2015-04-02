package com.vgrec.espressoexamples.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.vgrec.espressoexamples.R;

import java.util.Calendar;

public class DateTimePickerActivity extends ActionBarActivity {

    private TextView statusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time_picker);

        statusTextView = (TextView) findViewById(R.id.status);

        findViewById(R.id.date_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        findViewById(R.id.time_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                updateStatusView(hourOfDay + ":" + minute);
            }
        }, hour, minute, true);
        timePicker.setTitle("Pick a time");
        timePicker.show();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                updateStatusView(year + "/" + monthOfYear + "/" + dayOfMonth);
            }
        }, 2015, 0, 1);
        datePicker.setTitle("Pick a date");
        datePicker.show();
    }

    private void updateStatusView(String date) {
        statusTextView.setText(date);
    }

}
