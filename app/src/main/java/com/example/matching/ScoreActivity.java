package com.example.matching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    private Button back;
    private TextView noc,nog;
    private Intent backi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score);
        back=findViewById(R.id.back);
        noc=findViewById(R.id.noc);
        nog=findViewById(R.id.nog);
        noc.setText(MainActivity.digits+"");
        nog.setText(MainActivity.counterall+"");
        backi=new Intent(ScoreActivity.this,MainActivity.class);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(backi);
            }
        });


        };
    }
