import java.util.*;

public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < tokens.length) {
            TreeNode parent = queue.poll();

            if (idx < tokens.length && !tokens[idx].equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(tokens[idx]));
                queue.offer(parent.left);
            }
            idx++;

            if (idx < tokens.length && !tokens[idx].equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(tokens[idx]));
                queue.offer(parent.right);
            }
            idx++;
        }

        return root;
    }
}
