package com.example.mr_q;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class result2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        Button rButton = findViewById(R.id.rButton);
        rButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // ボタンがクリックされたらMainActivityに遷移する
                Intent intent = new Intent(result2Activity.this, StartActivity.class);
                startActivity(intent);
                //finish();  // StartActivityを終了して戻らないようにする
            }
        });
    }
}