package com.sashamakkar.medicare;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    public static final int CAMERA_CODE = 123;
    ReportAdapter reportAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report_activity);

        RecyclerView rvReport = findViewById(R.id.rvReport);
        RecyclerView.LayoutManager reportLayout = new GridLayoutManager(this, 2);
        rvReport.setLayoutManager(reportLayout);

        reportAdapter = new ReportAdapter(new ArrayList<Report>());
        rvReport.setAdapter(reportAdapter);

        FloatingActionButton fabReport = findViewById(R.id.fabReport);

        fabReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reportIntent = new Intent(Intent.ACTION_GET_CONTENT);
                reportIntent.setType("image/*");
                startActivityForResult(Intent.createChooser(reportIntent, "Complete Action Using:"), CAMERA_CODE);
            }
        });
    }

    Bitmap mBitmap = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_CODE && resultCode == RESULT_OK){
            Uri data_uri = data.getData();
            reportAdapter.addNewImage(data_uri);
        }

    }
}
