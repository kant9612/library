import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.nextLine(); // 数字を入力
    boolean[] flag = new boolean[10]; // 10桁分のフラグ配列を用意

    // すべてのフラグを true に初期化
    for (int i = 0; i < 10; i++) {
      flag[i] = true;
    }

    // 入力された9桁の数字を解析し、該当する桁を false に設定
    for (int i = 0; i < S.length(); i++) {
      flag[S.charAt(i) - '0'] = false; // '0' を引くことで整数化
    }

    // フラグが true のインデックス（欠けている数字）を出力
    for (int i = 0; i < 10; i++) {
      if (flag[i]) {
        System.out.println(i);
      }
    }

    sc.close();
  }
}
