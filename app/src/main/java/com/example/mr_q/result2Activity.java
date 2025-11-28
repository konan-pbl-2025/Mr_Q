package com.example.mr_q;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Button rButton = findViewById(R.id.rButton);

        TextView textView = findViewById(R.id.textView);

        textView.setText(String.valueOf("あなたの最終スコアは"+ StartActivity.score + "点です。"));
        rButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ボタンがクリックされたらMainActivityに遷移する
                StartActivity.currentQuestionIndex = 0;
                StartActivity.score = 0;
                Intent intent = new Intent(result2Activity.this, StartActivity.class);
                startActivity(intent);
                //finish();  // StartActivityを終了して戻らないようにする
            }
        });
    }
}