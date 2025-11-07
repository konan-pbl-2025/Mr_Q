package com.example.mr_q;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView resultText;

    public ResultActivity(Intent intent) {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // レイアウトの TextView を取得
        resultText = findViewById(R.id.resultText);

        // Intent からスコアを取得
        int score = getIntent().getIntExtra("score", 0);

        // 結果を表示
        resultText.setText("ゲーム終了！あなたのスコアは: " + score + "/10");

        Button ReturnButton = findViewById(R.id.returnButton);

        ReturnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ボタンがクリックされたらStartActivityに遷移する
                Intent intent = new Intent(ResultActivity.this, StartActivity.class);
                new ResultActivity(intent);
                finish();  // resultActivityを終了して戻らないようにする
            }
        });
    }
}