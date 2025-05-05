import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // グリッドのサイズ、常に偶数
    char[][] A = new char[N][N];
    for (int i = 0; i < N; i++) {
      String row = sc.next();
      A[i] = row.toCharArray();
    }
    sc.close();

    // r = 0..N/2-1 の各リングについて
    for (int r = 0; r < N / 2; r++) {
      int start = r, end = N - 1 - r;
      int len = end - start; // 1辺あたりの要素数-1

      // リングrは i=1..r+1 の各操作で回されるので、合計 r+1 回転
      int times = (r + 1) % 4; // 4回転で元通りなのでmod4
      for (int t = 0; t < times; t++) {
        // この内側ループで「リングrを1回だけ回す」
        for (int offset = 0; offset < len; offset++) {
          int x1 = start, y1 = start + offset;
          int x2 = start + offset, y2 = end;
          int x3 = end, y3 = end - offset;
          int x4 = end - offset, y4 = start;
          char tmp = A[x1][y1];
          A[x1][y1] = A[x4][y4];
          A[x4][y4] = A[x3][y3];
          A[x3][y3] = A[x2][y2];
          A[x2][y2] = tmp;
        }
      }
    }
    for (int i = 0; i < N; i++) {
      System.out.println(A[i]);
    }
  }
}
