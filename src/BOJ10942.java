import java.io.*;
import java.util.StringTokenizer;

public class BOJ10942 {
    static int N, M;
    static int[] nums;
    static int[][] palindrome; // [s][e] 0:미확인, 1:팰린드롬이 아님, 2:팰린드롬임

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        palindrome = new int[N + 1][N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; st.hasMoreTokens(); i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            if (isPalindrome(S, E)) {
                bw.write('1');
            } else {
                bw.write('0');
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static boolean isPalindrome(int S, int E) {
        boolean result = false;
        if (S <= E) {
            if (palindrome[S][E] == 0) {
                if (nums[S] == nums[E]) {
                    if (S + 2 <= E) {
                        if (isPalindrome(S + 1, E - 1)) {
                            result = true;
                            palindrome[S][E] = 2;
                        } else {
                            palindrome[S][E] = 1;
                        }

                    } else {
                        result = true;
                        palindrome[S][E] = 2;
                    }
                } else {
                    palindrome[S][E] = 1;
                }
            } else if (palindrome[S][E] == 2) {
                result = true;
            }
        }
        return result;
    }
}
