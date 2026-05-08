class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long lowerBound, long upperBound) {
        if (node == null) return true;

        if (node.val <= lowerBound || node.val >= upperBound) {
            return false;
        }

        return validate(node.left, lowerBound, node.val)
            && validate(node.right, node.val, upperBound);
    }
}
