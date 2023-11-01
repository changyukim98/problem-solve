import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {
    static class Node {
        int value;
        Node left_node;
        Node right_node;

        Node(int value) {
            this.value = value;
        }
    }

    static int[] arr = new int[10000];

    public static void make_tree(Node tree_root, int n) {
        for (int i = 1; i < n; i++) {
            Node cur_node = tree_root;
            Node next_node;

            while (true) {
                if (arr[i] < cur_node.value) {
                    if (cur_node.left_node == null) {
                        cur_node.left_node = new Node(arr[i]);
                        break;
                    }
                    next_node = cur_node.left_node;
                } else {
                    if (cur_node.right_node == null) {
                        cur_node.right_node = new Node(arr[i]);
                        break;
                    }
                    next_node = cur_node.right_node;
                }
                cur_node = next_node;
            }
        }
    }

    public static void postorder(Node cur_node) {
        if (cur_node.left_node != null) {
            postorder(cur_node.left_node);
        }
        if (cur_node.right_node != null) {
            postorder(cur_node.right_node);
        }
        System.out.println(cur_node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = 0;
        String input;
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            arr[n++] = Integer.parseInt(input);
        }
        Node tree_root = new Node(arr[0]);
        make_tree(tree_root, n);
        postorder(tree_root);
    }
}
