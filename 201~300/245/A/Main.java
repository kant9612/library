import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    String ans;

    if (a - c > 0) {
      ans = "Aoki";
    } else if (a - c == 0 && b - d > 0) {
      ans = "Aoki";
    } else {
      ans = "Takahashi";
    }

    System.out.println(ans);

    sc.close();
  }
}
