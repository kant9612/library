import java.util.*;

// ALDS1_4_Bを通常二分探索で解く
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
      if (binarySearch(S, t)) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static boolean binarySearch(int[] arr, int key) {
    int left = 0, right = arr.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (mid < 0)
        return false;
      if (arr[mid] == key) {
        return true;
      } else if (arr[mid] < key) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    // 見つからなかった場合
    return false;
  }
}
