package com.example.differentactivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setTitle("HOME");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void launchSettings (View v){
        //launch a new activity
        Intent i = new Intent(this, SettingsActivity.class);
        String message = ((EditText) findViewById(R.id.editTextText)).getText().toString();
        i.putExtra("COOL", message);
        startActivity(i);
    }

    public void launchExplorer (View v){
        //launch a new activity
//        Intent j = new Intent(this, ExplorerActivity.class);
//        startActivity(j);
    }

    public void composeMessage(View v){
        Intent i = new Intent(this, SettingsActivity.class);
        String name = ((Button)v).getText().toString();
        i.putExtra("NAME", name);
        startActivity(i);
    }
}