/*
调整数组顺序使奇数位于偶数前面

题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
*/

public void reOrderArray(int [] array) {
    int oddIndex = 0;
    int evenIndex = 0;
    int[] odd = new int[array.length];
    int[] even = new int[array.length];
    for (int i = 0; i<array.length; i++) {
        if(array[i]%2 == 0)
            even[evenIndex++] = array[i];
        else
            odd[oddIndex++] = array[i];
    }
    for (int i = 0; i<oddIndex; i++) {
        array[i] = odd[i];
    }
    for (int i = 0; i<evenIndex; i++) {
        array[array.length-i-1] = even[evenIndex-i-1];
    }
}


//根据冒泡排序思想不断进行比较，不用额外空间，但是时间复杂度O(n2)
public void reOrderArray(int[] array){
    for (int i = 0 ; i<array.length; i++) {
        for (int j = 0; j<array.length-i-1;j++) {
            if (array[j]%2 == 0 && array[j+1]%2==1) {
                int temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
}
