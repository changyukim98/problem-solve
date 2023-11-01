import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17144 {
    static int R, C, T;
    static int[][] map;
    static int[][] lazy_diffusion;

    public static void dustDiffusion() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < R; i++) {
            Arrays.fill(lazy_diffusion[i], 0);
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    for (int d = 0; d < 4; d++) {
                        int new_i = i + dy[d];
                        int new_j = j + dx[d];
                        if (new_i >= 0 && new_i < R && new_j >= 0 && new_j < C) {
                            if (map[new_i][new_j] != -1) {
                                lazy_diffusion[new_i][new_j] += map[i][j] / 5;
                                lazy_diffusion[i][j] -= map[i][j] / 5;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += lazy_diffusion[i][j];
            }
        }
    }

    public static void airCleaning() {
        int ac_up = 0, ac_down = 0;

        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                ac_up = i;
                ac_down = i + 1;
                break;
            }
        }

        for (int i = ac_up - 2; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        for (int j = 1; j < C; j++) {
            map[0][j - 1] = map[0][j];
        }
        for (int i = 1; i <= ac_up; i++) {
            map[i - 1][C - 1] = map[i][C - 1];
        }
        for (int j = C - 2; j >= 1; j--) {
            map[ac_up][j + 1] = map[ac_up][j];
        }
        map[ac_up][1] = 0;

        for (int i = ac_down + 2; i < R; i++) {
            map[i - 1][0] = map[i][0];
        }
        for (int j = 1; j < C; j++) {
            map[R - 1][j - 1] = map[R - 1][j];
        }
        for (int i = R - 2; i >= ac_down; i--) {
            map[i + 1][C - 1] = map[i][C - 1];
        }
        for (int j = C - 2; j >= 1; j--) {
            map[ac_down][j + 1] = map[ac_down][j];
        }
        map[ac_down][1] = 0;
    }

    public static void solve() {
        for (int t = 0; t < T; t++) {
            dustDiffusion();
            airCleaning();
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    result += map[i][j];
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        lazy_diffusion = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve();
    }
}