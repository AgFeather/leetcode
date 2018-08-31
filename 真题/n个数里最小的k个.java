/*
题目描述
找出n个数里最小的k个
输入描述:
每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
不超过100。
输出描述:
输出n个整数里最小的k个数。升序输出
示例1
输入
复制
3 9 6 8 -10 7 -11 19 30 12 23 5
输出
复制
-11 -10 3 6 7
 */

/*
两种解法，一个是改进的冒泡排序，时间复杂度为：O(n*k)，一个是改进的快排
 */

import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        while(in.hasNext()){
            nums.add(in.nextInt());
        }
        int k = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        int len = nums.size()-2;
        for (int i = len; i>len-k; i--) {
            for (int j = i; j>0; j--) {
                if (nums.get(j) < nums.get(j-1)) {
                    int temp = nums.get(j);
                    nums.set(j, nums.get(j-1));
                    nums.set(j-1, temp);
                }
            }
        }
        for (int i = 0; i<k; i++) {
            System.out.print(nums.get(i));
            if (i != k-1) {
                System.out.print(" ");
            }
        }
    }
}




import java.util.*;
public class Main{
    public static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        while(in.hasNext()){
            nums.add(in.nextInt());
        }
        int k = nums.get(nums.size()-1);
        nums.remove(nums.size()-1);
        qSort(nums, 0, nums.size()-1, k);
        Collections.sort(res);
        for (int i = 0; i<k; i++) {
            System.out.print(res.get(i));
            if (i != k-1) {
                System.out.print(" ");
            }
        }
    }
    public static void qSort(ArrayList<Integer> nums, int begin, int end, int k){
        if (begin > end) {
            return;
        }
        int value = nums.get(begin);
        int l = begin;
        int r = end;
        while(l < r){
            while(nums.get(r)>value && l < r){r--;}
            nums.set(l, nums.get(r));
            while(nums.get(l)<value && l < r){l++;}
            nums.set(r, nums.get(l));
        }
        nums.set(l, value);
        if (l-begin+1 > k) {
            qSort(nums, begin, l-1, k);
        }else  {
            for (int i = begin; i<=l; i++) {
                res.add(nums.get(i));
            }
            if (l-begin+1 == k) return;
            else{
                qSort(nums, l+1, end, k-l+begin-1);
            }
        }
    }
}
