import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // クエリの個数
    int Q = sc.nextInt();
    // 蛇の頭の座標の配列を作成
    ArrayList<Integer> list = new ArrayList<>();
    list.add(0); // 先頭の頭は常に0

    for (int i = 0; i < Q; i++) {
      int type = sc.nextInt();
      if (type == 1) {
        int l = sc.nextInt();
        int head = list.get(list.size() - 1) + l;
        list.add(head);
      } else if (type == 2) {
        int n = list.get(0);
        list.remove(0);
        for (int j = 0; j < list.size() - 1; j++) {
          list.set(j, list.get(j) - n);
        }
      } else {
        int k = sc.nextInt();
        System.out.println(list.get(k - 1));
      }
    }
  }
}
