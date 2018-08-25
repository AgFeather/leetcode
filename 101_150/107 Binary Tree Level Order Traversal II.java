/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */

/*
核心思想是考察树的BFS遍历，但同时，需要考虑如何分离不同层次的节点。
方法是每次队列弹出的都是上一个层次节点的list，然后new一个新的list，并遍历
上一层次节点list，将其中的子节点都加入到新的list，然后offer进队列。
需要注意的是，offer进队列时，需要判断新的 list是否为空，否则会死循环。
最后使用stack将结果list颠倒过来即可
 */

public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
           return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<TreeNode>> queue = new LinkedList<>();
        List<TreeNode> temp = new ArrayList<>();
        temp.add(root);
        queue.offer(temp);
        while(!queue.isEmpty()){
            List<TreeNode> fatherNode = queue.poll();
            List<Integer> tempList = new ArrayList<>();
            List<TreeNode> childNode = new ArrayList<>();
            for (TreeNode node : fatherNode ) {
                tempList.add(node.val);
                if (node.left != null)
                    childNode.add(node.left);
                if (node.right != null)
                    childNode.add(node.right);
            }
            if (!childNode.isEmpty()) {
                queue.offer(childNode);
            }
            res.add(tempList);
        }
        Collections.reverse(res);
        return res;
    }
