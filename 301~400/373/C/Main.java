import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    long maxA = Long.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      long a = sc.nextLong();
      if (a > maxA)
        maxA = a;
    }

    long maxB = Long.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      long b = sc.nextLong();
      if (b > maxB)
        maxB = b;
    }

    sc.close();
    // 最大の A_i と最大の B_j を足し合わせる
    System.out.println(maxA + maxB);
  }
}
