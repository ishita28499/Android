package com.example.program2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    fragment1 frag1;
    fragment2 frag2;
    Button button;

    int showf=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1=new fragment1();
        frag2=new fragment2();
        button=findViewById(R.id.button);
        button.setText("Open fragment 2");

        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        ft.add(R.id.cl,frag1);
        ft.commit();

        showf=1;



    }

    public void click(View v){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(showf==1)
        {
            ft.replace(R.id.cl,frag2);
            button.setText("Open fragment 1");
            showf=2;
            ft.commit();
        }
        else
        {
            ft.replace(R.id.cl,frag1);
            button.setText("Open fragment 2");
            showf=1;
            ft.commit();
        }

    }
}