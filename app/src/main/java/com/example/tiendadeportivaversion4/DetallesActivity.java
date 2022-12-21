package com.example.tiendadeportivaversion4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetallesActivity extends AppCompatActivity {
    private Button btnInfo;
    private TextView textNameInfo, textDescriptionInfo, textPriceInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        btnInfo = (Button) findViewById(R.id.btnInfo);
        textNameInfo = (TextView) findViewById(R.id.textNameInfo);
        textDescriptionInfo = (TextView) findViewById(R.id.textDescriptionInfo);
        textPriceInfo = (TextView) findViewById(R.id.textPriceInfo);

        Intent intentIN = getIntent();
        textNameInfo.setText(intentIN.getStringExtra("name"));
        textDescriptionInfo.setText(intentIN.getStringExtra("description"));
        textPriceInfo.setText(new StringBuilder().append("$").append(String.valueOf(intentIN.getStringExtra("price"))).toString());

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finish();
            }
        });

    }
}