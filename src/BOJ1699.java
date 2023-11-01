import java.util.Scanner;

public class BOJ1699 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[100001];

        for (int i = 0; i <= N; i++) {
            dp[i] = i;
        }

        for (int i = 0; i <= N; i++) {
            for (int j = 2; i + j * j <= N; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}