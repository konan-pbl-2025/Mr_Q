package com.example.mr_q;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView questionText;
    private Button optionA, optionB, optionC, optionD;

    private QuestionStorage questionStorage = new QuestionStorage(); // 問題リストを管理するインスタンス
    private int currentQuestionIndex = 0; // 現在の問題インデックス
    private int score = 0; // ユーザーのスコア

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI部品の初期化
        questionText = findViewById(R.id.questionText);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        // 最初の問題を表示
        loadQuestion(currentQuestionIndex);

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
    private void loadQuestion(int index) {
        if (index < 10) { // 10問だけ出題
            // 現在の問題を取得
            Question currentQuestion = questionStorage.getQuestion(index);

            // 問題文をセット
            questionText.setText(currentQuestion.getQuestionText());
            // 選択肢をセット
            optionA.setText(currentQuestion.getOptions()[0]);
            optionB.setText(currentQuestion.getOptions()[1]);
            optionC.setText(currentQuestion.getOptions()[2]);
            optionD.setText(currentQuestion.getOptions()[3]);
        } else {
            // すべての問題が終わった場合、結果を表示
            showResult();
        }
    }

    // ユーザーが選択した答えをチェックするメソッド
    private void checkAnswer(String selectedOption) {
        Question currentQuestion = questionStorage.getQuestion(currentQuestionIndex);
        String correctAnswer = currentQuestion.getCorrectAnswer();

        if (selectedOption.equals(correctAnswer)) {
            // 正解の場合
            score++;
            Toast.makeText(MainActivity.this, "正解！", Toast.LENGTH_SHORT).show();

            //正解画面を表示
            Intent intent = new Intent(MainActivity.this, collectActivity.class);
            intent.putExtra("currentIndex", currentQuestionIndex);  // 現在のインデックスを渡す
            startActivity(intent);
        } else {
            // 不正解の場合
            Toast.makeText(MainActivity.this, "不正解。正解は「" + currentQuestion.getOptions()[getOptionIndex(correctAnswer)] + "」です。", Toast.LENGTH_LONG).show();

            //不正解画面を表示
            Intent intent = new Intent(MainActivity.this, discollectActivity.class);
            intent.putExtra("currentIndex", currentQuestionIndex);  // 現在のインデックスを渡す
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

    // 結果を表示するメソッド
    private void showResult() {
        // 結果を表示
        Toast.makeText(MainActivity.this, "クイズ終了！あなたのスコアは: " + score + "/10", Toast.LENGTH_LONG).show();
    }
}
