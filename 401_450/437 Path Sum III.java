/*
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
 */

/*
解题的核心思想还是树的遍历，可以用DFS和BFS。
由于之前做过输出树从根出发所有路径的题，惯性思维想记录所有的路径到一个list中，
然后循环判断整个list中的所有路径和是否等于sum，后来发现根本没有必要记录所有路径，
只需要记录遍历到当前节点时经过路径的和就可以

最开始因为审题不细致，没有发现是树中的任意路径，不是必须从根出发，在原基础上增加一个
遍历所有树节点的递归即可
 */

 public int pathSum(TreeNode root, int sum){
	if (root == null)
		return 0;
    return help(root, sum) + pathSum(root.right, sum) + pathSum(root.left, sum);

}
public int help(TreeNode root, int sum){
	int res = 0;
	Queue<TreeNode> treeQueue = new LinkedList<>();
	Queue<Integer> valueQueue = new LinkedList<>();
	treeQueue.offer(root);
	valueQueue.offer(root.val);
	while(!treeQueue.isEmpty()){
		TreeNode treeTemp = treeQueue.poll();
		int tempValue = valueQueue.poll();
		if (tempValue == sum) {
			res++;
		}
		if (treeTemp.right != null) {
			treeQueue.offer(treeTemp.right);
			valueQueue.offer(tempValue + treeTemp.right.val);
		}if (treeTemp.left != null) {
			treeQueue.offer(treeTemp.left);
			valueQueue.offer(tempValue + treeTemp.left.val);
		}
	}
	return res;
}



/*
一个时间复杂度仅为O(n)的解法，只需要使用一个HashMap，记录树中各个路径的和。遍历每个点时，
只需要查找map中是否包含一个路径和value1，使得value1+currSum = sum。result+=map会返回
满足这个value1的路径个数。然后将currSum存入到HashMap中，继续递归子节点
注意，为了防止一个路径的值虽然为value1，但却并不和当前节点相连接，我们需要在函数最后对map中
currSum的个数-1.
 */
 public int pathSum(TreeNode root, int sum) {
     HashMap<Integer, Integer> preSum = new HashMap();
     preSum.put(0,1);
     return helper(root, 0, sum, preSum);
 }

 public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
     if (root == null)
         return 0;
     currSum += root.val;
     int res = preSum.getOrDefault(currSum - target, 0);
     preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

     res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
     preSum.put(currSum, preSum.get(currSum) - 1);//对currSum-1，为了防止出现两个路径不相连但路径值得和加起来等于sum的情况
     return res;
 }
