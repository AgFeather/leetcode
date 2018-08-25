/*
题目描述
设有n个正整数，将他们连接成一排，组成一个最大的多位整数。
如:n=3时，3个整数13,312,343,连成的最大整数为34331213。
如:n=4时,4个整数7,13,4,246连接成的最大整数为7424613。
输入描述:
有多组测试样例，每组测试样例包含两行，第一行为一个整数N（N<=100），第二行包含N个数(每个数不超过1000，空格分开)。
输出描述:
每组数据输出一个表示最大的整数。
示例1
输入
2
12 123
4
7 13 4 246
输出
12312
7424613
 */

// 解题思路很直接，剑指offer的原题；注意Comparator的运用
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i=0;i<n; i++) {
                nums.add(in.nextInt());
            }
            Collections.sort(nums, new Comparator<Integer>(){
                public int compare(Integer i1, Integer i2){
                String s1 = i1 + "" + i2;
                String s2 = i2 + "" + i1;
                return s2.compareTo(s1);
                };
            });
            StringBuffer  sb = new StringBuffer();
            for(int i:nums){
                sb.append(i+"");
            }
            System.out.println(sb.toString());
        }
    }
}
