import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int N = scanner.nextInt();

    double ans = Math.pow(2, N);

    System.out.println((int) ans);

    scanner.close();
  }
}
