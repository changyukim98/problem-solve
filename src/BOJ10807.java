import java.util.Scanner;

public class BOJ10807 {
    public static void main(String[] args) {
        int N;
        int[] arr = new int[201];
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            arr[num + 100]++;
        }
        int v = sc.nextInt();
        System.out.println(arr[v + 100]);
    }
}
