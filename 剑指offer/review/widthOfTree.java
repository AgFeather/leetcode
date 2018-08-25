/*
求给定二叉树的宽度
 */


import java.util.*;
public int widthOfTree(TreeNode root){
    Queue<TreeNode> queue = new Queue<>();
    queue.offer(root);
    int size = 1;
    int res = 1;
    TreeNode temp = null;
    while(!queue.isEmpty()){
        size = queue.size();
        res = Math.max(res, size);
        while(size > 0){
            temp = queue.poll();
            size--;
            if (temp.left != null){queue.offer(temp.left);}
            if (temp.right != null){queue.offer(temp.right);}
        }
    }
    return res;
}
