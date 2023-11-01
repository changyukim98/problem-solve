import java.util.Scanner;

public class BOJ9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String s = sc.next();
            System.out.println(Character.toString(s.charAt(0)) + Character.toString(s.charAt(s.length() - 1)));
        }
    }
}