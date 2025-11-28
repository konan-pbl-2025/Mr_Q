package com.example.mr_q;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.media.MediaPlayer;

import androidx.appcompat.app.AppCompatActivity;

public class collectActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer; // MediaPlayerインスタンスを// 宣言

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        Button nextButton = findViewById(R.id.collect_button);
        TextView textView2 = findViewById(R.id.textView2);

        textView2.setText(MainActivity.questionStorage.getQuestion().getQuestionExp());

        // 1. MediaPlayerを初期化し、音源をロードする
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correct_sound); // ★R.raw.correct_sound はres/rawフォルダのファイル名

        // 2. 音の再生を開始する
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

        // 3. 再生が完了したらリソースを解放するリスナーを設定
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(mp -> mp.release());

        }


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

        @Override
        protected void onDestroy (){
            super.onDestroy();
            if (mediaPlayer != null) {
                mediaPlayer.release();
                mediaPlayer = null;
            }
        }
    }

