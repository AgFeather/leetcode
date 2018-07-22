/*
题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）中，
按结点数值大小顺序第三小结点的值为4。
 */

// 思路比较清晰，递归每个节点，并统计该节点的左子树的个数，不断修改递归的k值即可，注意边界检查
TreeNode KthNode(TreeNode pRoot, int k) {
    if (k <= 0 || getNumber(pRoot) < k) return null;
    int leftNum = getNumber(pRoot.left);
    if (k-leftNum == 1) return pRoot;
    else if(k > leftNum) return KthNode(pRoot.right, k-leftNum-1);
    return KthNode(pRoot.left, k);
}

public int getNumber(TreeNode root){
    if (root == null) return 0;
    return 1 + getNumber(root.left) + getNumber(root.right);
}
