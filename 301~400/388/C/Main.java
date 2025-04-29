import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] A = new int[N];
    for (int k = 0; k < N; k++) {
      A[k] = sc.nextInt();
    }
    sc.close();

    long ans = 0;
    int i = 0;
    // 二重ポインタ：j を動かしつつ、2*A[i] <= A[j] を満たす最大の i を探す
    for (int j = 0; j < N; j++) {
      while (i < N && (long) A[i] * 2 <= A[j]) {
        i++;
      }
      ans += i;
    }

    System.out.println(ans);
  }
}
