import java.util.*;

public class Main {
  public static void main(String[] args) {
    // Scannerオブジェクトの作成
    Scanner sc = new Scanner(System.in);

    // 入力をスペース区切りで取得
    String input = sc.nextLine();

    // 文字列を分割して配列に格納
    String[] inputArray = input.split(" ");

    // 分割された文字列をint配列に変換
    int[] numbers = new int[inputArray.length];

    for (int i = 0; i < inputArray.length; i++) {
      numbers[i] = Integer.parseInt(inputArray[i]);
    }

    // 昇順にソート
    Arrays.sort(numbers);

    if (numbers[0] == numbers[1] && numbers[2] == numbers[3]) {
      System.out.println(2);
    } else if (numbers[0] == numbers[1] || numbers[1] == numbers[2] || numbers[2] == numbers[3]
        || numbers[3] == numbers[0]) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }

    // Scannerを閉じる
    sc.close();
  }
}
