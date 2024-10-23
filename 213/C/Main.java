import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    int h = sc.nextInt();
    int w = sc.nextInt();
    int n = sc.nextInt();

    int[] a = new int[n];
    int[] b = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    // 実際に圧縮する
    a = compress(a);
    b = compress(b);

    for (int i = 0; i < n; i++) {
      System.out.println(a[i] + " " + b[i]);
    }
    sc.close();
  }

  // 圧縮関数
  public static int[] compress(int[] array) {
    int n = array.length;
    Map<Integer, Integer> mp = new TreeMap<>();

    // 値をMapに登録
    for (int i = 0; i < n; i++) {
      mp.put(array[i], 0);
    }

    int id = 1;

    // 値に新しいIDを割り当てる
    for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
      mp.put(entry.getKey(), id++);
    }

    // 新しいIDに基づいて配列を更新
    for (int i = 0; i < n; i++) {
      array[i] = mp.get(array[i]);
    }

    return array;
  }
}
