//Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

//Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)


//对grid每个节点进行遍历，发现val为1时，就将该节点的val置为0（为防止多次遍历），并将坐标放入queue中，并对queue进行遍历，
//每从queue中取出一个点后，分别访问这个点的上下左右，遇到val为1的地方仍讲val置为0，讲坐标压入queue中

public int getSubIsland(int[][] grid,Queue<Integer[]> queue) {
		int tempMax = 1;
		while(!queue.isEmpty()){
			Integer[] temparray = queue.poll();//从queue中取出一个点，并对这个点的上下左右进行访问
			int tempi = temparray[0];          //如果访问到的点为1，则置0，并将这个点的坐标放入queue中。
			int tempj = temparray[1];
			if (tempi!=grid.length-1&&grid[tempi+1][tempj] == 1) {//注意检查坐标越界问题
				grid[tempi+1][tempj] = 0;
				tempMax++;
				Integer[] tempElementArray2 = {tempi+1,tempj};
				queue.offer(tempElementArray2);
			}
			if (tempj!=grid[0].length-1&&grid[tempi][tempj+1] == 1) {
				grid[tempi][tempj+1] = 0;
				tempMax++;
				Integer[] tempElementArray3 = {tempi,tempj+1};
				queue.offer(tempElementArray3);
			}
			if (tempi-1>=0&&grid[tempi-1][tempj] == 1) {
				grid[tempi-1][tempj] = 0;
				tempMax++;
				Integer[] tempElementArray4 = {tempi-1,tempj};
				queue.offer(tempElementArray4);
			}
			if (tempj-1>=0&&grid[tempi][tempj-1] == 1) {
				grid[tempi][tempj-1] = 0;
				tempMax++;
				Integer[] tempElementArray5 = {tempi,tempj-1};
				queue.offer(tempElementArray5);
			}
		}
		return tempMax;
	}
	
	
	public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
		for (int i = 0; i<grid.length; i++) {
			for (int j = 0;j<grid[0].length ;j++ ) {
				if (grid[i][j] == 1) {//当值为1时，将坐标压入queue
					grid[i][j] = 0;//讲值置为0，防止在queue中重复计算
					Queue<Integer[]> queue = new LinkedList<>();
					Integer[] temparray = {i,j};
					queue.offer(temparray);
					int tempMax = getSubIsland(grid, queue);//对queue进行遍历，返回局部最大值，与max比较
					max = max>tempMax?max:tempMax;
				}
			}
		}
		System.out.println(max);
		return max;
	}
