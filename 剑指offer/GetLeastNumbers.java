/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
import java.util.*;
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> array = new ArrayList<>();
    int max = input[0];
    for (int i = 0; i<k; i++) {
        array.add(input[i]);
        max = Math.max(max, input[i]);
    }
    for (int i = k; i<input.length; i++) {
        if (input[i] < max) {
            array.remove(max);
            array.add(input[i]);
            max = Collections.max(array);
        }
    }
    return array;

}


//解法1：冒泡排序，最外层的循环次数为k，时间复杂度为：O(n*k)
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> array = new ArrayList<>();
    if (k > input.length) return array;
    for (int i = 0; i<k; i++) {
        for (int j = 0; j<input.length-i-1; j++) {
            if (input[j] < input[j+1]) {
                int temp = input[j];
                input[j] = input[j+1];
                input[j+1] = temp;
            }
        }
        array.add(input[input.length-i-1]);
    }
    return array;
}


//解法2：
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> array = new ArrayList<>();
    if (k > input.length) return array;
    quickSort(input, 0, input.length-1, k, array);
    return array;
}

public void quickSort(int[] arr, int start, int end, int k, ArrayList<Integer> res){
    if ( start>= end || k<=0) {
        return;
    }
    int index = start;
    int i = start, j = end+1;
    while(true){
        while(arr[index] > arr[i] && i != end){ i++; }
        while(arr[index] < arr[j] && j != start){ j--; }
        if (i >= j) break;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    int temp = arr[index];
    arr[index] = arr[j];
    arr[j] = temp;
    index = j;
    if (index - start + 1 > k) {quickSort(arr, start, index-1, k, res);}
    else{
        for (j = 0; j<index-start+1;j++ ) {
            res.add(arr[start + j]);
        }
        if (index - start + 1 == k) return;
        else {quickSort(arr, index+1, end, k-index+start-1, res);}
    }
}
