import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 2][3];
        int[][] max_dp = new int[N + 2][3];
        int[][] min_dp = new int[N + 2][3];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N + 1; i++) {
            max_dp[i][0] = Math.max(max_dp[i - 1][0], max_dp[i - 1][1]) + arr[i][0];
            max_dp[i][1] = Math.max(max_dp[i - 1][0], Math.max(max_dp[i - 1][1], max_dp[i - 1][2])) + arr[i][1];
            max_dp[i][2] = Math.max(max_dp[i - 1][1], max_dp[i - 1][2]) + arr[i][2];

            min_dp[i][0] = Math.min(min_dp[i - 1][0], min_dp[i - 1][1]) + arr[i][0];
            min_dp[i][1] = Math.min(min_dp[i - 1][0], Math.min(min_dp[i - 1][1], min_dp[i - 1][2])) + arr[i][1];
            min_dp[i][2] = Math.min(min_dp[i - 1][1], min_dp[i - 1][2]) + arr[i][2];
        }
        System.out.println(max_dp[N + 1][1] + " " + min_dp[N + 1][1]);
    }
}
