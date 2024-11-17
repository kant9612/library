import java.util.*;

public class Main {
    static final int INF = 100000000; // 無限大の定義
    static final int MAX_N = 100; // 最大の迷路のサイズ
    static final int MAX_M = 100;

    // 移動4方向のベクトル
    static final int[] dx = { 1, 0, -1, 0 };
    static final int[] dy = { 0, 1, 0, -1 };

    static char[][] maze = new char[MAX_N][MAX_M]; // 迷路を表す文字列の配列
    static int[][] d = new int[MAX_N][MAX_M]; // 各点までの最短距離を記録する配列
    static int N, M; // 迷路のサイズ
    static int sx, sy; // スタートの座標
    static int gx, gy; // ゴールの座標

    // BFSによる最短距離の計算
    static int bfs() {
        Queue<int[]> que = new LinkedList<>();

        // 全ての点をINFで初期化
        for (int i = 0; i < N; i++) {
            Arrays.fill(d[i], INF);
        }

        // スタート地点をキューに入れ、距離を0に設定
        que.offer(new int[] { sx, sy });
        d[sx][sy] = 0;

        // キューが空になるまで探索
        while (!que.isEmpty()) {
            int[] p = que.poll();

            int x = p[0];
            int y = p[1];

            // ゴールに到達した場合、距離を返す
            if (x == gx && y == gy) {
                return d[gx][gy];
            }

            // 移動4方向を試す
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 範囲内かつ移動可能かつ未訪問の場所なら進む
                if (0 <= nx && nx < N && 0 <= ny && ny < M && maze[nx][ny] != '#' && d[nx][ny] == INF) {
                    que.offer(new int[] { nx, ny });
                    d[nx][ny] = d[x][y] + 1;
                }
            }
        }

        // ゴールに到達できなかった場合
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力の読み込み
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 改行を消費

        for (int i = 0; i < N; i++) {
            maze[i] = sc.nextLine().toCharArray();
        }

        // スタート地点とゴール地点を探す
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maze[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                if (maze[i][j] == 'G') {
                    gx = i;
                    gy = j;
                }
            }
        }

        // 最短距離を計算
        int res = bfs();

        // 結果を出力
        System.out.println(res);

        sc.close();
    }
}
