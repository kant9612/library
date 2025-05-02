import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] h = new int[n];
    for (int i = 0; i < n; i++) {
      h[i] = sc.nextInt();
    }
    sc.close();

    int ans = 0;
    for (int w = 1; w <= n; w++) {
      // si: スタート位置（0からw-1）
      for (int si = 0; si < w; si++) {
        int val = -1;
        int len = 0;
        // ストライド w で要素を辿る
        for (int i = 0; i < n; i += w) {
          int x = h[i];
          if (x == val) {
            len++;
          } else {
            val = x;
            len = 1;
          }
          if (len > ans) {
            ans = len;
          }
        }

      }
    }
    System.out.println(ans);
  }
}
