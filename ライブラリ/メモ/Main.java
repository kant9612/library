package ライブラリ.メモ;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // ①数字が1つ
    int n = sc.nextInt();
    // ②数字が2つ以上で別々に受け取り（空白区切り）
    int a = sc.nextInt();
    int b = sc.nextInt();
    // ②数字が2つ以上で別々に受け取り（1行の入力を受け取り、空白で分割）※空白以外でも分割できる
    String line = sc.nextLine();
    String[] parts = line.split(" ");

    int a = Integer.parseInt(parts[0]);
    int b = Integer.parseInt(parts[1]);

    // ③文字列が1つ
    // 単語1つのみ
    String S = sc.next();
    // 1行
    String S = sc.nextLine();

    // ④文字列が2つ以上で別々に受け取り
    // intと同じように空白が間にあれば分割できる

    // ⑤-1リストで受け取り
    // リストのサイズを受け取る
    int n = sc.nextInt();

    // 数値リストを格納する
    List<Integer> list = new ArrayList<>();

    // `n` 個の整数を受け取る
    for (int i = 0; i < n; i++) {
      list.add(sc.nextInt());
    }

    // ⑤-2リストで受け取り
    // 1行の文字列を受け取る
    String line = sc.nextLine();

    // スペース区切りでリストに変換
    List<String> list = Arrays.asList(line.split(" "));

    // ⑥複数行リストの受け取り
    // 行数を受け取る
    int n = sc.nextInt();
    sc.nextLine(); // 改行を消費

    // 複数行のリストを格納
    List<String> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      list.add(sc.nextLine()); // 1行ずつリストに追加
    }

    sc.close();
  }
}
