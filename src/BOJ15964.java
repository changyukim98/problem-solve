import java.util.Scanner;

public class BOJ15964 {
    public static long at_func(int A, int B) {
        return (long)(A + B) * (A - B);
    }

    public static void main(String[] args) {
        int A, B;
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();

        System.out.println(at_func(A, B));
    }
}
