/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

Note: If a tree has more than one mode, you can return them in any order.
 */


/*
首先创建一个用于统计出现次数的字典，然后递归遍历整个树，记录每个值出现的次数。
然后统计出现次数最多的节点值
 */
 public int[] findMode(TreeNode root){
     Map<Integer, Integer>map = new HashMap<>();
     helper(root, map);
     ArrayList<Integer> temp = new ArrayList<>();
     int max_value = 0;
     for(Integer tempValue: map.values()){
         max_value = max_value>tempValue?max_value:tempValue;
     }
     for(Integer tempValue: map.keySet()){
         if(map.get(tempValue) == max_value)
             temp.add(tempValue);
     }
     int[] res = new int[temp.size()];
     for (int i = 0;i<res.length ; i++) {
         res[i] = temp.get(i);
     }
     return res;

 }
 public void helper(TreeNode root, Map map){
     if (root == null) {
         return;
     }
     Integer temp = (Integer)map.getOrDefault(root.val, 0);
     map.put(root.val, temp+1);
     helper(root.right, map);
     helper(root.left, map);
 }



// 根据题干对BST的定义，重复的元素只会出现在左子节点上，所以针对每个节点，计算它左子树上值相等点的个数，然后递归找到最大值。
