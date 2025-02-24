package ライブラリ.順列全探索_1;
import java.util.*;

public class Main {
  static int N;
  static int[] X, Y;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の読み取り
    N = sc.nextInt();
    X = new int[N];
    Y = new int[N];

    for (int i = 0; i < N; i++) {
      X[i] = sc.nextInt();
      Y[i] = sc.nextInt();
    }

    // 順列のリストを作成
    List<Integer> ord = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      ord.add(i);
    }

    // 全ての順列を試す
    double totalDistance = 0;
    int count = 0;

    do {
      double distance = 0;
      for (int i = 0; i < N - 1; i++) {
        int a = ord.get(i);
        int b = ord.get(i + 1);

        double dx = X[a] - X[b];
        double dy = Y[a] - Y[b];

        distance += Math.sqrt(dx * dx + dy * dy);
      }
      totalDistance += distance;
      count++;
    } while (nextPermutation(ord));

    // 平均距離を求める
    double averageDistance = totalDistance / count;
    System.out.printf("%.10f%n", averageDistance);

    sc.close();
  }

  // Javaでnext_permutationを再現する関数
  public static boolean nextPermutation(List<Integer> arr) {
    int n = arr.size();
    int i = n - 2;

    while (i >= 0 && arr.get(i) >= arr.get(i + 1))
      i--;
    if (i < 0)
      return false;

    int j = n - 1;
    while (arr.get(i) >= arr.get(j))
      j--;

    // Swap
    Collections.swap(arr, i, j);

    // Reverse the remaining elements
    Collections.reverse(arr.subList(i + 1, n));
    return true;
  }
}
