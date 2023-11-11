import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1202 {

    static class GemMassCompare implements Comparator<Gem> {
        @Override
        public int compare(Gem o1, Gem o2) {
            if (o1.M > o2.M) {
                return 1;
            } else if (o1.M == o2.M) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    static class Gem {
        private int M, V;

        public Gem(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    static int N, K;
    static int[] C;
    static List<Gem> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        C = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            list.add(new Gem(M, V));
        }

        for (int i = 0; i < K; i++) {
            C[i] = Integer.parseInt(br.readLine());
        }
        list.sort(new GemMassCompare());
        Arrays.sort(C);

        // 가장 작은 가방부터 가능한 큰 보석을 집어넣기
        int idx = 0;
        long result = 0;
        for (int i = 0; i < K; i++) {

            while (idx < N && list.get(idx).M <= C[i]) {
                pq.add(list.get(idx++).V);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
