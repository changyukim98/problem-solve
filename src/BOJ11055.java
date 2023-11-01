import java.util.Scanner;

public class BOJ11055 {
    public static void main(String[] args) {
        int[] arr = new int[1001];
        int[] dp = new int[1001];

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = arr[i];
        }

        int max = dp[1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}