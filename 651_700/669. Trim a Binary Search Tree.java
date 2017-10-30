//Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

//解题思路，因为给定树为二叉搜索树，故可以递归判断所有节点，如果小于最小值则返回right，大于最大值则返回left。val满足要求则对节点的right和left进行递归。

public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
			return null;
		}
        if (root.val<L) {
			return trimBST(root.right, L, R);
		}
        if (root.val>R){
			return trimBST(root.left, L, R);
		}
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
