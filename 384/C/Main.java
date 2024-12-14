import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の取得
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();
    String problems = "ABCDE";

    // 部分列とそのスコアを保持するマップ
    Map<String, Integer> scoreMap = new HashMap<>();

    // ビット全探索で全ての部分列を生成
    int n = problems.length();
    for (int bit = 1; bit < (1 << n); bit++) { // 1から開始して空集合を除く
      StringBuilder subset = new StringBuilder();
      int score = 0;
      for (int i = 0; i < n; i++) {
        if ((bit & (1 << i)) != 0) {
          subset.append(problems.charAt(i));
          // 対応するスコアを加算
          if (i == 0)
            score += a;
          if (i == 1)
            score += b;
          if (i == 2)
            score += c;
          if (i == 3)
            score += d;
          if (i == 4)
            score += e;
        }
      }
      scoreMap.put(subset.toString(), score);
    }

    // ソート用のリストを作成
    List<String> participants = new ArrayList<>(scoreMap.keySet());
    participants.sort((p1, p2) -> {
      int score1 = scoreMap.get(p1);
      int score2 = scoreMap.get(p2);
      if (score1 != score2) {
        return Integer.compare(score2, score1); // スコアで降順
      }
      return p1.compareTo(p2); // スコアが同じなら辞書順で昇順
    });

    // 結果を出力
    for (String participant : participants) {
      System.out.println(participant);
    }

    sc.close();
  }
}
