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
                "地球の最も深い場所はどこですか？",
                new String[]{"マリアナ海溝", "グランドキャニオン", "アマゾン川", "ヒマラヤ山脈"},
                "A",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "最も長い川はどれですか？",
                new String[]{"ナイル川", "アマゾン川", "長江", "ミシシッピ川"},
                "A",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "日本の首都はどこですか？",
                new String[]{"大阪", "京都", "東京", "名古屋"},
                "C",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "富士山の高さはどれくらいですか？",
                new String[]{"2,377m", "3,776m", "1,500m", "4,000m"},
                "B",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "アメリカの最も大きな州はどれですか？",
                new String[]{"カリフォルニア", "テキサス", "アラスカ", "ニューヨーク"},
                "C",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "フランスの首都はどこですか？",
                new String[]{"パリ", "ロンドン", "ベルリン", "マドリッド"},
                "A",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "最も人口が多い国はどこですか？",
                new String[]{"アメリカ", "インド", "中国", "ロシア"},
                "C",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "ピラミッドがある国はどこですか？",
                new String[]{"エジプト", "メキシコ", "インド", "ギリシャ"},
                "A",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "最も広い海はどれですか？",
                new String[]{"アラビア海", "南シナ海", "太平洋", "インド洋"},
                "C",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "もっとも広い大陸はどれですか？",
                new String[]{"オーストラリア大陸", "ユーラシア大陸", "南アメリカ大陸", "オーストラリア大陸"},
                "B",
                "最も高い山はエベレストです。"
        ));
        questions.add(new Question(
                "日本の初代内閣総理大臣は誰ですか？",
                new String[]{"麻生太郎", "大久保利通", "田中角栄", "伊藤博文"},
                "D",
                "最も高い山はエベレストです。"
        ));


        // 問題リストをシャッフルしてランダム順にする
        Collections.shuffle(questions);
    }

    // 問題数を取得
    public int getQuestionCount() {
        return questions.size();
    }

    // 指定したインデックスの問題を取得
    public Question getQuestion(int index) {
        if (index >= 0 && index < 10) {  // 10問だけを出題
            return questions.get(index);
        }
        return null;
    }
}
