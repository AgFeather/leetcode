/*
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */


ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (pRoot == null) return res;
    Queue<ArrayList<TreeNode>> queue = new LinkedList<>();
    ArrayList<TreeNode> temp = new ArrayList<>();
    temp.add(pRoot);
    queue.offer(temp);
    while(!queue.isEmpty()){
        temp = queue.poll();
        ArrayList<Integer> valueTemp = new ArrayList<>();
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        for (TreeNode tempNode : temp) {
            valueTemp.add(tempNode.val);
            if (tempNode.left != null) {nodeList.add(tempNode.left);}
            if (tempNode.right != null) {nodeList.add(tempNode.right);}
        }
        res.add(valueTemp);
        if (nodeList.size() != 0) {queue.offer(nodeList);} //注意判断是否nodeList为空，要不会死循环

    }
    return res;
}
