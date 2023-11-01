import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

public class BOJ1967 {
    static class Node {
        int node;
        int dist;

        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static HashMap<Integer, Vector<Node>> map = new HashMap<>();
    public static int[][][] tree = new int[10001][3][2]; // [n번째노드][부모,자식1,자식2][번호,가중치]
    public static boolean[] check = new boolean[10001];

    public static Node DFS(int node) {
        Node result = new Node(node, 0);
        Vector<Node> nodes = map.get(node);

        for (int i = 0; nodes != null && i < nodes.size(); i++) {
            Node cn = nodes.get(i);
            int cn_num = cn.node;
            int cn_dist = cn.dist;

            if (!check[cn_num]) {
                check[cn_num] = true;
                Node nextNode = DFS(cn_num);
                if (nextNode.dist + cn_dist > result.dist) {
                    result.node = nextNode.node;
                    result.dist = nextNode.dist + cn_dist;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n;
        n = sc.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int pn = sc.nextInt();
            int cn = sc.nextInt();
            int dist = sc.nextInt();

            Vector<Node> p_v;
            if (!map.containsKey(pn)) {
                p_v = new Vector<Node>();
            } else {
                p_v = map.get(pn);
            }
            p_v.add(new Node(cn, dist));
            map.put(pn, p_v);

            Vector<Node> c_v;
            if (!map.containsKey(cn)) {
                c_v = new Vector<Node>();
            } else {
                c_v = map.get(cn);
            }
            c_v.add(new Node(pn, dist));
            map.put(cn, c_v);
        }

        check[1] = true;
        Node far_node = DFS(1);

        Arrays.fill(check, false);
        int far_node_num = far_node.node;
        check[far_node_num] = true;
        int result_dist = DFS(far_node_num).dist;

        System.out.println(result_dist);
    }
}