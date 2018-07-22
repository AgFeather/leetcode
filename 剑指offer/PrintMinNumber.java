/*
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */


/*
需要复习！！！



* 解题思路：
 * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
 * 排序规则如下：
 * 若ab > ba 则 a > b，
 * 若ab < ba 则 a < b，
 * 若ab = ba 则 a = b；
 * 解释说明：
 * 比如 "3" < "31"但是 "331" > "313"，所以要将二者拼接起来进行比较

 */

import java.util.*;
public String PrintMinNumber(int [] numbers) {
    int n;
    String s = "";
    ArrayList<Integer> list = new ArrayList<>();
    n = numbers.length;
    for (int i=0; i<n; i++) {
        list.add(numbers[i]);
    }
    Collections.sort(list, new Comparator<Integer>(){
        public int compare(Integer str1, Integer str2){
            String s1 = str1 + "" + str2;
            String s2 = str2 + "" + str1;
            return s1.compareTo(s2);
        }
    });
    for (int j : list) {
        s += j;
    }
    return s;
}
