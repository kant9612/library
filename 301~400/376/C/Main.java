import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    long[] A = new long[N]; // おもちゃの大きさを格納
    for (int i = 0; i < N; i++) {
      A[i] = sc.nextLong();
    }
    long[] B = new long[N - 1]; // 箱の大きさを格納
    for (int i = 0; i < N - 1; i++) {
      B[i] = sc.nextLong();
    }
    sc.close();

    // ソート
    Arrays.sort(A);
    Arrays.sort(B);

    // L[k]: b[k..N-2] で a[k..N-1] を入れられる
    boolean[] L = new boolean[N];
    // L[k] = true の場合、kこの箱とおもちゃをそれぞれ1対1で入れられることを示す
    // k = 0 つまり L[0]は箱もおもちゃもない、「何も入れないなら入れられる」状態のため true
    L[0] = true;
    for (int k = 1; k < N; k++) {
      // L[k-1] が真（true）である：すでに最初の k-1 個は入れられている
      L[k] = L[k - 1] && (B[k - 1] >= A[k - 1]);
    }

    boolean[] R = new boolean[N];
    R[N - 1] = true; // 最後のおもちゃは箱がなくてもOK
    for (int k = N - 2; k >= 0; k--) {
      R[k] = R[k + 1] && (B[k] >= A[k + 1]);
    }

    long ans = Long.MAX_VALUE;
    // k = 0.. N-1 を試す
    for (int k = 0; k < N; k++) {
      if (L[k] && R[k]) {
        ans = Math.min(ans, A[k]);
      }
    }
    System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
  }
}
