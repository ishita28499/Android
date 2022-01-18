package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText uname,pswd;
    Button login;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.edittext);
        pswd = findViewById(R.id.edittext2);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uname.getText().toString();
                String password = pswd.getText().toString();
                int id = checkUser(new User(name, password));
                if (id == -1) {
                    Toast.makeText(MainActivity.this, "User Does Not Exist", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Username " + name + " exist", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }
            }
        });

        db = new DBHandler(MainActivity.this);

        db.addUser(new User("Ishita", "12345"));
        db.addUser(new User("Sarkar", "67890"));
        db.addUser(new User("Atul","66666"));



    }
    public int checkUser(User user)
    {
        return db.checkUser(user);
    }
}


