package com.example.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edt;
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt = findViewById(R.id.edt);
        bt1 = findViewById(R.id.startService);
        bt2 = findViewById(R.id.stopService);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStartService();
            }
        });
        
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickStopService();
            }
        });
    }

    private void clickStopService() {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }

    private void clickStartService() {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        intent.putExtra("data_intent", edt.getText().toString());
        startService(intent);
    }
}