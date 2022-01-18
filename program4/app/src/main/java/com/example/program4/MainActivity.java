package com.example.program4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void verify(View v){

    AlertDialog.Builder adb=new AlertDialog.Builder(this);
    adb.setTitle("confirm exit???");
    adb.setMessage("are you sure?");
    adb.setIcon(R.drawable.img);
    adb.setCancelable(true);

    adb.setPositiveButton("yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            finish();
        }
    });

    adb.setNegativeButton("no", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            Toast.makeText(getApplicationContext(),"welcome back",Toast.LENGTH_LONG).show();
        }
    });

    adb.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            Toast.makeText(getApplicationContext(),"you clicked cancel",Toast.LENGTH_LONG).show();
        }
    });

    AlertDialog ad=adb.create();
    ad.show();
}
}