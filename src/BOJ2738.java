import java.util.Scanner;

public class BOJ2738 {
    public static void main(String[] args) {
        int N, M;
        int[][] matrix_A = new int[100][100];
        int[][] matrix_B = new int[100][100];
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix_A[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix_B[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix_A[i][j] + matrix_B[i][j] + " ");
            }
            System.out.println();
        }
    }
}
