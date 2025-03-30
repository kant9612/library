
// 逆元を使う問題
import java.util.Scanner;

public class Main {
  static final int MOD = 1_000_000_007; // 問題で指定されている大きな素数
  static long[] fact; // 階乗(n!)をMODで割ったあまりを格納する配列
  static long[] inv; // 階乗の逆元(1/n!)をMODで割ったあまりを格納する配列

  // フェルマーの小定理を利用して逆元を求める
  static long modInv(long x) {
    return powMod(x, MOD - 2, MOD);
  }

  // 累乗を高速に計算（繰り返し二乗法）
  static long powMod(long base, long exp, int mod) {
    long result = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) { // exp % 2 == 1 のビット版。奇数の時に掛け算する。
        result = result * base % mod;
      }
      base = base * base % mod;
      exp >>= 1; // expを半分にしていく処理
    }
    return result;
  }

  // 組み合わせ計算 nCr = n! / (r! * (n - r)!)
  static long comb(int n, int r) {
    if (r > n || r < 0)
      return 0;
    return fact[n] * inv[r] % MOD * inv[n - r] % MOD;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int W = sc.nextInt();
    int H = sc.nextInt();
    sc.close();

    int N = W + H - 2; // 最大値
    fact = new long[N + 1];
    inv = new long[N + 1];

    // 階乗の前計算
    fact[0] = 1;
    for (int i = 1; i <= N; i++) {
      fact[i] = fact[i - 1] * i % MOD;
    }

    // 階乗の逆元の前計算
    inv[N] = modInv(fact[N]);
    for (int i = N - 1; i >= 0; i--) {
      inv[i] = inv[i + 1] * (i + 1) % MOD;
    }

    // 結果を計算
    long result = comb(W + H - 2, W - 1);
    System.out.println(result);
  }
}
