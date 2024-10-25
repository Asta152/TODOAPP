package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText name, surname, group;
    Button login;
    MyDatabase myDatabase = new MyDatabase(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myDatabase.getWritableDatabase();
        myDatabase.getReadableDatabase();

        name = findViewById(R.id.Name);
        surname = findViewById(R.id.Surname);
        group = findViewById(R.id.Group);
        login = findViewById(R.id.Log);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getName = name.getText().toString().trim();
                String getSurname = surname.getText().toString().trim();
                String getGroup = group.getText().toString().trim();
                long result = myDatabase.InsertUser(getName, getSurname, getGroup);

                if(result != -1){
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
    public void Cancel(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}