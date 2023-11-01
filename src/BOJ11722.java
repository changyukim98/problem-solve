import java.util.Scanner;

public class BOJ11722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[1000];
        int dp[] = new int[1000];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
