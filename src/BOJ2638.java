import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2638 {
    static class Point {
        public int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Point> q = new LinkedList<>();

    public static boolean isCheeseMelt(int y, int x) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            if (map[y + dy[d]][x + dx[d]] == 2) {
                cnt++;
            }
        }
        return cnt >= 2;
    }

    public static void air_update(int y, int x) {
        map[y][x] = 2;
        for (int d = 0; d < 4; d++) {
            int new_y = y + dy[d];
            int new_x = x + dx[d];

            if (new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {
                if (map[new_y][new_x] == 0) {
                    air_update(new_y, new_x);
                }
            }
        }
    }

    public static int solve(int cnt) {
        boolean complete = true;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (map[i][j] == 1) {
                    complete = false;
                    if (isCheeseMelt(i, j)) {
                        map[i][j] = 0;
                        q.add(new Point(i, j));
                    }
                }
            }
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
            air_update(p.y, p.x);
        }

        if (complete) {
            return cnt;
        } else {
            return solve(cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        air_update(0, 0);
        System.out.println(solve(0));
    }
}
