/*

 */



//使用递归方法不断判断镜像的两个节点，注意递归时传入的节点顺序
public boolean isSymmetric(TreeNode root){
    return root == null || helper(root.left, root.right);
}

public boolean helper(TreeNode left, TreeNode right){
    if (left == null || right == null) {
        return left == right;
    }
    if (left.val != right.val) {
        return false;
    }
    return helper(left.left, right.right)&&helper(left.right, right.left);
}

//使用stack完成非递归实现，思想和递归相同，每次弹出两个node进行比较，注意入栈顺序
public boolean isSymmetric(TreeNode root){
    if(root == null) return true;
    Stack<TreeNode> stack = new  Stack<>();
    TreeNode left, right;
    if (root.left != null) {
        if (root.right == null) {
            return false;
        }
        stack.push(root.left);
        stack.push(root.right);
    }else if(root.right != null)
        return false;
    while(!stack.isEmpty()){
        if (stack.size()%2 != 0) return false;
        right = stack.pop();
        left = stack.pop();
        if (right.val != left.val) return false;
        if (left.left != null) {
            if (right.right == null) return false;
            stack.push(left.left);
            stack.push(right.right);
        }else if (right.right != null) return false;

        if (left.right != null) {
            if (right.left == null) return false;
            stack.push(left.right);
            stack.push(right.left);
        }else if (right.left != null) return false;
    }
    return true;
}
