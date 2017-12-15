/*
Given an m * n matrix M initialized with all 0's and several update operations.

Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

You need to count and return the number of maximum integers in the matrix after performing all the operations.

Example 1:
Input: 
m = 3, n = 3
operations = [[2,2],[3,3]]
Output: 4
Explanation: 
Initially, M = 
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

After performing [2,2], M = 
[[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

After performing [3,3], M = 
[[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

So the maximum integer in M is 2, and there are four of it in M. So return 4.


*/

//最开始的想法是构建一个m×n的矩阵，然后根据更新规则不断更新，同时记录每次更新的最大值以及count。
//后来想到，array[0][0]每次一定会被更新，所以它就是最大值，只需要计算矩阵中和它值相等的点
//后来又想到，因为每次更新都是+1，所以只需要知道被更新次数最多的点的个数就可以
//不难发现，被更新次数最多的点的个数 = minX×minY即ops矩阵每一行的最小值相乘
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) {
			return m*n;
		}
        int count = 0;
		int minX = ops[0][0];
		int minY = ops[0][1];
		for (int i = 0; i<ops.length; i++) {
			if (ops[i][0]<minX) {
				minX = ops[i][0];
			}
			if (ops[i][1]<minY) {
				minY = ops[i][1];
			}
		}
		return minX*minY;
    }
}
