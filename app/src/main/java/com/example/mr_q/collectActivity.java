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

        textView2.setText(MainActivity.questionStorage.getQuestion().getQuestionExp());


        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // インデックスを1増やして次の問題に進む
                StartActivity.currentQuestionIndex++;  // 次の問題のインデックスを渡す
                if (StartActivity.currentQuestionIndex < 10) {
                    Intent intent = new Intent(collectActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(StartActivity.currentQuestionIndex >= 10) {
                    Intent intent = new Intent(collectActivity.this, ResultActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
