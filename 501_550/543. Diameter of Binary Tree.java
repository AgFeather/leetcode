/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/
//对递归的考察，对于任意节点，他的最大长度等于左子树最大长度+右子树最大长度
//利用一个静态变量保存结果，并与每次递归节点的diameter比较，保存较大值。
class Solution {
  int res = 0;
	public int diameterOfBinaryTree(TreeNode root){
		if (root == null) {
			return 0;
		}
		findLongestPath(root);
		return res;
	}
	public int findLongestPath(TreeNode root){
		if (root == null) {
			return 0;
		}
		int leftLength = findLongestPath(root.left);
		int rightLength = findLongestPath(root.right);
		int length = leftLength+rightLength;
		res = res>length?res:length;
		return (leftLength>rightLength?leftLength:rightLength)+1;
	}
}
