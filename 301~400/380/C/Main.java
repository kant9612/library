import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み込み
    int N = sc.nextInt();
    int K = sc.nextInt();
    String S = sc.next();

    // 1の塊の開始位置と終了位置をリストで管理
    List<Integer> starts = new ArrayList<>();
    List<Integer> ends = new ArrayList<>();

    // 1の塊を探索
    int i = 0;
    while (i < N) {
      if (S.charAt(i) == '1') {
        int start = i;
        while (i < N && S.charAt(i) == '1') {
          i++;
        }
        int end = i - 1;
        starts.add(start);
        ends.add(end);
      } else {
        i++;
      }
    }

    // Kが範囲外の場合はそのまま出力
    if (K < 2 || K > starts.size()) {
      System.out.println(S);
      return;
    }

    // K番目の1の塊を抜き取り、K-1番目の1の塊の直後に挿入
    int lK = starts.get(K - 1); // K番目の1の塊の開始位置
    int rK = ends.get(K - 1); // K番目の1の塊の終了位置
    int lPrev = ends.get(K - 2); // K-1番目の1の塊の終了位置

    StringBuilder T = new StringBuilder();

    // K-1番目の1の塊までの部分を追加
    T.append(S, 0, lPrev + 1);

    // K番目の1の塊を追加
    T.append(S, lK, rK + 1);

    // K番目の1の塊を抜いた残りの部分を追加
    T.append(S, lPrev + 1, lK); // K-1番目とK番目の間の部分
    T.append(S, rK + 1, N); // K番目の1の塊の後の部分

    // 結果の出力
    System.out.println(T.toString());
  }
}
