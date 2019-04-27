package com.sashamakkar.medicare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        ImageView ivPrescription = findViewById(R.id.ivPresc);
        ImageView ivReport = findViewById(R.id.ivReport);
        Button prescriptions = findViewById(R.id.prescriptions);
        Button reports = findViewById(R.id.reports);
        Button reminders = findViewById(R.id.reminder);


        prescriptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prescIntent = new Intent(MainActivity.this, PrescriptionActivity.class);
                startActivity(prescIntent);
            }
        });

        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportIntent = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(reportIntent);
            }
        });

        reminders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reminderIntent = new Intent(MainActivity.this, ReminderActivity.class);
                startActivity(reminderIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.menu_new_content_addChangeUser){

        }
        return super.onOptionsItemSelected(item);
    }
}
