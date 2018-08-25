/*
二维数组查找：

题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */


/*
解题思路：先沿着一条边找到array[i][0]>target的index，然后沿着这个index向矩阵内部遍历。
array[i][j] > target则i--， array[i][j]<target 则j++
 */
 public boolean Find(int target, int [][] array) {
     if (array == null || array.length == 0||array[0].length == 0)
         return false;
     int i = 0;
     for (; i<array.length; i++) {
         if (array[i][0] == target)
             return true;
         if (array[i][0] > target)
             break;
     }
     i = Math.min(i, array.length-1);
     for (int j = 0;j<array[0].length && i>=0;) {
         if (array[i][j] == target)
             return true;
         if (array[i][j] > target)
             i--;
         else
             j++;
     }
     return false;
 }
