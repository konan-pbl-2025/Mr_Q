package com.example.mr_q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class discollectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discollect);

        Button nextButton = findViewById(R.id.discollectNext);
        TextView discollctEXP = findViewById(R.id.discollectEXP);

        // MainActivityからインデックスを受け取る
        final int currentIndex = getIntent().getIntExtra("currentIndex", 0);

        discollctEXP.setText(MainActivity.questionStorage.getQuestion(currentIndex - 1).getQuestionExp());

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // インデックスを1増やして次の問題に進む
                Intent intent = new Intent(discollectActivity.this, MainActivity.class);
                intent.putExtra("currentIndex", currentIndex);  // ここでもインデックスをそのまま渡す
                startActivity(intent);
            }
        });
    }
}
