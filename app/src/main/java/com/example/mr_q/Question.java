package com.example.mr_q;

public class Question {
    private String questionText;  // 問題文
    private String[] options;     // 選択肢
    private String correctAnswer; // 正解の選択肢（A, B, C, D）
    private String questionExp; // 解説

    // コンストラクタ
    public Question(String questionText, String[] options, String correctAnswer, String questionExp) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.questionExp = questionExp;
    }

    // ゲッター
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getQuestionExp() { return questionExp; }
}

