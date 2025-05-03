import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    // グリッド
    char[][] S = new char[N][N];
    char[][] T = new char[N][N];
    for (int i = 0; i < N; i++) {
      String row = sc.next();
      for (int j = 0; j < N; j++) {
        S[i][j] = row.charAt(j);
      }
    }
    for (int i = 0; i < N; i++) {
      String row = sc.next();
      for (int j = 0; j < N; j++) {
        T[i][j] = row.charAt(j);
      }
    }
    sc.close();

    int answer = Integer.MAX_VALUE;
    // k = 0,1,2,3 回 90° 右回転させたときのコストを調べる
    for (int k = 0; k < 4; k++) {
      int diff = 0;
      // S を k 回 90°右回転したあとの (i,j) の文字を取得して T[i][j] と比べる
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          char c;
          switch (k) {
            case 0: // 回転なし
              c = S[i][j];
              break;
            case 1: // 90° 右回転
              c = S[N - 1 - j][i];
              break;
            case 2: // 180° 回転
              c = S[N - 1 - i][N - 1 - j];
              break;
            default: // k==3 : 270° 回転
              c = S[j][N - 1 - i];
              break;
          }
          if (c != T[i][j]) {
            diff++;
          }
        }
      }
      // 回転操作 k 回 + セルを反転する操作 diff 回
      answer = Math.min(answer, k + diff);
    }

    System.out.println(answer);
  }
}
