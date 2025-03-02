package ライブラリ.幅優先探索;

import java.util.*;

public class Main {
  // 上下左右の移動定義
  static int[] dx = { -1, 1, 0, 0 };
  static int[] dy = { 0, 0, -1, 1 };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int R = sc.nextInt(); // 行数
    int C = sc.nextInt(); // 列数
    int sy = sc.nextInt() - 1; // 1-based index → 0-based index に変換
    int sx = sc.nextInt() - 1;
    int gy = sc.nextInt() - 1;
    int gx = sc.nextInt() - 1;
    sc.nextLine(); // 改行消費

    char[][] grid = new char[R][C];
    for (int i = 0; i < R; i++) {
      String line = sc.nextLine();
      grid[i] = line.toCharArray();
    }
    sc.close();

    System.out.println(bfs(grid, sx, sy, gx, gy));
  }

  static int bfs(char[][] grid, int sx, int sy, int gx, int gy) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[][] dist = new int[rows][cols];
    for (int[] row : dist) {
      Arrays.fill(row, -1); // 未訪問を -1 で初期化
    }

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { sx, sy });
    dist[sy][sx] = 0; // スタート地点の距離は 0

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0], y = current[1];

      // ゴール地点に到達
      if (x == gx && y == gy) {
        return dist[y][x];
      }

      // 4方向を探索
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i], ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < cols && ny < rows && grid[ny][nx] != '#' && dist[ny][nx] == -1) {
          queue.add(new int[] { nx, ny });
          dist[ny][nx] = dist[y][x] + 1;
        }
      }
    }
    return -1; // ゴールにたどり着けない場合
  }
}
