// 高速なべき乗計算;

import java.util.Scanner;

public class Main {
  static final int MOD = 1_000_000_007;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int m = sc.nextInt();
    long n = sc.nextLong();
    sc.close();

    // 高速累乗法で（M^N）%MODを計算
    System.out.println(modPow(m, n, MOD));
  }

  // 繰り返し二乗法
  static long modPow(long base, long exp, int mod) {
    long ans = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) { // nが奇数なら結果に掛ける
        ans = (ans * base) % mod;
      }
      base = (base * base) % mod; // 底を二乗
      exp >>= 1; // 指数を半分にする
    }
    return ans;
  }
}
