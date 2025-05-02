import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    String S = sc.next();
    sc.close();

    // 配列に入れ込み参照しやすく
    char[] cs = S.toCharArray();

    // pre1[i]: 位置 i まで連続する '1'の個数
    int[] pre1 = new int[N];
    for (int i = 0; i < N; i++) {
      if (cs[i] == '1') {
        pre1[i] = (i > 0 ? pre1[i - 1] : 0) + 1;
      } else {
        pre1[i] = 0;
      }
    }

    int[] suf2 = new int[N];
    for (int i = N - 1; i >= 0; i--) {
      if (cs[i] == '2') {
        suf2[i] = (i + 1 < N ? suf2[i + 1] : 0) + 1;
      } else {
        suf2[i] = 0;
      }
    }

    int ans = 1;
    for (int i = 0; i < N; i++) {
      if (cs[i] == '/') {
        int ones = (i > 0 ? pre1[i - 1] : 0);
        int twos = (i + 1 < N ? suf2[i + 1] : 0);
        int k = Math.min(ones, twos);
        int len = 2 * k + 1;
        if (len > ans) {
          ans = len;
        }
      }
    }

    System.out.println(ans);
  }
}
