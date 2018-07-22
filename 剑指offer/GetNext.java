/*
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

/*
三种情况：
1. 如果node有right，只需要返回其右子树中最靠左边的节点
2. 如果node没有right，并且node是其父亲节点的左节点，返回node的父节点
3. 如果node没有right，并且node是其父亲节点的右节点，向上递归，重复判断2， 3步

注意：此题不难，但一定要将三种情况都考虑到
 */
public TreeLinkNode GetNext(TreeLinkNode pNode){
    if (pNode == null) return null;
    if (pNode.right != null){return findRight(pNode.right);}
    return findFather(pNode);
}
public TreeLinkNode findFather(TreeLinkNode pNode){
    if (pNode.next == null) {return null;}
    if (pNode.next.left == pNode) {return pNode.next;}
    return findFather(pNode.next);
}
public TreeLinkNode findRight(TreeLinkNode root){
    if (root.left == null) {return root;}
    return findRight(root.left);
}
