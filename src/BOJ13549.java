import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ13549 {
    static class Pair {
        int X, cnt;

        public Pair(int A, int B) {
            X = A;
            cnt = B;
        }
    }
    static int N, K;
    static boolean[] visited = new boolean[100001];

    public static int BFS(Queue<Pair> q) {
        int size = q.size();
        while (!q.isEmpty()) {
            Pair p = q.peek();
            int X = p.X;
            int cnt = p.cnt;

            if (X == K) {
                return cnt;
            }
            if (2 * X <= 100000 && !visited[2 * X]) {
                visited[2 * X] = true;
                Pair p_tmp = new Pair(2*X, cnt);
                q.offer(p_tmp);
            }
            if (X - 1 >= 0 && !visited[X - 1]) {
                visited[X - 1] = true;
                Pair p_tmp = new Pair(X - 1, cnt + 1);
                q.offer(p_tmp);
            }
            if (X + 1 <= 100000 && !visited[X + 1]) {
                visited[X + 1] = true;
                Pair p_tmp = new Pair(X + 1, cnt + 1);
                q.offer(p_tmp);
            }
            q.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(N, 0);
        q.offer(p);
        visited[N] = true;
        System.out.println(BFS(q));
    }
}
