import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2206 {
    static class Cond {
        public int y, x;
        boolean isBroke;

        public Cond(int y, int x, boolean isBroke) {
            this.y = y;
            this.x = x;
            this.isBroke = isBroke;
        }
    }
    public static int N, M;
    public static char[][] map;
    public static boolean[][][] visited;

    public static Queue<Cond> q = new LinkedList<>();

    public static int BFS(int cnt) {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        int size = q.size();

        while (size-- > 0) {
            Cond c = q.poll();
            int y = c.y;
            int x = c.x;
            boolean isBroke = c.isBroke;

            if (y == N && x == M) {
                return cnt;
            }

            int visit_mod = isBroke ? 0 : 1;
            for (int d = 0; d < 4; d++) {
                if (map[y + dy[d]][x + dx[d]] == '0' && !visited[y + dy[d]][x + dx[d]][visit_mod]) {
                    Cond c_new = new Cond(y + dy[d], x + dx[d], isBroke);
                    q.add(c_new);
                    visited[y + dy[d]][x + dx[d]][visit_mod] = true;
                } else if (!isBroke && map[y + dy[d]][x + dx[d]] == '1' && !visited[y + dy[d]][x + dx[d]][1]) {
                    Cond c_new = new Cond(y + dy[d], x + dx[d], true);
                    q.add(c_new);
                    visited[y + dy[d]][x + dx[d]][1] = true;
                }
            }
        }
        if (q.isEmpty()) {
            return -1;
        } else {
            return BFS(cnt + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N + 2][M + 2];
        visited = new boolean[N + 2][M + 2][2];

        for (int i = 1; i <= N; i++) {
            String map_info = sc.next();
            for (int j = 1; j <= map_info.length(); j++) {
                map[i][j] = map_info.charAt(j - 1);
            }
        }
        Cond temp = new Cond(1, 1, false);
        q.add(temp);
        visited[1][1][0] = true;
        System.out.println(BFS(1));
    }
}
