import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String line = sc.nextLine();
    String[] parts = line.split(" ");

    int a = Integer.parseInt(parts[0]);
    int b = Integer.parseInt(parts[1]);
    int c = Integer.parseInt(parts[2]);
    int x = Integer.parseInt(parts[3]);
    int y = Integer.parseInt(parts[4]);
    int ans = Integer.MAX_VALUE;

    // abはabピザの枚数
    // sumは合計金額

    for (int ab = 0; ab < 210000; ab++) {
      int sum = c * ab;

      int X = x - ab / 2;
      int Y = y - ab / 2;

      if (X > 0)
        sum += X * a;
      if (Y > 0)
        sum += Y * b;

      ans = Math.min(ans, sum);
    }
    System.out.println(ans);
    sc.close();
  }
}
