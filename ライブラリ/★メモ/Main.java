package ライブラリ.メモ;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // ①数字が1つ
    int N = sc.nextInt();
    // ②数字が2つ以上で別々に受け取り（空白区切り）
    int A = sc.nextInt();
    int B = sc.nextInt();
    // ②数字が2つ以上で別々に受け取り（1行の入力を受け取り、空白で分割）※空白以外でも分割できる
    String line = sc.nextLine();
    String[] parts = line.split(" ");

    int A = Integer.parseInt(parts[0]);
    int B = Integer.parseInt(parts[1]);

    // ③文字列が1つ
    // 単語1つのみ
    String S = sc.next();
    // 1行
    String S = sc.nextLine();

    // ④文字列が2つ以上で別々に受け取り
    // intと同じように空白が間にあれば分割できる

    // ⑤-1リストで受け取り
    // リストのサイズを受け取る
    int N = sc.nextInt();

    // 数値リストを格納する
    List<Integer> list = new ArrayList<>();

    // `n` 個の整数を受け取る
    for (int i = 0; i < N; i++) {
      list.add(sc.nextInt());
    }

    // ⑤-2リストで受け取り
    // 1行の文字列を受け取る
    String line = sc.nextLine();

    // スペース区切りでリストに変換
    List<String> list = Arrays.asList(line.split(" "));

    // ⑥複数行リストの受け取り
    // 行数を受け取る
    int N = sc.nextInt();
    sc.nextLine(); // 改行を消費

    // 複数行のリストを格納
    List<String> list = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      list.add(sc.nextLine()); // 1行ずつリストに追加
    }

    // GRIDの表示方法
    int R = sc.nextInt(); // 行数
    int C = sc.nextInt(); // 列数
    String S = sc.nextLine(); // 改行を消費
    int sy = sc.nextInt();
    int sx = sc.nextInt();
    String T = sc.nextLine(); // 改行を消費
    int gy = sc.nextInt();
    int gx = sc.nextInt();
    char[][] grid = new char[R][C];
    for (int i = 0; i < R; i++) {
      String line = sc.nextLine();
      grid[i] = line.toCharArray();
    }
    System.out.println(bfs(grid, sx, sy, gx, gy));
    // gridの表示方法
    // for (char[] row : grid) {
    // System.out.println(new String(row));
    // }

    // スタート位置を探す
    int startX = 0, startY = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (grid[i][j] == 'S') {
          startX = i;
          startY = j;
          break;
        }
      }
    }

    // 行列の行数と列数
    int[] r = new int[n]; // 行列の行数
    int[] c = new int[n]; // 行列の列数

    for (int i = 0; i < n; i++) {
      r[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    sc.close();
  }
}
