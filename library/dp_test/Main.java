import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 入力を受け取る
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 品物数
        int W = sc.nextInt(); // ナップサックの容量
        int[] w = new int[n]; // 品物の重さ
        int[] v = new int[n]; // 品物の価値

        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        sc.close();

        // KnapsackSolver クラスを利用して結果を計算
        KnapsackSolver solver = new KnapsackSolver(n, W, w, v);
        System.out.println(solver.solve());
    }

    // 内部クラス KnapsackSolver
    static class KnapsackSolver {
        private final int n; // 品物数
        private final int W; // ナップサックの容量
        private final int[] w; // 品物の重さ
        private final int[] v; // 品物の価値

        public KnapsackSolver(int n, int W, int[] w, int[] v) {
            this.n = n;
            this.W = W;
            this.w = w;
            this.v = v;
        }

        // 再帰関数でナップサック問題を解く
        private int rec(int i, int j) {
            if (i == n) {
                // もう品物は残っていない
                return 0;
            } else if (j < w[i]) {
                // この品物は入らない
                return rec(i + 1, j);
            } else {
                // 入れない場合と入れる場合を両方試す
                return Math.max(rec(i + 1, j), rec(i + 1, j - w[i]) + v[i]);
            }
        }

        // 問題を解くためのエントリーポイント
        public int solve() {
            return rec(0, W);
        }
    }
}
