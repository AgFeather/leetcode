/*

输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

//注意本题定义并不同于一般子树，而是子结构
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return eval(root1, root2)||HasSubtree(root1.right,root2)||HasSubtree(root1.left, root2);
        }
        return HasSubtree(root1.right, root2) || HasSubtree(root1.left, root2);
    }

    public boolean eval(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null && root1 != null) {
            return true;//子树和子结构的区别，root1可以在root2为null时仍然不为null
        }
        if (root1.val != root2.val) {
            return false;
        }
        return eval(root1.right, root2.right) && eval(root1.left, root2.left);
    }
 }
