import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    sc.close();

    boolean[] seen = new boolean[26];
    for (char c : S.toCharArray()) {
      seen[c - 'a'] = true;
    }

    for (int i = 0; i < 26; i++) {
      if (!seen[i]) {
        System.out.println((char) ('a' + i));
        return;
      }
    }
  }
}
