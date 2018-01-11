/*
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
*/

//解题思路非常清晰的一道题，只需要对每个点计算floor值即可，注意边界检查
//第一次失败：边界检查时忘记了四个角的值，这个需要双层判断边界
//第二次失败：在每次循环中，直接对传入的数组M做修改，导致数字后面元素的计算是依赖于已经更改的值。需要新建一个数组来保存result值
//教训：对于需要依赖之前值的计算，应该对之前的值进行保存而不是直接覆盖更改。
class Solution {
    public int[][] imageSmoother(int[][] M){
		int[][] res = new int[M.length][M[0].length];
		for (int i = 0; i<M.length; i++) {
			for (int j = 0; j<M[0].length; j++) {
				res[i][j] = floor(M,i,j);
			}
		}
		return res;
	}
	public int floor(int[][] m,int i,int j){
		int sum = m[i][j];
		int count = 1;
		if (i-1>=0) {
			sum+=m[i-1][j];
			count++;
			if (j-1>=0) {
				sum+=m[i-1][j-1];
				count++;
			}
			if (j+1<m[0].length) {
				sum+=m[i-1][j+1];
				count++;
			}
		}
		if (i+1<m.length) {
			sum+=m[i+1][j];
			count++;
			if (j-1>=0) {
				sum+=m[i+1][j-1];
				count++;
			}
			if (j+1<m[0].length) {
				sum+=m[i+1][j+1];
				count++;
			}
		}
		if (j-1>=0) {
			sum+=m[i][j-1];
			count++;
		}
		if (j+1<m[0].length) {
			sum+=m[i][j+1];
			count++;
		}
		return sum/count;
	}
}
