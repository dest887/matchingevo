package com.example.matching;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static int digits=0,counterall=0;

    private int n1, n2, n3, n4, n5, n6, n7,counter=0;
    private TextView nu1, nu2, nu3, nu4, nu5, nu6, nu7, progress;
    private Button newc, b1, b2,score;

    private boolean running = false;
    private Intent scorei;
    private Handler handler = new Handler();

    private final Runnable updateNu7 = new Runnable() {
        @Override
        public void run() {
            if (running) {
                n7 = (int) (Math.random() * 40);
                nu7.setText(String.valueOf(n7));
                handler.postDelayed(this, 100);
            }
        }
    };;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        score=findViewById(R.id.score);
        nu1 = findViewById(R.id.num1);
        nu2 = findViewById(R.id.num2);
        nu3 = findViewById(R.id.num3);
        nu4 = findViewById(R.id.num4);
        nu5 = findViewById(R.id.num5);
        nu6 = findViewById(R.id.num6);
        nu7 = findViewById(R.id.num7);
        score=findViewById(R.id.score);
        progress = findViewById(R.id.progress);
        progress.setText(counter+"/6");
        newc = findViewById(R.id.newc);
        b1 = findViewById(R.id.b1);
        scorei=new Intent(MainActivity.this,ScoreActivity.class);

        b2 = findViewById(R.id.b4);

        newc.setOnClickListener(v -> {
            n1 = (int) (Math.random() * 40);
            n2 = (int) (Math.random() * 40);
            n3 = (int) (Math.random() * 40);
            n4 = (int) (Math.random() * 40);
            n5 = (int) (Math.random() * 40);
            n6 = (int) (Math.random() * 40);
            counter=0;
            progress.setText(counter+"/6");
            digits+=6;

            nu1.setText(String.valueOf(n1));
            nu2.setText(String.valueOf(n2));
            nu3.setText(String.valueOf(n3));
            nu4.setText(String.valueOf(n4));
            nu5.setText(String.valueOf(n5));
            nu6.setText(String.valueOf(n6));
        });

        b1.setOnClickListener(v -> {
            running = true;
            handler.post(updateNu7);
        });

        b2.setOnClickListener(v -> {
            running = false;
            n7= Integer.parseInt(nu7.getText().toString());
            if(n7==n1){
                counter++;
                progress.setText(counter+"/6");
                nu1.setText("X");
                n1=-1;
                counterall++;
            }
            if(n7==n2){
                counter++;
                progress.setText(counter+"/6");
                nu2.setText("X");
                n2=-1;
                counterall++;
            }     if(n7==n3){
                counter++;
                progress.setText(counter+"/6");
                nu3.setText("X");
                n3=-1;
                counterall++;
            }     if(n7==n4){
                counter++;
                progress.setText(counter+"/6");
                nu4.setText("X");
                n4=-1;
                counterall++;
            }
            if(n7==n5){
                counter++;
                progress.setText(counter+"/6");
                nu5.setText("X");
                n5=-1;
                counterall++;
            }
            if(n7==n6){
                counter++;
                progress.setText(counter+"/6");
                nu6.setText("X");
                n6=-1;
                counterall++;
            }
            if(counter==6){
                nu1.setText("E");
                nu2.setText("N");
                nu3.setText("D");
                nu4.setText("G");
                nu5.setText("A");
                nu6.setText("M");
                nu7.setText("E");
            }
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(scorei);
            }
        });

    }
}




