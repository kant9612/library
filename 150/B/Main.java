import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine();
    String S = sc.nextLine();
    int count = 0;

    for (int i = 0; i <= N - 3; i++) {
      char ch1 = S.charAt(i);
      if (S.charAt(i) == 'A' && S.charAt(i + 1) == 'B' && S.charAt(i + 2) == 'C') {
        count++;
      }
    }

    System.out.println(count);
    sc.close();
  }
}
