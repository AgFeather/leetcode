/*
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
/*
思路很清晰，递归求深度
 */
public int TreeDepth(TreeNode root){
    if (root == null) {
        return 0;
    }
    int temp = Math.max(TreeDepth(root.left), TreeDepth(root.right));
    return temp+1;
}
