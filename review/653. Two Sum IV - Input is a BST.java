//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
//对于BST中每一个点，都在BST中查找是否存在节点值等于 k-node.val，存在则return true

class Solution {
   public boolean findTarget(TreeNode root, int k){
		if (root == null) {
			return false;
		}
		return findTarget2(root,root,k);
	}
	public boolean findTarget2(TreeNode root,TreeNode node, int k){//递归遍历每一个节点，并且从root节点开始查找BST是否存在k-node.val
		if (node == null) {
			return false;
		}
		return isContain(root,node,k-node.val)||findTarget2(root,node.left,k)||findTarget2(root,node.right,k);
		
	}
	public boolean isContain(TreeNode root,TreeNode thisNode,int k){//传入thisnode是为了防止出现 k = node.val的情况
		if (root == null||root == thisNode) {
			return false;
		}
		if (root.val == k) {
			return true;
		}
		if (k>root.val) {
			return isContain(root.right,thisNode,k);
		}
		if (k < root.val) {
			return isContain(root.left,thisNode,k);
		}
		else
			return false;
	}
}






//这个是一个更加高效的方法，分别将树的最左边一支干和最右边枝干放入到两个stack中，然后用两个栈peek的和与k比较，大于k的话，将l_stack的pop的所有右子树压入栈中
//小于k的话，讲r_stack的pop的所有左子树压入栈中，等于k则返回true
public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
    	Stack<TreeNode> l_stack = new Stack<>();
    	Stack<TreeNode> r_stack = new Stack<>();
    	stackAdd(l_stack, root, true);
    	stackAdd(r_stack, root, false);
    	while(l_stack.peek() != r_stack.peek()){
    	    int n = l_stack.peek().val + r_stack.peek().val;
    	    if(n == k){
    		return true;
    	    }else if(n > k){
    		stackNext(r_stack, false);
    	    }else{
		stackNext(l_stack, true);
    	    }
    	}
    	return false;
    }
    
    private void stackAdd(Stack<TreeNode> stack, TreeNode node, boolean isLeft){
    	while(node != null){
    	    stack.push(node);
            node = (isLeft) ? node.left : node.right;
    	}
    }

    private void stackNext(Stack<TreeNode> stack, boolean isLeft){
    	TreeNode node = stack.pop();
    	if(isLeft){
    	    stackAdd(stack, node.right, isLeft);
    	}else{
    	    stackAdd(stack, node.left, isLeft);
    	}
    }
