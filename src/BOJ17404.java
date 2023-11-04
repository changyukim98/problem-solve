import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17404 {
    static final int MAX = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[N][3][3]; // [i번째집][시작집색][i번째집색]
        int[][] arr = new int[N][3];


        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }
        for (int j = 0; j < 3; j++) { // 초기값 설정
            dp[0][j][j] = arr[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j][0] = Math.min(dp[i - 1][j][1], dp[i - 1][j][2]) + arr[i][0];
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][1];
                dp[i][j][2] = Math.min(dp[i - 1][j][0], dp[i - 1][j][1]) + arr[i][2];
            }
        }

        int result = MAX;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j != k) {
                    result = Math.min(result, dp[N - 1][j][k]);
                }
            }
        }
        System.out.println(result);
    }
}
