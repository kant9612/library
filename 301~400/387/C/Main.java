import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long L = sc.nextLong();
    long R = sc.nextLong();
    sc.close();

    System.out.println(countSnakes(R) - countSnakes(L - 1));
  }

  // X以下のヘビ数を返す
  static long countSnakes(long X) {
    if (X < 10)
      return 0; // 10未満にヘビ数なし
    String s = Long.toString(X);
    int D = s.length();

    // 桁ごとの数字を int[] digits に
    int[] digits = new int[D];
    for (int i = 0; i < D; i++) {
      digits[i] = s.charAt(i) - '0';
    }

    long total = 0;

    // (1)長さ2..D-1の全てのヘビ数
    // 長さ d のとき先頭 a=1//9, 残り d-1 桁は0..a-1 の a通りずつ → a^(d-1)
    for (int d = 2; d < D; d++) {
      for (int a = 1; a <= 9; a++) {
        total += pow(a, d - 1);
      }
    }

    // (2)長さ D のうち、先頭 digit < digits[0] の場合
    int first = digits[0];
    for (int a = 1; a < first; a++) {
      total += pow(a, D - 1);
    }

    // (3)長さ D, 先頭 == digits[0] の場合のみ DP で厳密に数える
    // 各残り桁は [0..first-1] の範囲で、かつ全体で <= X
    // dp_equal: 直前までが X のプレフィックスに厳密に張り付いている場合の数
    // dp_less: すでに X より小さくなった場合の数

    long dp_equal = 1, dp_less = 0;
    int A0 = first;
    for (int pos = 1; pos < D; pos++) {
      long nequal = 0;
      long nless = 0;
      int x = digits[pos];
      int maxDigit = A0 - 1;

      // (a)今までぴったり = tight の場合
      if (dp_equal > 0) {
        // b < x を選ぶパターンは 0..min(maxDigit, x-1) → countLess
        int countLess = Math.min(maxDigit, x - 1);
        if (countLess >= 0) {
          nless += dp_equal * (countLess + 1);
        }
        // b == x を選べるのは x <= maxDigit の時だけ
        if (x <= maxDigit) {
          nequal += dp_equal;
        }
      }
      // (b) 今まで既に小さい場合は、どれを選んでも小さいまま
      // 0..maxDigit の (maxDigit + 1) 通り
      if (dp_less > 0) {
        nless += dp_less * (long) (maxDigit + 1);
      }
      dp_equal = nequal;
      dp_less = nless;
    }
    total += dp_equal + dp_less;
    return total;
  }

  // a^e を繰り返し二乗ではなく、小さい a,e(≦18) のために素直に
  static long pow(int a, int e) {
    long r = 1;
    for (int i = 0; i < e; i++) {
      r *= a;
    }
    return r;
  }
}