package com.example.twobuttons;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<String> data = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            data.add("Значение в списке № " + i);
        }

        adapter = new RVAdapter(data);
        recyclerView.setAdapter(adapter);

        Button buttonDatePicker = findViewById(R.id.button_date_picker);
        Button buttonTimePicker = findViewById(R.id.button_time_picker);

        buttonDatePicker.setOnClickListener(v -> {
            showDatePickerDialog();
            Toast.makeText(MainActivity.this, "Выбран DatePickerDialog", Toast.LENGTH_SHORT).show();
        });

        buttonTimePicker.setOnClickListener(v -> {
            showTimePickerDialog();
            Toast.makeText(MainActivity.this, "Выбран TimePickerDialog", Toast.LENGTH_SHORT).show();
        });

        showAlertDialog();
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, year, month, dayOfMonth) -> {
                    // Handle the date selection
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (view, hourOfDay, minute) -> {
                    // Handle the time selection
                }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true);
        timePickerDialog.show();
    }

    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Привет!")
                .setMessage("По заданию нужно показать AlertDialog")
                .setPositiveButton("OK", null)
                .show();
    }
}