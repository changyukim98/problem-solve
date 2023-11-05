import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2263 {
    static int[] inorder, postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inorder = new int[N];
        postorder = new int[N];

        StringTokenizer in_st = new StringTokenizer(br.readLine());
        for (int i = 0; in_st.hasMoreTokens(); i++) {
            inorder[i] = Integer.parseInt(in_st.nextToken());
        }

        StringTokenizer post_st = new StringTokenizer(br.readLine());
        for (int i = 0; post_st.hasMoreTokens(); i++) {
            postorder[i] = Integer.parseInt(post_st.nextToken());
        }
        pre_traversal(0, N - 1, 0, N - 1);
        System.out.println(sb);
    }

    public static void pre_traversal(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            int root = postorder[pe];
            sb.append(root).append(" ");
            for (int i = is; i <= ie; i++) {
                if (inorder[i] == root) {
                    int len = i - is;
                    pre_traversal(is, i - 1, ps, ps + len - 1);
                    pre_traversal(i + 1, ie, ps + len, pe - 1);
                    break;
                }
            }
        }
    }
}
