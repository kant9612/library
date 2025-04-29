import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int h;
    h = sc.nextInt();
    long num = (long) h * (12800000L + h); // オーバーフローを考慮
    double res = Math.sqrt(num); // 平方根計算
    System.out.println(res);

    sc.close();
  }
}
