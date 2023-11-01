import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ2448 {
    public static boolean[][] arr = new boolean[3073][6146];

    public static void draw_star(int N, int y, int x) {
        if (N % 2 == 0) {
            draw_star(N / 2, y - N / 2, x); // up
            draw_star(N / 2, y, x - N / 2); // left
            draw_star(N / 2, y, x + N / 2); // right
        } else {
            arr[y - 2][x] = true;
            arr[y - 1][x - 1] = arr[y - 1][x + 1] = true;
            for (int i = 0; i < 5; i++) {
                arr[y][x - 2 + i] = true;
            }
        }
    }

    public static void print_star(int N) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 2 * N; j++) {
                if (arr[i][j]) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        int N;
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        draw_star(N, N, N);
        print_star(N);
    }
}