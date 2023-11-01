import java.util.Scanner;

public class BOJ2420 {
    public static void main(String[] args) {
        long N, M;
        Scanner sc = new Scanner(System.in);

        N = sc.nextLong();
        M = sc.nextLong();

        System.out.println(Math.abs(N - M));
    }
}
