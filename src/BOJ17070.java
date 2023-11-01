import java.util.Scanner;


public class BOJ17070 {
    static int N;
    static int[][] map;
    static int[][][] dp;

    public static boolean digonal_check(int y, int x) {
        for (int i = y - 1; i <= y; i++) {
            for (int j = x - 1; j <= x; j++) {
                if (map[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3]; // [][][가로, 세로, 대각선]

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dp[1][2][0] = 1;
        for (int j = 3; j <= N; j++) {
            for (int i = 1; i <= N; i++) {
                if (map[i][j] == 0) {
                    // 가로는 이전의 가로 또는 대각선에서만 만들어짐
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    // 세로는 이전의 세로 또는 대각선에서만 만들어짐
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }
                if (digonal_check(i, j)) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }

            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);

    }
}
