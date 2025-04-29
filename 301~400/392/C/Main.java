import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] P = new int[N];
    for (int i = 0; i < N; i++) {
      P[i] = sc.nextInt() - 1; // 1-based → 0-based
    }
    int[] Q = new int[N];
    for (int i = 0; i < N; i++) {
      Q[i] = sc.nextInt(); // ゼッケン番号そのまま
    }

    int[] S = new int[N];
    for (int i = 0; i < N; i++) {
      S[Q[i] - 1] = Q[P[i]];
    }

    // 出力：最後だけ改行、それ以外はスペース区切り
    for (int i = 0; i < N; i++) {
      if (i < N - 1) {
        System.out.print(S[i] + " ");
      } else {
        System.out.println(S[i]);
      }
    }

    sc.close();
  }
}
