import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String s1 = sc.nextLine();
    String s2 = sc.nextLine();
    String[] parts_s1 = s1.split("");
    String[] parts_s2 = s2.split("");

    if ((parts_s1[0].equals(".") && parts_s2[1].equals(".")) || (parts_s1[1].equals(".") && parts_s2[0].equals("."))) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }

    // Scannerを閉じる
    sc.close();
  }
}
