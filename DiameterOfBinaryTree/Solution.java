class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        computeDepth(root);
        return maxDiameter;
    }

    private int computeDepth(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = computeDepth(node.left);
        int rightDepth = computeDepth(node.right);

        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
