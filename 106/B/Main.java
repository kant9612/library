import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();
    int count = 0;

    for (int i = 1; i <= N; i += 2) {
      int yakusu = 0;
      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          yakusu++;
        }
      }
      if (yakusu == 8) {
        count++;
      }
    }

    System.out.println(count);
    scanner.close();
  }
}
