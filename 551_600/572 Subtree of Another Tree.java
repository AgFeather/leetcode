/*
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
 */


/*
思路比较清晰，首先遍历tree s，如果当前s.val=t.val。就说明当前s的节点可能和t一样。进而调用check函数，
同时需要继续遍历tree s剩余节点。因为s节点值并不唯一，可能存在其他节点和t.val等值。

check函数就是对两个输入的树同时进行DFS，判断两个树的形状和每个节点的值是否相同
 */
public boolean isSubtree(TreeNode s, TreeNode t){
    if (s == null || t == null) {
        return false;
    }if (s.val != t.val) {
        return isSubtree(s.right,t)||isSubtree(s.left, t);
    }else
        return check(s, t)||isSubtree(s.right,t)||isSubtree(s.left, t);
}
public boolean check(TreeNode s, TreeNode t){
    if (s == null && t == null) {
        return true;
    }if ((s!=null&&t==null)||(s==null&&t!=null)) {
        return false;
    }if (s.val == t.val) {
        return check(s.right,t.right)&&check(s.left, t.left);
    }
    return false;
}
