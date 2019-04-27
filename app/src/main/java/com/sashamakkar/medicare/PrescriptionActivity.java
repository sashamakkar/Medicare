package com.sashamakkar.medicare;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.login.LoginException;

public class PrescriptionActivity extends AppCompatActivity {


    public static final int CAMERA_CODE = 123;
    PrescriptionAdapter prescriptionAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presc_activity);


        RecyclerView rvPresc = findViewById(R.id.rvPresc);
        final RecyclerView.LayoutManager prescLayout = new GridLayoutManager(this, 2);
        rvPresc.setLayoutManager(prescLayout);

        prescriptionAdapter = new PrescriptionAdapter(new ArrayList<Prescription>());
        rvPresc.setAdapter(prescriptionAdapter);

        FloatingActionButton fabPresc = findViewById(R.id.fabPresc);

        fabPresc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent presIntent = new Intent(Intent.ACTION_GET_CONTENT);
                presIntent.setType("image/*");
                startActivityForResult(Intent.createChooser(presIntent, "Complete Action Using:"), CAMERA_CODE);
            }
        });
    }

    Bitmap mBitmap = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_CODE && resultCode == RESULT_OK){
            Uri data_uri = data.getData();
            Log.e("TAG", "onActivityResult: " + data_uri);

            prescriptionAdapter.addNewImage(data_uri);

            try {
                mBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data_uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            mBitmap .compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();


            String fileName = "Report";
            FileOutputStream outputStream = null;
            try
            {
                outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);
                outputStream.write(byteArray);
                outputStream.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}

