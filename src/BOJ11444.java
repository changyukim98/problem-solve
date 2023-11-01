import java.util.HashMap;
import java.util.Scanner;

public class BOJ11444 {
    public static HashMap<Long, Long> memo = new HashMap<>();

    public static long fibonacci(long n) {
        // k[0] = f(k+1), k[1] = f(k), k[2] = f(k-1)
        int mod = 1000000007;
        long[] k = new long[3];

        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            for (int i = 0; i < 3; i++) {
                if (!memo.containsKey(n / 2 + 1 - i)) {
                    k[i] = fibonacci(n / 2 + 1 - i);
                    memo.put(n / 2 + 1 - i, k[i]);
                } else {
                    k[i] = memo.get(n / 2 + 1 - i);
                }
            }
            if (n % 2 == 0) {
                return ((k[1] * k[0]) % mod + (k[2] * k[1]) % mod) % mod;
            } else {
                return ((k[0] * k[0]) % mod + (k[1] * k[1]) % mod) % mod;
            }
        }

    }

    public static void main(String[] args) {
        long n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextLong();
        System.out.println(fibonacci(n));
    }
}