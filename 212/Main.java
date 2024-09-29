import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scannerオブジェクトの作成
        Scanner scanner = new Scanner(System.in);

        // 文字列の入力を受け取る
        // String name = scanner.nextLine(); // 一行の文字列を読み取る

        // 整数の入力を受け取る
        // int age = scanner.nextInt(); // 整数を読み取る
        
        // 1行で空白区切りの2つの数字を入力
        String input = scanner.nextLine(); // 1行の入力を取得

        // 空白で分割して配列に格納
        String[] numbers = input.split(" ");

        // 分割された文字列を整数に変換
        int A = Integer.parseInt(numbers[0]);
        int B = Integer.parseInt(numbers[1]);
        
        if(A > 0 && B > 0) {
          System.out.println("Alloy");
        } else if(A == 0) {
          System.out.println("Silver");
        } else {
          System.out.println("Gold");
        }
        
        // Scannerを閉じる
        scanner.close();
    }
}