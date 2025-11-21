package com.example.mr_q;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    public static int currentQuestionIndex = 0; // 現在の問題インデックス
    public static int score = 0; // ユーザーのスコア

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button StartButton = findViewById(R.id.startButton);

        StartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ボタンがクリックされたらMainActivityに遷移する
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  // StartActivityを終了して戻らないようにする
            }
        });
    }
}



