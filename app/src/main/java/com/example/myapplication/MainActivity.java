package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {
    private EditText userNameField, userBioField;
    private Button LogIn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNameField = findViewById(R.id.edit1);
        userBioField = findViewById(R.id.edit2);

    }

    private void SetNewFragment(Fragment fragment) {

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.commit();
    }

    public void SaveData(View view){
        String userName = userNameField.getText().toString();
        String userBio = userBioField.getText().toString();

        try {
            FileOutputStream fileOutput = openFileOutput("user_data.txt", MODE_PRIVATE);
            fileOutput.write((userName + ". " + userBio).getBytes());
            fileOutput.close();

            userNameField.setText("");
            userBioField.setText("");
            Toast.makeText(this, "Saved text", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "GEt THe Freak Up", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "GEt THe Freak Up", Toast.LENGTH_SHORT).show();

        }
    }
    public void GetData(View view){
        try {
            FileInputStream fileInput = openFileInput("user_data.txt");
            InputStreamReader reader = new InputStreamReader(fileInput);
            BufferedReader br = new BufferedReader(reader);

            StringBuilder stringBuffer = new StringBuilder();
            String lines = "", result = "";
            while ((lines = br.readLine()) != null){
                stringBuffer.append(lines + "\n");
            }
            Toast.makeText(this, stringBuffer, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void goToClowns(View view){
        Intent intent = new Intent(this, ContactsActivity.class);
        startActivity(intent);
    }
    public void onClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }


}