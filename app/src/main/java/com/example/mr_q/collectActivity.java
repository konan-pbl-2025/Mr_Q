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
        // MainActivityからインデックスを受け取る
        final int currentIndex = getIntent().getIntExtra("currentIndex", 0);
        int x = currentIndex;
        //textView2.setText(getQuestion(currentIndex));


        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // インデックスを1増やして次の問題に進む
                Intent intent = new Intent(collectActivity.this, MainActivity.class);
                intent.putExtra("currentIndex", currentIndex);  // ここではインデックスをそのまま渡す
                startActivity(intent);
            }
        });
    }
}
