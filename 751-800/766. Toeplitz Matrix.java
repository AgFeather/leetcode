/*
A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
Now given an M x N matrix, return True if and only if the matrix is Toeplitz.

Example 1:
Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: True
Explanation:
1234
5123
9512

In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the answer is True.
Example 2:
Input: matrix = [[1,2],[2,2]]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
*/

//相当于对于任意给定矩阵，要求该矩阵每条斜线上的元素都相同
//解题思路：对每条斜线遍历即可，注意索引的计算
public boolean isToeplitzMatrix(int [][] matrix){
		int minLength = Math.min(matrix.length, matrix[0].length);
		for (int i = 0; i<matrix.length-1;i++ ) {
			int temp = matrix[i][0];
			for (int j = 0;j<matrix[0].length&&j+i<matrix.length ;j++ ) {
				if (temp!=matrix[j+i][j]) {
					return false;
				}
			}
		}
		for (int i = 0; i<matrix[0].length-1; i++) {
			int temp = matrix[0][i];
			for (int j = 0; j<matrix.length&&j+i<matrix[0].length; j++) {
				if (temp!=matrix[j][j+i]) {
					return false;
				}
			}
		}
		return true;
	}
  
  //一个更聪明的解决方法：只需要比较每一个元素i，j和元素i+1,j+1是否相等即可。
  //我原来的
      public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) return false;
            }
        }
        return true;
    }
