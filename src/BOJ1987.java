import java.util.Scanner;

public class BOJ1987 {
    public static int R, C;
    public static char[][] map;
    public static boolean[][] visited;
    public static boolean[] alpha_used = new boolean[26];

    public static int DFS(int y, int x, int cnt) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int max = cnt;
        char cur_alpha = map[y][x];

        alpha_used[cur_alpha - 65] = true;
        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int new_x = x + dx[d];
            int new_y = y + dy[d];
            char new_alpha = map[new_y][new_x];

            if (new_alpha >= 65 && !visited[new_y][new_x] && !alpha_used[new_alpha - 65]) {
                int result = DFS(new_y, new_x, cnt + 1);
                max = Math.max(max, result);
            }
        }
        alpha_used[cur_alpha - 65] = false;
        visited[y][x] = false;

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R + 2][C + 2];
        visited = new boolean[R + 2][C + 2];

        for (int i = 1; i <= R; i++) {
            String s = sc.next();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j - 1);
            }
        }
        System.out.println(DFS(1, 1, 1));
    }
}
