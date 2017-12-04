//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

//The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

//example: input:[1,2,3,4]    output:"1(2(4))(3)"
//example: input:[1,2,3,null,4]    output:"1(2()(4))(3)"






class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
			return "";
		}
		if (t.left == null&&t.right == null) {
			return ""+t.val;
		}
        if (t.right == null) {
			return t.val+"("+tree2str(t.left)+")";
		}
		return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
    }
}
