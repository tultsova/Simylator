package com.example.simulator;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    int xp;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        TextView textView = findViewById(R.id.points);
        ImageView imageView =(ImageView)findViewById(R.id.imageView);
        TextView textView2 = findViewById(R.id.age);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        dialog = new Dialog(this);
        View.OnClickListener OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button1: {xp+=2; textView.setText(String.valueOf(xp)); break;}
                    case R.id.button2: {xp+=1; textView.setText(String.valueOf(xp)); break;}
                    case R.id.button3: {xp+=3; textView.setText(String.valueOf(xp)); break;}
                    case R.id.button4: {xp+=4; textView.setText(String.valueOf(xp)); break;}
                }

                if (xp>=50 && xp<100) {
                    textView2.setText("Уровень: Школьник");
                    button3.setText("Залипать в соцсетях");
                    button4.setText("Сделать уроки");
                    imageView.setImageResource(R.drawable.school_girl);
                }
                if (xp>=100 && xp<150) {
                    textView2.setText("Уровень: Взрослый");
                    button3.setText("Работать");
                    button4.setText("Встретиться с друзьями");
                    imageView.setImageResource(R.drawable.woman);
                }
                if (xp>=150 && xp<200) {
                    textView2.setText("Уровень: Старик");
                    button3.setText("Посмотреть передачу на Первом");
                    button4.setText("Сидеть на лавочке");
                    imageView.setImageResource(R.drawable.old_woman);
                }
                if (xp>200) {
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setContentView(R.layout.previewdialog);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                    button5 = (Button)dialog.findViewById(R.id.button5);
                    button5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            try {
                                Intent intent = new Intent(GameActivity.this, GameActivity.class);
                                startActivity(intent);
                                finish();
                            } catch (Exception e) {}
                            dialog.dismiss();
                        }
                    });
                    dialog.show();}
            }
        };
        button1.setOnClickListener(OnClickListener);
        button2.setOnClickListener(OnClickListener);
        button3.setOnClickListener(OnClickListener);
        button4.setOnClickListener(OnClickListener);

    }

}

