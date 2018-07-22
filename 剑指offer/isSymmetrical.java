/*
对称的二叉树


请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */


// 思路很清晰，向下递归左右子树即可
boolean isSymmetrical(TreeNode pRoot){
    if (pRoot == null) return true;
    return helper(pRoot.left, pRoot.right);
}

boolean helper(TreeNode left, TreeNode right){
    if (left == null && right == null) return true;
    else if (left == null && right != null) return false;
    else if (left != null && right == null) return false;
    if (left.val != right.val) return false;
    return helper(left.left, right.right) && helper(left.right, right.left);
}
