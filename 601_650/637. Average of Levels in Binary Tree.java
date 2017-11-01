//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

//使用dummy node 节点，即讲根节点放入队列之后，压入一个标记节点，每次从队列取到标记节点的时候，表示这层结束，计算平均值。然后再将标记节点压入队列中
//在这个题中，因为无法改变treenode类，也无法讲var设置成一个永远无法达到的值，所以可以让标记节点的子节点指向节点自身表示dummy node
//这个方法的好处是，即使输入二叉树不是完全二叉树，存在缺失节点也可以完成记录。


public List<Double> averageOfLevels(TreeNode root){		
		Queue<TreeNode> queue = new LinkedList<>();
		List<Double> res = new ArrayList<>();
		if (root == null) {
			return null;
		}
		queue.offer(root);
		TreeNode dummyNode = new TreeNode();
		dummyNode.left = null;
		dummyNode.right = dummyNode;
		queue.offer(dummyNode);
		long tempSum = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp.left!=null) {
				queue.offer(temp.left);
			}
			if (temp.right!=null&&temp.right!=temp) {
				queue.offer(temp.right);
			}
			if (temp.right == temp) {//表示这个节点为dummy node
				res.add((double)tempSum/count);
				if (queue.isEmpty()) {//因为dummy node 会无限offer入队列中，所以当取出的最后一个节点为dummy node时，break；
					break;
				}
				count = 0;
				queue.offer(temp);
				tempSum = 0;
			}
			else {
				tempSum+=temp.val;
				count++;
			}
		}
		return res;
}




//参考到一个答案，即每次取queue的size，就代表这个层有多少的节点，然后再建一个循环，计算这一层的sum
public ArrayList<Double> averageOfLevels(TreeNode root) {
		ArrayList<Double> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null) {
			return null;
		}
		while(!queue.isEmpty()) {
			int level = queue.size();
			double tempSum = 0;
			for (int i = 0; i < level; i++) {
				TreeNode temp = queue.poll();
				if (temp.right!=null) {
					queue.offer(temp.right);
				}
				if (temp.left!=null) {
					queue.offer(temp.left);
				}
				tempSum+=temp.val;
			}
			res.add((double)tempSum/level);
		}
		return res;
	}
