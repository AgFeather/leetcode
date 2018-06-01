

/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
 */


//因为输入数组是已经排序，所以只需要选择第n/2个元素将数组分开，数组前半部分作为左子树
//后半部分作为右子树，往下递归即可，这里注意递归跳出条件
public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null) {
			return null;
		}
		return toBST(nums, 0, nums.length-1);
    }
	public TreeNode toBST(int[] nums, int left, int right){
		if (left > right) {
			return null;
		}
		int center = (right-left)/2 + left;
		TreeNode node = new TreeNode(nums[center]);
		node.right = toBST(nums, center+1, right);
		node.left = toBST(nums, left, center-1);
		return node;
	}
