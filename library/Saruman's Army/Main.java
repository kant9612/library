import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力の読み込み
        int N = sc.nextInt(); // 点の数
        int R = sc.nextInt(); // カバーできる距離
        int[] X = new int[N]; // 各点の位置を格納する配列

        for (int i = 0; i < N; i++) {
            X[i] = sc.nextInt(); // 各点の位置を読み込む
        }

        // 点をソート
        Arrays.sort(X);

        int i = 0, ans = 0;
        while (i < N) {
            // sはカバーされていない一番左の点の位置
            int s = X[i++];
            // sから距離Rを超える点まで進む
            while (i < N && X[i] <= s + R) {
                i++;
            }

            // pは新しく印をつける点の位置
            int p = X[i - 1];
            // pから距離Rを超える点まで進む
            while (i < N && X[i] <= p + R) {
                i++;
            }

            ans++;
        }

        // 結果を出力
        System.out.println(ans);

        sc.close();
    }
}
