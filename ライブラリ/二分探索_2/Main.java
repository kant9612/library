import java.util.*;

// ALDS1_4_BをbinarySearchで解く
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力
    int n = sc.nextInt();
    int[] S = new int[n];

    for (int i = 0; i < n; i++) {
      S[i] = sc.nextInt();
    }

    int q = sc.nextInt();
    int[] T = new int[q];

    for (int i = 0; i < q; i++) {
      T[i] = sc.nextInt();
    }

    sc.close();

    // Tの中でSにも含まれるもののカウント
    int count = 0;

    for (int t : T) {
      if (Arrays.binarySearch(S, t) >= 0) {
        count++;
      }
    }

    System.out.println(count);
  }
}
