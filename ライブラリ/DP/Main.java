// フィボナッチ数列
package ライブラリ.DP;

import java.util.Scanner;

import javax.print.DocPrintJob;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    // DP配列の作成
    int[] fib = new int[n + 1];

    // 初期条件
    fib[0] = 1;
    if (n > 0) {
      fib[1] = 1;
    }

    // フィボナッチ数列の計算
    for (int i = 2; i <= n; i++) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }

    System.out.println(fib[n]);

  }
}