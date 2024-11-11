import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    String s = sc.nextLine();
    int a = sc.nextInt();
    int b = sc.nextInt();

    String parts[] = s.split("");

    // 文字の入れ替え
    String x = parts[a - 1];
    parts[a - 1] = parts[b - 1];
    parts[b - 1] = x;

    // 文字の連結
    StringBuilder sb = new StringBuilder();
    for (String part : parts) {
      sb.append(part);
    }
    String res = sb.toString();

    System.out.println(res);

    // Scannerを閉じる
    sc.close();
  }
}
