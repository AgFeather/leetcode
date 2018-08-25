/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */




/*
解题思路： 最开始以为这道题是DFS，但是发现核心思想是不断按层构建新的string加入到list中，所以是BFS
new两个队列分别存放当前的String和treeNode。然后循环queue直到遍历所有点。
当遍历到叶子节点时，说明已经完成了一条path，将结果加入到最开始new的res 的list中
 */
public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if(root == null)
        return result;
    Queue<String> res = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    res.offer(root.val + "");
    queue.offer(root);
    while(!queue.isEmpty()){
        TreeNode tempNode = queue.poll();
        String tempString = res.poll();
        if (tempNode.right == null && tempNode.left == null) {
            result.add(tempString);
        }if (tempNode.right != null) {
            queue.offer(tempNode.right);
            res.offer(tempString +  "->" + tempNode.right.val);
        }if (tempNode.left != null) {
            queue.offer(tempNode.left);
            res.offer(tempString + "->" + tempNode.left.val);
        }
    }
    return result;
}


//一种使用StringBuffer的DFS解法，使用StringBuffer好处是不需要过多的额外空间
public List<String> binaryTreePaths(TreeNode root) {
    List<String> rst = new ArrayList<String>();
    if(root == null) return rst;
    StringBuilder sb = new StringBuilder();
    helper(rst, sb, root);
    return rst;
}

public void helper(List<String> rst, StringBuilder sb, TreeNode root){
    if(root == null) return;
    int tmp = sb.length();
    if(root.left == null && root.right == null){
        sb.append(root.val);
        rst.add(sb.toString());
        sb.delete(tmp , sb.length());
        return;
    }
    sb.append(root.val + "->");
    helper(rst, sb, root.left);
    helper(rst, sb, root.right);
    sb.delete(tmp , sb.length());
    return;
}
