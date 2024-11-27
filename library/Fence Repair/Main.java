import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 入力の読み込み
        int N = sc.nextInt(); // 板の本数
        int[] L = new int[N]; // 板の長さを格納する配列
        for (int i = 0; i < N; i++) {
            L[i] = sc.nextInt();
        }

        long ans = 0;

        // 板が1本になるまで適用
        while (N > 1) {
            // 一番短い板 mii1, 次に短い板 mii2 を求める
            int mii1 = 0, mii2 = 1;
            if (L[mii1] > L[mii2]) {
                int temp = mii1;
                mii1 = mii2;
                mii2 = temp;
            }

            for (int i = 2; i < N; i++) {
                if (L[i] < L[mii1]) {
                    mii2 = mii1;
                    mii1 = i;
                } else if (L[i] < L[mii2]) {
                    mii2 = i;
                }
            }

            // それらを併合
            int t = L[mii1] + L[mii2];
            ans += t;

            // mii1 に新しい板の長さを保存
            if (mii1 == N - 1) {
                int temp = mii1;
                mii1 = mii2;
                mii2 = temp;
            }
            L[mii1] = t;

            // mii2 に最後の板を移動
            L[mii2] = L[N - 1];
            N--; // 板の本数を減らす
        }

        // 結果を出力
        System.out.println(ans);

        sc.close();
    }
}
