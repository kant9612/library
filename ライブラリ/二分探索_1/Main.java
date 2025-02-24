package ライブラリ.二分探索_1;

import java.util.*;

public class Main {
  static int N;
  static int[] A, B, C;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力
    N = sc.nextInt();
    A = new int[N];
    B = new int[N];
    C = new int[N];

    for (int i = 0; i < N; i++)
      A[i] = sc.nextInt();
    for (int i = 0; i < N; i++)
      B[i] = sc.nextInt();
    for (int i = 0; i < N; i++)
      C[i] = sc.nextInt();

    // ソート
    Arrays.sort(A);
    Arrays.sort(C);

    long ans = 0;

    // Bの各要素について、条件を満たすAとCの要素の個数を求める
    for (int b : B) {
      long a = lowerBound(A, b); // Aの中で B[b] より小さい要素の個数
      long c = N - upperBound(C, b); // Cの中で B[b] より大きい要素の個数
      ans += a * c;
    }

    System.out.println(ans);
    sc.close();
  }

  // lower_bound 相当の関数: B[b] より小さい要素の個数
  private static int lowerBound(int[] arr, int key) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] < key)
        left = mid + 1;
      else
        right = mid;
    }
    return left;
  }

  // upper_bound 相当の関数: B[b] より大きい要素の最初の位置を返す
  private static int upperBound(int[] arr, int key) {
    int left = 0, right = arr.length;
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] <= key)
        left = mid + 1;
      else
        right = mid;
    }
    return left;
  }
}
