import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // K は常に 1 ですが、入力行を消費しておきます
    int K = sc.nextInt();
    String S = sc.next();
    String T = sc.next();
    sc.close();

    int sl = S.length(), tl = T.length();
    // 0 回操作で一致するなら Yes
    if (S.equals(T)) {
      System.out.println("Yes");
      return;
    }
    // 長さ差が 1 を超えるなら 1 回では無理
    if (Math.abs(sl - tl) > 1) {
      System.out.println("No");
      return;
    }
    // 置換操作：長さが同じ場合
    if (sl == tl) {
      int diffs = 0;
      for (int i = 0; i < sl; i++) {
        if (S.charAt(i) != T.charAt(i) && ++diffs > 1) {
          System.out.println("No");
          return;
        }
      }
      // ちょうど1箇所だけ違えば OK
      System.out.println(diffs == 1 ? "Yes" : "No");
      return;
    }
    // 挿入操作：S が短くて T が長い場合 (sl+1 == tl)
    if (sl + 1 == tl) {
      int i = 0;
      while (i < sl && S.charAt(i) == T.charAt(i)) {
        i++;
      }
      // S[i..] と T[i+1..] が一致すれば 1 文字挿入で変換可能
      if (S.substring(i).equals(T.substring(i + 1))) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
      return;
    }
    // 削除操作：S が長くて T が短い場合 (sl == tl+1)
    if (sl == tl + 1) {
      int i = 0;
      while (i < tl && S.charAt(i) == T.charAt(i)) {
        i++;
      }
      // S[i+1..] と T[i..] が一致すれば 1 文字削除で変換可能
      if (S.substring(i + 1).equals(T.substring(i))) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
      return;
    }
    // その他は不可能
    System.out.println("No");
  }
}
