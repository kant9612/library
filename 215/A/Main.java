import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String S = sc.nextLine();

    if (S.equals("Hello,World!")) {
      System.out.println("AC");
    } else {
      System.out.println("WA");
    }

    // Scannerを閉じる
    sc.close();
  }
}
