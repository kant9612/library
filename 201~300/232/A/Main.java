import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    String[] parts = s.split("");
    int a = Integer.parseInt(parts[0]);
    int b = Integer.parseInt(parts[2]);
    int ans = a * b;

    System.out.println(ans);

    // Scannerを閉じる
    sc.close();
  }
}
