import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine(); // 改行を消費
    String s = sc.nextLine();

    char ans = s.charAt(n - 1);
    System.out.println(ans);

    sc.close();
  }
}
