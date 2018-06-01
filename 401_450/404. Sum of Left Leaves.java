/*
Find the sum of all left leaves in a given binary tree.
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree,
with values 9 and 15 respectively. Return 24.

*/

//注意区分左右叶子节点
public int sumOfLeftLeaves(TreeNode root){
    if (root == null ) {
        return 0;
    }
    if (root.left == null) {//如果root左子树为null，那么返回右节点的递归
        return sumOfLeftLeaves(root.right);
    }
    if (root.left.left == null && root.left.right == null) {//root的左子树是叶子节点，
        return root.left.val + sumOfLeftLeaves(root.right);
    }
    return sumOfLeftLeaves(root.right) + sumOfLeftLeaves(root.left);//root的左右子树
}
