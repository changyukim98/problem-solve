import java.util.Scanner;

public class BOJ15666 {

    static int N, M;
    static int[] arr;
    static int[] arr2;

    public static void sort() {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void solve(int cur, int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                System.out.printf("%d ", arr2[i]);
            }
            System.out.println();
        } else {
            int last_num = 0;
            for (int i = cur; i < N; i++) {
                if (last_num != arr[i]) {
                    arr2[cnt] = arr[i];
                    last_num = arr[i];
                    solve(i, cnt + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[8];
        arr2 = new int[8];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sort();
        solve(0, 0);
    }
}
