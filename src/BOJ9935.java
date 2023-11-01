import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String bomb = sc.next();

        Stack<Character> st = new Stack<>();
        Stack<Character> backup = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));

            if (st.peek() == bomb.charAt(bomb.length() - 1)) {
                for (int j = bomb.length() - 1; j >= 0; j--) {
                    if (!st.isEmpty() && st.peek() == bomb.charAt(j)) {
                        backup.push(st.pop());
                    } else {
                        while (!backup.isEmpty()) {
                            st.push(backup.pop());
                        }
                        break;
                    }
                }
                backup.clear();
            }
        }

        char[] ans = new char[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        if (ans.length == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(ans);
        }
    }
}
