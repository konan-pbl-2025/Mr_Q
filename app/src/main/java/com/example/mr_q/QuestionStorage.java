package com.example.mr_q;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionStorage {
    private List<Question> questions;

    // コンストラクタ
    public QuestionStorage() {
        questions = new ArrayList<>();
        // 問題文、選択肢、正解を設定してリストに追加
        questions.add(new Question(
                "次の中で最も高い山はどれですか？",
                new String[]{"富士山", "エベレスト", "キリマンジャロ", "アルプス山脈"},
                "B",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "地球上で最も深い場所はどこですか？",
                new String[]{"マリアナ海溝", "グランドキャニオン", "アマゾン川", "ヒマラヤ山脈"},
                "A",
                "最も深い場所はマリアナ海溝です。"
        ));
        questions.add(new Question(
                "最も長い川はどれですか？",
                new String[]{"ナイル川", "アマゾン川", "長江", "ミシシッピ川"},
                "A",
                "最も長い川はナイル川です。"
        ));
        questions.add(new Question(
                "日本の首都はどこですか？",
                new String[]{"大阪", "京都", "東京", "名古屋"},
                "C",
                "日本の首都は東京です。"
        ));
        questions.add(new Question(
                "富士山の高さはどれくらいですか？",
                new String[]{"2,377m", "3,776m", "1,500m", "4,000m"},
                "B",
                "富士山の高さは3,776mです。"
        ));
        questions.add(new Question(
                "アメリカの最も大きな州はどれですか？",
                new String[]{"カリフォルニア", "テキサス", "アラスカ", "ニューヨーク"},
                "C",
                "アメリカの最も大きな州はアラスカ州です。"
        ));
        questions.add(new Question(
                "フランスの首都はどこですか？",
                new String[]{"パリ", "ロンドン", "ベルリン", "マドリッド"},
                "A",
                "フランスの首都はパリです。"
        ));
        questions.add(new Question(
                "最も人口が多い国はどこですか？",
                new String[]{"アメリカ", "インド", "中国", "ロシア"},
                "B",
                "もっとも人口が多い国はインドです。"
        ));
        questions.add(new Question(
                "最も大きいピラミッドがある国はどこですか？",
                new String[]{"エジプト", "メキシコ", "インド", "ギリシャ"},
                "A",
                "最も大きいピラミッドはエジプトのクフ王のピラミッドです。"
        ));
        questions.add(new Question(
                "最も広い海はどれですか？",
                new String[]{"アラビア海", "南シナ海", "太平洋", "インド洋"},
                "C",
                "最も広い海は太平洋です。"
        ));
        questions.add(new Question(
                "もっとも広い大陸はどれですか？",
                new String[]{"オーストラリア大陸", "ユーラシア大陸", "南アメリカ大陸", "アフリカ大陸"},
                "B",
                "最も広い大陸はユーラシア大陸です。"
        ));
        questions.add(new Question(
                "日本の初代内閣総理大臣は誰ですか？",
                new String[]{"麻生太郎", "大久保利通", "田中角栄", "伊藤博文"},
                "D",
                "日本の初代内閣総理大臣は伊藤博文です。"
        ));
        questions.add(new Question(
                "こうなん大学を漢字表記すると？",
                new String[]{"甲南", "江南", "港南", "香南"},
                "A",
                "漢字表記にすると甲南大学です。"
        ));
        questions.add(new Question(
                "世界で最も多い血液型は？",
                new String[]{"B", "O", "AB", "A"},
                "B",
                "最も多いのはO型です。"
        ));
        questions.add(new Question(
                "太陽系で最も大きい惑星は？",
                new String[]{"火星", "土星", "木星", "地球"},
                "C",
                "最も大きいのは木星です。"
        ));
        questions.add(new Question(
                "日本で一番大きい県は？",
                new String[]{"岐阜県", "岩手県", "広島県", "長野県"},
                "D",
                "日本の県の中では長野県が一番大きいです。"
        ));
        questions.add(new Question(
                "日本で一番大きい県は？",
                new String[]{"岐阜県", "岩手県", "広島県", "長野県"},
                "D",
                "日本の県の中では長野県が一番大きいです。"
        ));



        // 問題リストをシャッフルしてランダム順にする
        Collections.shuffle(questions);
    }

    // 問題数を取得
    public int getQuestionCount() {
        return questions.size();
    }

    // 指定したインデックスの問題を取得
    public Question getQuestion() {
        if (StartActivity.currentQuestionIndex >= 0 && StartActivity.currentQuestionIndex < 10) {  // 10問だけを出題
            return questions.get(StartActivity.currentQuestionIndex);
        }
        return null;
    }
}
