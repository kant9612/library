import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 入力の取得
    int H = sc.nextInt();
    int W = sc.nextInt();
    int D = sc.nextInt();
    sc.nextLine();

    char[][] grid = new char[H][W];
    List<int[]> humidifiers = new ArrayList<>();

    for (int i = 0; i < H; i++) {
      String line = sc.nextLine();
      for (int j = 0; j < W; j++) {
        grid[i][j] = line.charAt(j);
        if (grid[i][j] == 'H') {
          humidifiers.add(new int[] { i, j }); // 加湿器の位置を記録
        }
      }
    }

    // 加湿器が1つも存在しない場合、0を出力して終了
    if (humidifiers.isEmpty()) {
      System.out.println(0);
      return;
    }

    // 床が加湿されるマスをセットで管理
    Set<String> humidified = new HashSet<>();

    // 全ての加湿器をキューに初期追加
    Queue<int[]> queue = new LinkedList<>();
    for (int[] humidifier : humidifiers) {
      queue.add(new int[] { humidifier[0], humidifier[1], 0 }); // 初期距離は0
      humidified.add(humidifier[0] + "," + humidifier[1]); // 加湿器自身をカウント
    }

    // 移動方向（上下左右）
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };

    // BFSで加湿範囲を計算
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0];
      int y = current[1];
      int distance = current[2];

      // 距離がDを超えた場合は探索終了
      if (distance >= D) {
        continue;
      }

      // 周囲のマスを探索
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 範囲外または既に加湿済みの場合は無視
        if (nx < 0 || nx >= H || ny < 0 || ny >= W || humidified.contains(nx + "," + ny)) {
          continue;
        }

        // 壁 (`#`) の場合はスキップ
        if (grid[nx][ny] == '#') {
          continue;
        }

        // 次のマスをキューに追加
        queue.add(new int[] { nx, ny, distance + 1 });
        humidified.add(nx + "," + ny); // 加湿済みに登録
      }
    }

    // 結果を出力（床の数）
    System.out.println(humidified.size());
  }
}
