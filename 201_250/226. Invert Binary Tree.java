//invert a binary tree
/*
     4
   /   \
  2     7
 / \   / \
1   3 6   9
to

     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

//不断递归交换左右子树
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
