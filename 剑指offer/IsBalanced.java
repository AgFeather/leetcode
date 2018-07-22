/*
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null) return true;
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    if (Math.abs(left - right) > 1) {return false;}
    return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
}
public int getHeight(TreeNode root){
    if (root == null) {return 0;}
    int left = getHeight(root.left);
    int right = getHeight(root.right);
    return 1 + Math.max(left, right);
}
