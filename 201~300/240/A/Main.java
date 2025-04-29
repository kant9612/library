import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int a;
    int b;
    a = sc.nextInt();
    b = sc.nextInt();

    if (b - a == 1) {
      System.out.println("Yes");
    } else if (b == 10 && a == 1) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    sc.close();
  }
}
