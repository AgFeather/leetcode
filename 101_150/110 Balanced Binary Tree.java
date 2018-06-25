/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 */


//思路：遍历整颗树，对每个节点都返回它左右子树的长度是否满足条件。
public boolean isBalanced(TreeNode root){
    if (root == null) return true;
    int left = getHigh(root.left);
    int right = getHigh(root.right);
    return (Math.abs(left - right) <= 1) && isBalanced(root.right) && isBalanced(root.left);
}
public int getHigh(TreeNode root){
    if(root == null)
        return 0;
        int length = Math.max(getHigh(root.right), getHigh(root.left));
        return length + 1;
}
