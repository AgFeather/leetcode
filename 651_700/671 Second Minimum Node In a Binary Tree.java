/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
 */


/*
解题思路：在这个特殊的树中，root的val一定是最小值，那么只需要遍历所有叶子节点，
并找到比最小值大的第二小值即可。可以通过定义全局变量来记录结果值
先将全局变量置为最大值，然后不断更新，如果最后全局变量仍未最大值，说明树中元素相同，return -1
 */
int res = Integer.MAX_VALUE;
public int findSecondMinimumValue(TreeNode root) {
    if(root == null)
        return -1;
    findNum(root, root.val);
    if (res == Integer.MAX_VALUE)
        return -1;
    return res;
}
public void findNum(TreeNode node,  int rootVal){
    if (node.left == null) {
        if (node.val < res && node.val != rootVal)
            res = node.val;
        return;
    }
    findNum(node.left,  rootVal);
    findNum(node.right,  rootVal);
}
