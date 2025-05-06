import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int Q = sc.nextInt();
    char[] S = sc.next().toCharArray();

    boolean[] occ = new boolean[N];
    int cnt = 0;
    for (int i = 0; i + 2 < N; i++) {
      if (S[i] == 'A' && S[i + 1] == 'B' && S[i + 2] == 'C') {
        occ[i] = true;
        cnt++;
      }
    }
    for (int qi = 0; qi < Q; qi++) {
      // クエリを読み込んで文字を置き換え
      int x = sc.nextInt() - 1;
      char c = sc.next().charAt(0);
      S[x] = c;

      // 影響を受けるABCの開始位置は x-2..x
      for (int i = x - 2; i <= x; i++) {
        if (i < 0 || i + 2 >= N) {
          continue;
        }
        // もし以前ここで ABCだったらカウントを戻す
        if (occ[i]) {
          occ[i] = false;
          cnt--;
        }
        // 再チェックして新たにABCになっていればカウント
        if (S[i] == 'A' && S[i + 1] == 'B' && S[i + 2] == 'C') {
          occ[i] = true;
          cnt++;
        }
      }

      System.out.println(cnt);
    }
    sc.close();
  }
}