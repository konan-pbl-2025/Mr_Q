package com.example.mr_q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class collectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        Button nextButton = findViewById(R.id.collect_button);

        // MainActivityからインデックスを受け取る
        final int currentIndex = getIntent().getIntExtra("currentIndex", 0);

        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // インデックスを1増やして次の問題に進む
                Intent intent = new Intent(collectActivity.this, MainActivity.class);
                intent.putExtra("currentIndex", currentIndex + 1);  // インデックスを1加算
                startActivity(intent);
            }
        });
    }
}
