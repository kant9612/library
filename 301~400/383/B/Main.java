import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力
    int H = sc.nextInt();
    int W = sc.nextInt();
    int D = sc.nextInt();
    sc.nextLine(); // 改行を消費
    char[][] grid = new char[H][W];
    for (int i = 0; i < H; i++) {
      grid[i] = sc.nextLine().toCharArray();
    }

    // 床の位置を格納
    List<int[]> floors = new ArrayList<>();
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (grid[i][j] == '.') {
          floors.add(new int[] { i, j });
        }
      }
    }
    int maxHumidified = 0;

    // 2つの異なる床を選ぶ
    for (int i = 0; i < floors.size(); i++) {
      for (int j = i + 1; j < floors.size(); j++) {
        Set<String> humidified = new HashSet<>();

        // 最初の加湿器を置く
        int[] pos1 = floors.get(i);
        for (int x = 0; x < H; x++) {
          for (int y = 0; y < W; y++) {
            if (grid[x][y] == '.' && Math.abs(x - pos1[0]) + Math.abs(y - pos1[1]) <= D) {
              humidified.add(x + "," + y);
            }
          }
        }

        // 2つ目の加湿器を置く
        int[] pos2 = floors.get(j);
        for (int x = 0; x < H; x++) {
          for (int y = 0; y < W; y++) {
            if (grid[x][y] == '.' && Math.abs(x - pos2[0]) + Math.abs(y - pos2[1]) <= D) {
              humidified.add(x + "," + y);
            }
          }
        }

        // 床が加湿されている数を更新
        maxHumidified = Math.max(maxHumidified, humidified.size());
      }
    }

    // 結果を出力
    System.out.println(maxHumidified);
  }
}
