import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    static int diameter = 0;

    static int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }

    static int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) {
            System.out.println(0);
            return;
        }

        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n) nodes[i].left = nodes[left];
            if (right < n) nodes[i].right = nodes[right];
        }

        TreeNode root = nodes[0];

        System.out.println(diameterOfBinaryTree(root));
    }
}
