import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2342 {
    static final int MAX = 400000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[st.countTokens() + 1];
        int[][][] dp = new int[st.countTokens() + 1][5][5]; // [N번째스텝][왼발의위치][오른발의위치]

        for (int i = 1; st.hasMoreTokens(); i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], MAX);
            }
        }

        dp[0][0][0] = 0;
        int i = 1;
        for (; nums[i] != 0; i++) {
            int step = nums[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (step == k) {
                        dp[i][step][j] = Math.min(dp[i][step][j], dp[i - 1][step][j] + 1);
                        dp[i][j][step] = Math.min(dp[i][j][step], dp[i - 1][j][step] + 1);
                    } else if (k == 0) {
                        dp[i][step][j] = Math.min(dp[i][step][j], dp[i - 1][k][j] + 2);
                        dp[i][j][step] = Math.min(dp[i][j][step], dp[i - 1][j][k] + 2);
                    } else if (Math.abs(step - k) % 2 == 0) {
                        dp[i][step][j] = Math.min(dp[i][step][j], dp[i - 1][k][j] + 4);
                        dp[i][j][step] = Math.min(dp[i][j][step], dp[i - 1][j][k] + 4);
                    } else {
                        dp[i][step][j] = Math.min(dp[i][step][j], dp[i - 1][k][j] + 3);
                        dp[i][j][step] = Math.min(dp[i][j][step], dp[i - 1][j][k] + 3);
                    }
                }
            }
        }

        int result = MAX;
        for (int j = 0; j < 5; j++) {
            for (int k = 0; k < 5; k++) {
                result = Math.min(result, dp[i - 1][j][k]);
            }
        }
        System.out.println(result);
    }
}
