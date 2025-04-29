import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 入力の取得
    int H = scanner.nextInt(); // 縦の長さ
    int W = scanner.nextInt(); // 横の長さ
    int R = scanner.nextInt(); // ターゲットマスの行
    int C = scanner.nextInt(); // ターゲットマスの列

    // 隣接マスのカウント
    int count = 0;

    // 上のマス
    if (R > 1)
      count++;
    // 下のマス
    if (R < H)
      count++;
    // 左のマス
    if (C > 1)
      count++;
    // 右のマス
    if (C < W)
      count++;

    // 出力
    System.out.println(count);
  }
}
