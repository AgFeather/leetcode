
class TreeNode{
    public int val;
    public TreeNode right;
    public TreeNode left;
    public TreeNode(int val){
        this.val = val;
        this.right = null;
        this.left = null;
    }
}

public class Tree{
    public static void main(String[] argv){
    	Tree tree = new Tree();
    	int[] array = {1,2,3,4,5,6,7,8,9};
    	TreeNode root = tree.arrayToBST(array);

    }

    //递归方法进行DFS， 其中先序遍历，中序遍历，后序遍历，只需要修改visit函数和递归的位置即可
    public void recersiveDFS(TreeNode root){
        if (root == null) {
            return;
        }
        visit(root);
        recersiveDFS(root.left);
        recersiveDFS(root.right);
    }
    //非递归方法进行DFS （先序遍历）
    public void loopDFS(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            visit(temp);
            if (temp.right != null)
                stack.push(temp.right);
            if (temp.left != null)
                stack.push(temp.left);
        }
    }
    //非递归进行BFS，主要思想就是使用队列，不断进行弹出和压入
    public void loopBFS(TreeNode root){
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            visit(temp);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }


    /*
    BST树操作，BST树为二叉搜索树，该树中没有重复的值，并且对于任意节点，该节点左子树
    的值要小于节点值，节点右子树的值要大于节点值。
    这里定义了BST的常见三种方法：从array中构建BST，BST添加节点，BST删除节点
     */
    //输入一个sorted array，返回以此构建的BST
    public TreeNode arrayToBST(int[] nums, int left, int right) {
    	if(left>right)
    		return null;
    	int center = (right-left)/2 + left;
    	TreeNode temp = new TreeNode(nums[center]);
    	temp.right = arrayToBST(nums, center+1, right);
    	temp.left = arrayToBST(nums, left, center-1);
    	return temp;
    }

    //向BST中加入一个节点
    public void addNodeBST(TreeNode root, int value){
        if (value < root.val && root.left == null)
            root.left = new TreeNode(value);
        if (value > root.val && root.right == null)
            root.right = new TreeNode(value);
        if (value < root.val)
            addNodeBST(root.left, value);
        if (value > root.val)
            addNodeBST(root.right, value);
    }

    //从一个BST中删除一个节点
    public void deleteNodeBST(TreeNode root, int value){
        /*
        BST删除比较复杂，共有四种情况需要考虑：
        1. 删除叶子节点
        2. 删除节点没有右子树
        3. 删除节点没有左子树
        4. 删除节点有左右子树
        其中，删除节点只有一个子树的情况下，有两个小情况需要考虑
        如果删除节点有两个子树，那么需要找到删除节点的替代节点，并不断调整删除节点父节点的指针，
        然后递归删除替代节点
         */
        TreeNode deleteNode = findNodeBST(root, value);

        //如果删除的节点是叶子节点
        if (deleteNode.left == null && deleteNode.right == null){
            TreeNode fatherNode = findFatherNodeBST(root, value);
            if (fatherNode == null)//说明该节点没有父节点（根节点）
                root == null;
            else if (fatherNode.right.val == deleteNode.val)
                fatherNode.right = null;
            else
                fatherNode.left = null;
        }

        //如果删除的节点没有右子树
        if (deleteNode.right == null) {
            //如果删除节点是根节点
            if (root.val == deleteNode.val)
                root = root.left;
            //如果删除的节点是中间节点，找到删除节点的父节点，然后调整指针
            else{
                TreeNode fatherNode = findFatherNodeBST(root, value);
                if (fatherNode.right.val == deleteNode.val)
                    fatherNode.right = deleteNode.left;
                else
                    fatherNode.left = deleteNode.left;
            }
        }

        //如果删除节点没有左子树
        if (deleteNode.left == null) {
            //如果删除节点是根节点
            if (root.val == deleteNode.val)
                root = root.right;
            //如果删除节点是中间节点，找到删除节点的父节点，然后调整指针
            else {
                TreeNode fatherNode = findFatherNodeBST(root, value);
                if (fatherNode.right.val == deleteNode.val)
                    fatherNode.right = deleteNode.right;
                else
                    fatherNode.left = deleteNode.right;
            }
        }

        //如果删除的节点左右子树都具备
        else{
            //首先找到删除节点的替代节点，这里我们用的是左子树的最大值节点
            TreeNode nextNode = findNextNodeBST(root.left);
            //如果删除的节点是根节点，我们直接修改根节点的值，并且递归删除替代节点
            if (root.val == deleteNode.val) {
                root.val = nextNode.val;
                deleteNodeBST(root, nextNode);
            }
            //如果删除的节点是中间节点
            else{
                //首先找到删除节点的父节点，然后使用替代节点的值新建节点
                //并调整父节点的指针，新建节点继承删除节点的左右子树，
                //然后递归删除替代节点
                TreeNode fatherNode = findFatherNodeBST(root);
                if (fatherNode.right.val == deleteNode.val){
                    TreeNode newNode = new TreeNode(nextNode.val);
                    fatherNode.right = newNode;
                    newNode.right = deleteNode.right;
                    newNode.left = deleteNode.left;
                    deleteNodeBST(root, nextNode);
                }
                else{
                    TreeNode newNode = new TreeNode(nextNode.val);
                    fatherNode.left = newNode;
                    newNode.right = deleteNode.right;
                    newNode.left = deleteNode.left;
                    deleteNodeBST(root, nextNode);
                }
            }
        }
    }
    //删除辅助函数： 传入一个节点的左子树，返回该子树中最大值的节点
    public TreeNode findNextNodeBST(TreeNode root){
        if (root.right == null && root.left == null)
            return root;
        if (root.right != null)
            return findNextNodeBST(root.right);
        else
            return findNextNodeBST(root.left);
    }
    //删除辅助函数： 给定一个节点的值，查找该节点的父节点
    public TreeNode findFatherNodeBST(TreeNode root, int value){
        if (root == null)
            return;
        if (root.right.val == value || root.left.val == value)
            return root;
        if (value > root.val)
            findFatherNodeBST(root.right, value);
        if (value < root.val)
            findFatherNodeBST(root.left, value);
        return null;
    }
    //删除辅助函数： 给定一个值，返回BST中对应的节点
    public TreeNode findNodeBST(TreeNode root, int value){
        if (root == null)
            return null;
        if (root.val == value)
            return root;
        if (value > root.val)
            findNodeBST(root.right, value);
        else
            findNodeBST(root.left, value);
    }


    public void visit(TreeNode node){
        System.out.println(node.val);
    }
}
