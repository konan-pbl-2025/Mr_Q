package com.example.mr_q;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class discollectActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer; // MediaPlayerインスタンスを// 宣言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discollect);

        Button nextButton = findViewById(R.id.discollectNext);
        TextView discollctEXP = findViewById(R.id.discollectEXP);
        // 1. MediaPlayerを初期化し、音源をロードする
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.discorrect); // ★R.raw.correct_sound はres/rawフォルダのファイル名

        // 2. 音の再生を開始する
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

        // 3. 再生が完了したらリソースを解放するリスナーを設定
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(mp -> mp.release());
        }


        discollctEXP.setText(MainActivity.questionStorage.getQuestion().getQuestionExp());

        nextButton.setOnClickListener(v -> {

            // index を増やす
            StartActivity.currentQuestionIndex++;

            Intent intent;

            // ★ 10 に達したら ResultActivity へ
            if (StartActivity.currentQuestionIndex == 10) {
                intent = new Intent(discollectActivity.this, ResultActivity.class);
            } else {
                // ★ 10 未満は MainActivity に戻る
                intent = new Intent(discollectActivity.this, MainActivity.class);
            }

            // ★ 遷移を実行
            startActivity(intent);
            finish();
        });
    }
}

