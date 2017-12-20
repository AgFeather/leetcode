/*
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
*/

//求解整个BST任意两个val的最小差值
//遍历每一个点，并找到这个点左子树的最大值，右子树的最小值，然后找到该点的最小差值
//继续向下递归左右子树，分别找到左右子树的最小差值，并return 三者中的最小值。

class Solution {
    public int getMinimumDifference(TreeNode root){
		return recursiveNode(root);
	}

	public int recursiveNode(TreeNode root){
		if (root == null) {
			return 99999;//返回一个极大值，表示该点无最小差值
		}
		int x = Math.abs(findNext(root.right)-root.val);
		int y = Math.abs(findBefore(root.left)-root.val);
		int minTemp = x<y?x:y;//计算这个点的最小差值
		int minRight = recursiveNode(root.right);
		int minLeft = recursiveNode(root.left);
		return minRight<minTemp?(minRight<minLeft?minRight:minLeft):(minTemp<minLeft?minTemp:minLeft);//返回三者中的最小值
	}
	public int findNext(TreeNode root){//查找root右子树中的最小值
		if (root == null) {
			return -99999;
		}
    if (root.left==null) {//root没有左子树时，表示该点为最小值点。
			return root.val;
		}
		int temp = 0;
		if (root.left!=null) {//向左子树递归
			temp = findNext(root.left);
		}
		return temp;
	}
	public int findBefore(TreeNode root){//查找root左子树的最大值
		if (root == null) {
			return -99999;
		}
        if (root.right==null) {//root没有右子树时，表示该点为最小值点。
			return root.val;
		}
		int temp = 0;
		if (root.right!=null) {
			temp = findBefore(root.right);
		}
		return temp;
	}
}



//一个O(n)时间内解决的方法，从左到右遍历每个节点，并记录前一节点然后计算最小值。
	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root){
		inorder(root);
		return minDiff;
	}
	public void inorder(root){
		if (root == null) {
			return;
		}
		inorder(root.left);
		if (prev!=null) {
			minDiff = Math.min(minDiff,root.val - prev.val);
		}
		inorder(root.right);
	}
