import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class BOJ16953 {
    final static int max_value = 1000000000;
    public static long A, B;

    public static int BFS(Queue<Long> q, int cnt) {
        int size = q.size();
        while (size-- > 0) {
            if (!q.isEmpty()) {
                long X = q.peek();
                long new_X1 = X * 2;
                long new_X2 = X * 10 + 1;

                if (X == B) {
                    return cnt;
                } else {
                    if (new_X1 < max_value) {
                        q.offer(new_X1);
                    }
                    if (new_X2 < max_value) {
                        q.offer(new_X2);
                    }
                }
                q.poll();
            }
        }
        if (q.isEmpty()) return -1;
        else return BFS(q, cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextLong();
        B = sc.nextLong();

        Queue<Long> q = new LinkedList<>();
        q.offer(A);
        System.out.println(BFS(q, 1));
    }
}
