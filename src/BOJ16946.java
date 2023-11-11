import java.io.*;
import java.util.*;

public class BOJ16946 {

    static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] zero_area;
    static boolean[][] visited;
    static Map<Integer, Integer> hashMap = new HashMap<>(); // <지역번호, 넓이>

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        zero_area = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        solve();
        br.close();
    }

    public static void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        // DFS를 통해 0인 지역의 넓이를 구하고 번호를 부여 후 HashMap에 키와 값으로 저장
        int area_idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && zero_area[i][j] == 0) {
                    //int area = dfsCount(i, j, 1, area_idx);
                    int area = bfsCount(i, j, area_idx);
                    hashMap.put(area_idx++, area);
                }
            }
        }

        // 값이 1인 지역을 상하좌우로 조사해서 중복되지 않게 0인 지역의 넓이를 더해줌
        Map<Integer, Boolean> checkMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    int result = 1;

                    for (int d = 0; d < 4; d++) {
                        int new_y = i + dy[d];
                        int new_x = j + dx[d];
                        if (new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {

                            int area_num = zero_area[new_y][new_x];

                            if (area_num != 0 && !checkMap.containsKey(area_num)) {
                                checkMap.put(area_num, true);
                                result += hashMap.get(area_num);
                            }
                        }
                    }
                    checkMap.clear();
                    bw.write(result % 10 + '0');
                } else {
                    bw.write('0');
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // DFS를 통해 0인 지역의 넓이를 구하고 지역번호를 부여한다.
    public static int dfsCount(int y, int x, int cnt, int area_idx) {
        int result = 0;
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        map[y][x] = 1;
        for (int d = 0; d < 4; d++) {
            int new_y = y + dy[d];
            int new_x = x + dx[d];
            if (new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {
                if (map[new_y][new_x] == 0) {
                    result += dfsCount(new_y, new_x, cnt + 1, area_idx) - cnt;
                }
            }
        }
        map[y][x] = 0;
        zero_area[y][x] = area_idx;
        return cnt + result;
    }

    public static int bfsCount(int y, int x, int idx) {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        Queue<Point> q = new LinkedList<>();

        int cnt = 0;
        q.offer(new Point(y, x));
        visited[y][x] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            zero_area[cur.y][cur.x] = idx;

            for (int d = 0; d < 4; d++) {
                int new_y = cur.y + dy[d];
                int new_x = cur.x + dx[d];

                if (new_y >= 0 && new_y < N && new_x >= 0 && new_x < M) {
                    if (map[new_y][new_x] == 0 && !visited[new_y][new_x]) {
                        q.offer(new Point(new_y, new_x));
                        visited[new_y][new_x] = true;
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}