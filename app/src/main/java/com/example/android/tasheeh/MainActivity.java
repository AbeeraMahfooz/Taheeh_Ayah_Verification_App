package com.example.android.tasheeh;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.ayah);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, options.class);
                //startActivity(j);
                verifyPermissions(j);
            }
        });


        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ref = new Intent(MainActivity.this, reference.class);
                startActivity(ref);


            }
        });

    }
    private void verifyPermissions(Intent j){
        Log.d(TAG, "verifyPermissions: asking user for permissions");
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[1]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(this.getApplicationContext(),
                permissions[2]) == PackageManager.PERMISSION_GRANTED){
            startActivity(j);
        }else{
            ActivityCompat.requestPermissions(MainActivity.this,
                    permissions,
                    REQUEST_CODE);
        }
    }
   /* @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        verifyPermissions();
    }*/

}
