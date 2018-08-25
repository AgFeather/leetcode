/*
题目描述
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
 */

/*
可以使用来类的成员变量，会简化递归过程
 */
public ArrayList<ArrayList<Integer>> allList = new ArrayList<>();
public ArrayList<Integer> tempList = new ArrayList<>();
public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    if (root == null) {
        return allList;
    }
    tempList.add(root.val);
    target -= root.val;
    if (target == 0 && root.left == null && root.right == null) {
        allList.add(new ArrayList<Integer>(tempList));
    }
    FindPath(root.left, target);
    FindPath(root.right, target);
    tempList.remove(tempList.size()-1); // !注意每次删除上一次遍历加入到list中的叶子节点
    return allList;
}
