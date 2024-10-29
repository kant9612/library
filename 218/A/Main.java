import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    sc.nextLine(); // 改行を消費

    String S = sc.nextLine();
    char ch = S.charAt(N - 1);

    if (ch == 'o') {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }

    // Scannerを閉じる
    sc.close();
  }
}
