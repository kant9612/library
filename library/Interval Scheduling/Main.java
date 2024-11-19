import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 仕事の数を読み込み
    int N = sc.nextInt();

    // 開始時間と終了時間を格納する配列
    int[] S = new int[N];
    int[] T = new int[N];

    // 開始時間の読み込み
    for (int i = 0; i < N; i++) {
      S[i] = sc.nextInt();
    }

    // 終了時間の読み込み
    for (int i = 0; i < N; i++) {
      T[i] = sc.nextInt();
    }

    // 仕事を終了時間の早い順にソートするためのリスト
    List<Job> jobs = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      jobs.add(new Job(S[i], T[i]));
    }

    // ソート: 終了時間 (T) を優先、同じ場合は開始時間 (S) を比較
    jobs.sort(Comparator.comparingInt(job -> job.end));

    // 貪欲法で最大の仕事数を計算
    int ans = 0;
    int t = 0; // 最後に選んだ仕事の終了時間
    for (Job job : jobs) {
      if (t < job.start) { // 仕事が選べる場合
        ans++;
        t = job.end; // 選んだ仕事の終了時間を更新
      }
    }

    // 結果を出力
    System.out.println(ans);
    sc.close();
  }

  // 仕事を表すクラス
  static class Job {
    int start; // 開始時間
    int end; // 終了時間

    Job(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
