/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */


/*
需要复习！！！
 */


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


/*解法2：
借用快排思想，复杂度为NlogK
*/
public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    ArrayList<Integer> array = new ArrayList<>();
    if (k > input.length) return array;
    quickSort(input, 0, input.length-1, k, array);
    return array;
}

public void quickSort(int[] nums, int start, int end, int k, ArrayList<Integer> res){
    if ( start> end || k<=0) {//注意这里是start>end，如果包括start==end的话会出现nums首尾元素被忽视的情况
        return;
    }
    int center = nums[start];
    int left = start, right = end;
    while(left < right){//不包括等于，等于时需要跳出
        while(nums[right] >= center && right>left) {right--;}
        nums[left] = nums[right];//注意这里的交换规则
        while(nums[left] <= center && right>left) {left++;}
        nums[right] = nums[left];
    }
    nums[left] = center;
    if ((left - start + 1) > k) {quickSort(nums, start, left-1, k, res);}//说明center的位置在k的左侧，需要递归数组的左半边
    else {//说明center的位置在k的右侧，首先需要将数组的右侧都加入结果集中，然后根据情况考虑
        for (int i = start; i<=left;i++ ) {
            res.add(nums[i]);
        }
        if ((left-start+1) == k) return; //说明正好完成
        else{ quickSort(nums, left+1, end, k-(left-start+1), res);}//任务还未完成，递归数组右半边，注意k值得变化
    }
}


// 解法3： 用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。



import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
public class Solution {
   public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       int length = input.length;
       if(k > length || k == 0){
           return result;
       }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
 
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
