import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int Q = sc.nextInt();

    // 各巣にいる鳩の数をカウント（各1〜Nの巣に初めは1羽ずつ）
    int[] cnt = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      cnt[i] = 1;
    }

    // 鳩Pがどの巣にいるかを記録（最初はP番の巣にいる）
    int[] pos = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      pos[i] = i;
    }

    int ans = 0; // 鳩が2羽以上いる巣の数

    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt();
      // 「1」：鳩の移動
      if (type == 1) {
        int P = sc.nextInt();
        int H = sc.nextInt();

        int oldNest = pos[P];
        // 元の巣にいる鳩の数が1以下になったらカウント対象ではなくなる
        if (cnt[oldNest] == 2) {
          ans--;
        }
        cnt[oldNest]--; // 実際にその巣から鳩を減らす

        // 鳩PをHに移動する
        pos[P] = H;
        if (cnt[H] == 1) {
          ans++;
        }
        cnt[H]++;

      } else {
        // 「2」：複数鳩がいる巣の数を算出して出力
        System.out.println(ans);
      }
    }
    sc.close();
  }
}
