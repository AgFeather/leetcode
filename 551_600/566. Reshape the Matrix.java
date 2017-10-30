//In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.

//You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.

//The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

//If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
public int[][] matrixReshape(int[][] nums,int r,int c){
		if (r*c!=nums.length*nums[0].length) {
			return nums;
		}
		int[][] res = new int[r][c];
		int a =0,b=0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (b>=c) {
					a++;
					b = 0;
				}
				res[a][b] = nums[i][j];
				b++;
			}
		}
		return res;
    }
