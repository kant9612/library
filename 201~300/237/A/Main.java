import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n; // 入力される整数
        long m = 1L << 31; // long 型で 2^31 を計算

        // 入力の読み取り
        n = sc.nextLong();

        // 範囲チェック
        if (-m <= n && n < m) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close();
    }
}
