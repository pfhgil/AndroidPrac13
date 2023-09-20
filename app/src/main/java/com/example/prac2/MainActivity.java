package com.example.prac2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    private EditText dateText;
    private EditText timeText;

    private Button chooseDateButton;
    private Button chooseTimeButton;

    private Button enlistButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        dateText = findViewById(R.id.editTextDate);
        timeText = findViewById(R.id.editTextTime);

        chooseDateButton = findViewById(R.id.chooseDateBtn);
        chooseTimeButton = findViewById(R.id.chooseTimeBtn);

        enlistButton = findViewById(R.id.enlistButton);

        chooseDateButton.setOnClickListener(view -> {
            int chosenYear = 2023;
            int chosenMonth = 9;
            int chosenDay = 19;

            DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, i, i1, i2) -> {
                dateText.setText("" + i + "." + (i1 + 1) + "." + i2);
            };

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                    chosenYear, chosenMonth, chosenDay);

            datePickerDialog.show();
        });

        chooseTimeButton.setOnClickListener(view -> {
            boolean is24HView = true;
            int chosenHour = 9;
            int chosenMinute = 19;

            TimePickerDialog.OnTimeSetListener timeSetListener = (timePicker, i, i1) -> {
                timeText.setText(i + ":" + i1);
            };

            TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener,
                    chosenHour, chosenMinute, is24HView);

            timePickerDialog.show();
        });

        enlistButton.setOnClickListener(view -> {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);

            alertBuilder.setTitle("Record confirmation")
                        .setMessage("Are you sure you want to see a doctor?")
                        .setPositiveButton("Confirm", (dialogInterface, i) -> {
                            dialogInterface.cancel();
                            Toast.makeText(this, "Record confirmed", Toast.LENGTH_SHORT).show();
                        })
                        .setNegativeButton("Cancel", (dialogInterface, i) -> {
                            dialogInterface.dismiss();
                            Toast.makeText(this, "Record dismissed", Toast.LENGTH_SHORT).show();
                        })
                        .create();

            alertBuilder.show();
        });
    }
}
