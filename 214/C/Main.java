import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Read the value of N
    int N = sc.nextInt();

    // Create and fill the S and T arrays
    int[] S = new int[N];
    int[] T = new int[N];
    for (int i = 0; i < N; i++) {
      S[i] = sc.nextInt();
    }
    for (int i = 0; i < N; i++) {
      T[i] = sc.nextInt();
    }

    // Initialize memo array with T values
    int[] memo = Arrays.copyOf(T, N);

    // Perform the computation similar to the C++ code
    for (int i = 0; i < N * 2; i++) {
      memo[(i + 1) % N] = Math.min(memo[(i + 1) % N], memo[i % N] + S[i % N]);
    }

    // Output the memo array
    for (int ans : memo) {
      System.out.println(ans);
    }

    sc.close();
  }
}
