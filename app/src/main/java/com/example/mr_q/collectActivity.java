package com.example.mr_q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class collectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        Button nextButton = findViewById(R.id.collect_button);
        TextView textView2 = findViewById(R.id.textView2);

        // 前の問題の解説（例）
        textView2.setText(
                MainActivity.questionStorage
                        .getQuestion(StartActivity.currentQuestionIndex)
                        .getQuestionExp()
        );

        // ★ 次のボタンを押した時の処理
        nextButton.setOnClickListener(v -> {

            // index を増やす
            StartActivity.currentQuestionIndex++;

            Intent intent;

            // ★ 10 に達したら ResultActivity へ
            if (StartActivity.currentQuestionIndex == 10) {
                intent = new Intent(collectActivity.this, ResultActivity.class);
            } else {
                // ★ 10 未満は MainActivity に戻る
                intent = new Intent(collectActivity.this, MainActivity.class);
            }

            // ★ 遷移を実行
            startActivity(intent);
            finish();
        });
    }
}
