/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.


*/

//注意区分左右叶子节点

class Solution {
    public int sumOfLeftLeaves(TreeNode root){
		int sum = 0;
        if (root==null||isLeft(root)) {
			return 0;
		}
		sum = sumIt(root,sum);
		return sum;
	}
	public int sumIt(TreeNode node, int sum){
		if (node == null) {
			return 0;
		}
		if (isLeft(node)) {
			sum+=node.val;
			return sum;
		}
		int temp = sumIt(node.left,sum);
		if (node.right!=null&&isLeft(node.right)) {//判断是该节点的右子节点是否为右叶子节点
			return temp;
		}
		else
			temp+=sumIt(node.right,sum);
		return temp;
	}
	public boolean isLeft(TreeNode node){
		if (node.right == null&&node.left == null) {
			return true;
		}
		return false;
	}
}
