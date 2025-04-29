import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // RとCの読み取り
    int R = scanner.nextInt();
    int C = scanner.nextInt();

    // 2x2行列Aの読み取り
    int[][] A = new int[2][2];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < 2; j++) {
        A[i][j] = scanner.nextInt();
      }
    }

    // 答えの計算
    System.out.println(A[R - 1][C - 1]);

    scanner.close();
  }
}
