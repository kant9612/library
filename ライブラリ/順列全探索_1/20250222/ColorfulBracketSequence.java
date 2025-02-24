import java.util.Stack;
import java.util.Scanner;

public class ColorfulBracketSequence {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String S = sc.next();
    System.out.println(isColorfulBracketSequence(S));
    sc.close();
  }

  public static String isColorfulBracketSequence(String s) {
    Stack<Character> stack = new Stack<>();

    for (char ch : s.toCharArray()) {
      if (ch == '(' || ch == '[' || ch == '<') {
        stack.push(ch); // 左括弧をスタックに追加
      } else if (ch == ')' || ch == ']' || ch == '>') {
        if (stack.isEmpty())
          return "No"; // スタックが空ならペアにならない

        char top = stack.pop(); // スタックのトップを取り出す
        if (!isMatchingPair(top, ch))
          return "No"; // 対応するペアかチェック
      }
    }

    return stack.isEmpty() ? "Yes" : "No"; // スタックが空ならYes、残っていればNo
  }

  private static boolean isMatchingPair(char open, char close) {
    return (open == '(' && close == ')') ||
        (open == '[' && close == ']') ||
        (open == '<' && close == '>');
  }
}
