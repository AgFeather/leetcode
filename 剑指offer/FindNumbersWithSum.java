/*

和为S的两个数字

题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */


public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    int left = 0, right = array.length-1;
    ArrayList<Integer> res = new ArrayList<>();
    while(left < right){
        int temp = array[left] + array[right];
        if ( temp == sum) {
            res.add(array[left]);
            res.add(array[right]);
            break;
        }
        else if (temp < sum) {
            left++;
        }else{right--;}
    }
    return res;
}
