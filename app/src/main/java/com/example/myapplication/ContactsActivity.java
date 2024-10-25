package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactsActivity extends AppCompatActivity {
    private String[] namesArr = new String[]{"Aktan", "Timur", "Dastan", "Tilekmat", "Temirlan", "Davlet"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        listView = findViewById(R.id.ListView);

//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.name_item, R.id.design, namesArr);
//        listView.setAdapter(adapter);
    }
    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}