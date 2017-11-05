//invert a binary tree

public TreeNode invertTree(TreeNode root) {
            if (root == null) {
        	return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }
