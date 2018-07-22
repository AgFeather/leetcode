/*
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */


// 思路很清晰，用一个boolean表示方向即可
public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (pRoot == null) return res;
    boolean leftToRight = true; //True从左到右， false从右到左
    ArrayList<TreeNode> tempTree = new ArrayList<>();
    tempTree.add(pRoot);
    Stack<ArrayList<TreeNode>> stack = new Stack<>();
    stack.push(tempTree);
    while(!stack.isEmpty()){
        tempTree = stack.pop();
        ArrayList<Integer> tempValue = new ArrayList<>();
        ArrayList<TreeNode> nextTree = new ArrayList<>();
        for (TreeNode node : tempTree) {
            tempValue.add(node.val);
            if (node.left != null){nextTree.add(node.left);}
            if (node.right != null){nextTree.add(node.right);}
        }
        if (nextTree.size() != 0){stack.push(nextTree);}
        if (!leftToRight){Collections.reverse(tempValue);}
        leftToRight != leftToRight;
        res.add(tempValue);
    }
    return res;
}
