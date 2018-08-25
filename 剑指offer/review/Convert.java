/*
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/*
需要复习！！！

这类需要不断调整指针的题最好的方法就是把过程画出来，然后按照图写代码。
 */



 //中序遍历 + 指针调整 + 画图分析
TreeNode curr = null;
TreeNode head = null;
public TreeNode Convert(TreeNode pRootOfTree){
    helper(pRootOfTree);
    return head;
}
public void helper(TreeNode pRootOfTree){
    if (pRootOfTree == null) return;
    helper(pRootOfTree.left);
    if (curr == null){
        curr = pRootOfTree;
        head = pRootOfTree;
    }else{
        curr.right = pRootOfTree;
        pRootOfTree.left = curr;
        curr = pRootOfTree;
    }
    helper(pRootOfTree.right);
}


/*
 方法一：非递归版
 解题思路：
 1.核心是中序遍历的非递归算法。
 2.修改当前遍历节点与前一遍历节点的指针指向。
 */
    import java.util.Stack;
    public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }      
            p = p.right;
        }
        return root;
    }
