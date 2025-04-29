import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    List<int[]> players = new ArrayList<>();

    // 選手のスコアを入力し、選手番号と共にリストに追加
    for (int i = 0; i < N; i++) {
      int score = scanner.nextInt();
      players.add(new int[] { score, i + 1 }); // i + 1 で選手番号を1-basedに
    }

    // スコアでソート（スコアが大きい順）
    Collections.sort(players, (a, b) -> Integer.compare(b[0], a[0]));

    // 下位から2番目の選手の番号を出力
    System.out.println(players.get(1)[1]); // 2番目のスコアの選手の番号

    // Scannerを閉じる
    scanner.close();
  }
}
