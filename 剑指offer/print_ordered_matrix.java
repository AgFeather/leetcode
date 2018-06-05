/*
顺时针打印矩阵

题目描述
输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.

 */

//分别记录矩阵的上下左右四条边的位置，每次向array添加一条边后该边位置向矩阵内部移动
public ArrayList<Integer> printMatrix(int[][] matrix){
    ArrayList<Integer> array = new ArrayList<>();
    int i = 0; int j = 0;
    int up = 0; int down = matrix.length-1;
    int left = 0; int right = matrix[0].length-1;
    int size = matrix.length * matrix[0].length;
    while(array.size() < size){
        for (j = left;j<=right&&array.size() < size ;j++ ) {
            array.add(matrix[up][j]);
        }
        up++;
        for (i=up; i<=down&&array.size() < size; i++) {
            array.add(matrix[i][right]);
        }
        right--;
        for (j=right; j>=left&&array.size() < size; j--) {
            array.add(matrix[down][j]);
        }
        down--;
        for (i=down; i>=up&&array.size() < size; i--) {
            array.add(matrix[i][left]);
        }
        left++;
    }
    return array;
}
