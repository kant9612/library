import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.nextLine();
    sc.close();

    int n = S.length(); // 挿入前の文字列の長さ

    String aft = ""; // 挿入後の文字列
    int aft_cnt = aft.length(); // 挿入後の文字列の長さ

    int ins = 0; // 挿入数

    for (int i = 0; i < n; i++) {
      if (i % 2 == 0 && S.charAt(i) == 'i') {
        aft = aft.concat("i");
      } else if (i % 2 == 0 && S.charAt(i) != 'i') {
        aft = aft.concat("oi");
        ins++;
      } else if (i % 2 == 1 && S.charAt(i) == 'o') {
        aft = aft.concat("o");
      } else {
        aft = aft.concat("io");
        ins++;
      }
    }

    // もし長さが奇数なら、1文字追加して偶数にする必要がある
    if (aft_cnt % 2 != 0) {
      ins++;
    }

    System.out.println(ins);
  }
}
