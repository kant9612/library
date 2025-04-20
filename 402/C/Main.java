import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 食材の種類数
    int M = sc.nextInt(); // 料理の数

    // 食材→料理のリスト
    List<List<Integer>> ing2dish = new ArrayList<>(N + 1);
    for (int i = 0; i <= N; i++) {
      ing2dish.add(new ArrayList<>());
    }

    // 各料理jがまだ苦手な食材を何種類含むか管理
    int rem[] = new int[M];
    for (int j = 0; j < M; j++) {
      int K = sc.nextInt();
      rem[j] = K;
      for (int k = 0; k < K; k++) {
        int ing = sc.nextInt();
        ing2dish.get(ing).add(j);
      }
    }

    // 1日ごとに食材を克服していく
    int[] B = new int[N];
    for (int i = 0; i < N; i++) {
      B[i] = sc.nextInt();
    }

    // 出力
    StringBuilder ans = new StringBuilder();
    int eatableCount = 0;
    for (int i = 0; i < N; i++) {
      int overcome = B[i];
      for (int dish : ing2dish.get(overcome)) {
        if (--rem[dish] == 0) {
          eatableCount++;
        }
      }
      ans.append(eatableCount).append('\n')
    }

    System.out.println(ans);
  }
}