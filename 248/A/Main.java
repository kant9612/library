import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s = sc.nextLine();
    // 1. 文字列を char 配列に変換
    char[] charArray = s.toCharArray();

    // 2. 配列をソート
    Arrays.sort(charArray);

    // 3. ソート済み配列を新しい文字列に変換
    String sortedString = new String(charArray);
    int ans = 0;

    for (int i = 0; i <= s.length(); i++) {
      if (sortedString.charAt(i) != (char) ('0' + i)) {
        ans = i;
        break;
      }
    }

    System.out.println(ans);

    sc.close();
  }
}
