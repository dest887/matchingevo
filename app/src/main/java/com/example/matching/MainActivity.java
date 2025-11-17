package com.example.matching;
import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;import android.graphics.Color;
import android.graphics.Color;
public class MainActivity extends AppCompatActivity {
    private String name;
    public static int digits=0,counterall=0,countb=0;
    private EditText editn;

    private int n1, n2, n3, n4, n5, n6, n7,counter=0;
    private TextView nu1, nu2, nu3, nu4, nu5, nu6, nu7, progress;
    private Button newc, toggleButton,score;

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
        toggleButton=findViewById(R.id.toggleButton);
        editn=findViewById(R.id.editn);
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
        scorei=new Intent(MainActivity.this,ScoreActivity.class);


        newc.setOnClickListener(v -> {
            n1 = (int) (Math.random() * 40);
            n2 = (int) (Math.random() * 40);
            n3 = (int) (Math.random() * 40);
            n4 = (int) (Math.random() * 40);
            n5 = (int) (Math.random() * 40);
            n6 = (int) (Math.random() * 40);
            counter=0;
            progress.setText(counter+"/6");
            digits+=1;
            countb=0;


            nu1.setText(String.valueOf(n1));
            nu2.setText(String.valueOf(n2));
            nu3.setText(String.valueOf(n3));
            nu4.setText(String.valueOf(n4));
            nu5.setText(String.valueOf(n5));
            nu6.setText(String.valueOf(n6));
            nu2.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nu3.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nu4.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nu5.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nu6.setBackgroundColor(Color.parseColor("#FFFFFF"));
            nu1.setBackgroundColor(Color.parseColor("#FFFFFF"));


        });

        toggleButton.setOnClickListener(v -> {
            if(countb<6&&digits!=0){
            if (!running) {
                // START
                running = true;
                toggleButton.setText("Stop");
                handler.post(updateNu7);
            } else {
                // STOP
                running = false;
                toggleButton.setText("Start");

                // Read the number in nu7
                n7 = Integer.parseInt(nu7.getText().toString());
                countb++;

                if (n7 == n1) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu1.setText("X");
                    n1 = -1;
                    counterall++;
                    nu1.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (n7 == n2) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu2.setText("X");
                    n2 = -1;
                    counterall++;
                    nu2.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (n7 == n3) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu3.setText("X");
                    n3 = -1;
                    counterall++;
                    nu3.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (n7 == n4) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu4.setText("X");
                    n4 = -1;
                    counterall++;
                    nu4.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (n7 == n5) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu5.setText("X");
                    n5 = -1;
                    counterall++;
                    nu5.setBackgroundColor(Color.parseColor("#FF0000"));
                }
                if (n7 == n6) {
                    counter++;
                    progress.setText(counter + "/6");
                    nu6.setText("X");
                    n6 = -1;
                    counterall++;
                    nu6.setBackgroundColor(Color.parseColor("#FF0000"));
                }


            }}
        });
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editn.getText().toString();
                scorei.putExtra("playerName", name);
                startActivity(scorei);
            }
        });

    }
}




