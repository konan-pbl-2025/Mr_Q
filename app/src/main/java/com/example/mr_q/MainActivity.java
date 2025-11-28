package com.example.mr_q;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private Button optionA, optionB, optionC, optionD;

    public static QuestionStorage questionStorage = new QuestionStorage(); // 問題リストを管理するインスタンス
    private MediaPlayer mediaPlayer; // MediaPlayerインスタンスを// 宣言
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView displayCurrentIndex = findViewById(R.id.displayCurrentIndex);
        displayCurrentIndex.setText(String.valueOf((StartActivity.currentQuestionIndex + 1) + "問目"));

        // もしIntentにcurrentIndexが含まれていれば、それをセット
        StartActivity.currentQuestionIndex = getIntent().getIntExtra("currentIndex", StartActivity.currentQuestionIndex);

        // UI部品の初期化
        questionText = findViewById(R.id.questionText);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        // 1. MediaPlayerを初期化し、音源をロードする
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.effect_sound); // ★R.raw.correct_sound はres/rawフォルダのファイル名

        // 2. 音の再生を開始する
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }

        // 3. 再生が完了したらリソースを解放するリスナーを設定
        if (mediaPlayer != null) {
            mediaPlayer.setOnCompletionListener(mp -> mp.release());
        }

        // 最初の問題を表示
        loadQuestion();

        // 各ボタンにリスナーを設定
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("A");
            }
        });

        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("B");
            }
        });

        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("C");
            }
        });

        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer("D");
            }
        });
    }

    // クイズの問題データを設定するメソッド
    private void loadQuestion() {
        // 現在の問題を取得
        Question currentQuestion = questionStorage.getQuestion();

        // 問題文をセット
        questionText.setText(currentQuestion.getQuestionText());
        // 選択肢をセット
        optionA.setText(currentQuestion.getOptions()[0]);
        optionB.setText(currentQuestion.getOptions()[1]);
        optionC.setText(currentQuestion.getOptions()[2]);
        optionD.setText(currentQuestion.getOptions()[3]);
    }

    // ユーザーが選択した答えをチェックするメソッド
    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questionStorage.getQuestion();
        String correctAnswer = currentQuestion.getCorrectAnswer();

        if (selectedOption.equals(correctAnswer)) {
            // 正解の場合
            StartActivity.score++;

            // 正解画面を表示
            Intent intent = new Intent(MainActivity.this, collectActivity.class);
            startActivity(intent);

        } else {
            // 不正解の場合

            // 不正解画面を表示
            Intent intent = new Intent(MainActivity.this, discollectActivity.class);
            startActivity(intent);
        }
    }

    // 正解の選択肢のインデックスを取得するメソッド
    private int getOptionIndex(String answer) {
        switch (answer) {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
            default:
                return -1;
        }
    }
}
