import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class Main {

    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.print(node.val + " ");

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        if (n == 0) return;

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
        root = invertTree(root);

        levelOrder(root);
    }
}
