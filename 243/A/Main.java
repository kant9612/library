import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int v = sc.nextInt();
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int zan;

    zan = v % (a + b + c);
    if (zan - a < 0) {
      System.out.println("F");
    } else if (zan - a - b < 0) {
      System.out.println("M");
    } else {
      System.out.println("T");
    }

    sc.close();
  }
}
