import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Nの読み込み
    int N = sc.nextInt();

    // 配列Aの読み込み
    int[] A = new int[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextInt();
    }

    // 結果を格納する配列B
    int[] B = new int[N];

    // Mapを使って値とその直前のインデックスを記録
    Map<Integer, Integer> lastIndexMap = new HashMap<>();

    // Aを順に見ていく
    for (int i = 0; i < N; i++) {
      int value = A[i];

      // 直前に出現した位置をB[i]に記録
      if (lastIndexMap.containsKey(value)) {
        B[i] = lastIndexMap.get(value) + 1; // 1-based indexにするため+1
      } else {
        B[i] = -1;
      }

      // 現在の位置をMapに記録（更新）
      lastIndexMap.put(value, i);
    }

    // 結果を出力
    for (int i = 0; i < N; i++) {
      System.out.print(B[i]);
      if (i < N - 1) {
        System.out.print(" ");
      }
    }
    System.out.println();

    sc.close();
  }
}
