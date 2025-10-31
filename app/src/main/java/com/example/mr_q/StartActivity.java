package com.example.mr_q;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.id.questionText);

        Button startButton = findViewById(R.id.activity_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ボタンがクリックされたらMainActivityに遷移する
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  // StartActivityを終了して戻らないようにする
            }
        });
    }
}



