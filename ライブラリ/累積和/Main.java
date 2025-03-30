// 累積和問題

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long[] A = new long[N];
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextLong();
    }

    // 累積和を前計算
    long[] prefixSum = new long[N + 1];
    for (int i = 0; i < N; i++) {
      prefixSum[i + 1] = prefixSum[i] + A[i];
    }

    // 各kに対して、連続するk個の最大の区間和を求めて出力
    for (int k = 1; k <= N; k++) {
      long maxSum = Long.MIN_VALUE;
      for (int i = 0; i <= N; i++) {
        long sum = prefixSum[i + k] - prefixSum[i];
        if (sum > maxSum) {
          maxSum = sum;
        }
      }
      System.out.println(maxSum);
    }

    sc.close();
  }
}
