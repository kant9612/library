import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    long N = sc.nextLong(); // マスの数
    int M = sc.nextInt(); // 石が置かれているマスの数

    long[] X = new long[M];
    long[] A = new long[M];

    for (int i = 0; i < M; i++) {
      X[i] = sc.nextLong();
    }
    long sum = 0;
    for (int i = 0; i < M; i++) {
      A[i] = sc.nextLong();
      sum += A[i];
    }
    sc.close();

    // 合計石数が N と一致しない場合そもそも不可能
    if (sum != N) {
      System.out.println(-1);
      return;
    }

    // （位置、個数）を位置の昇順にソート
    long[][] P = new long[M][2];
    for (int i = 0; i < M; i++) {
      P[i][0] = X[i];
      P[i][1] = A[i];
    }
    Arrays.sort(P, Comparator.comparingLong(o -> o[0]));

    long prev = 1; // これまで処理した最後のマス番号
    long surplus = 0; // i-1 から持ち越した余剰石の数
    long moves = 0; // 移動回数

    for (int i = 0; i < M; i++) {
      long pos = P[i][0];
      long cnt = P[i][1];

      // prev からpos の間にある石0のマス（ギャップ）をまとめて処理
      long gap = pos - prev;
      // 各マスで石を1つ確保するために、surplus >= gap が必要
      if (surplus < gap) {
        System.out.println(-1);
        return;
      }

      // ギャップ内での移動回数の合計を一括計算
      // 各ステップ j=0..gap-1 で（surplus-j-1）個ずつ右へ動かす
      // 例）ある時点で手元に surplus 個の石があって、次の石マスまでの空きマス数が gap 個あるとする。
      // 空きマス1つ目は1つ石を置いて、その次のマスに残を移動させるのでsurplus-1個を右へ動かすことになる。
      // となると空きマス2つ目以降は、(surplus -1)-1 = surplus -2 個の石を動かすことになる..
      moves += gap * (surplus - 1) - (gap * (gap - 1) / 2);
      surplus -= gap;

      // 今のマス pos には、cnt + surplus 個ある
      long have = surplus + cnt;
      if (have < 1) {
        System.out.println(-1);
        return;
      }
      long diff = have - 1; // 1個残してあとは右へ動かす
      moves += diff;
      surplus = diff;
      prev = pos + 1;
    }

    // 最後のマス N までのギャップを同様に処理
    long tailGap = N - prev + 1; // prev=最後の石マス+1 になっている
    if (surplus < tailGap) {
      System.out.println(-1);
      return;
    }
    moves += tailGap * (surplus - 1) - (tailGap * (tailGap - 1) / 2);
    surplus -= tailGap;

    // 最終的に余剰石が0でないと、N+1 以降へ石を払ってしまったことになる
    if (surplus != 0) {
      System.out.println(-1);
    } else {
      System.out.println(moves);
    }
  }
}
