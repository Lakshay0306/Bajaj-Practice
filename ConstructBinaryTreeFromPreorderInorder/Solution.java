import java.util.*;

class Solution {
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode node = new TreeNode(rootVal);

        int inorderPos = inorderMap.get(rootVal);

        node.left = construct(preorder, left, inorderPos - 1);
        node.right = construct(preorder, inorderPos + 1, right);

        return node;
    }
}
