import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    // Nの下2桁を計算して出力
    System.out.printf("%02d\n", N % 100);
  }
}
