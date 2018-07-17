/*
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

//用一个map记录每个数的出现次数即可
import java.util.*;
public int MoreThanHalfNum_Solution(int[] array){
    Map<Integer,Integer> map = new HashMap<>();
    int target = array.length/2;
    for (int i = 0; i<array.length; i++) {
        map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        if (map.get(array[i] >= target)) {
            return array[i];
        }
    }
    return 0;
}

/*
链接：https://www.nowcoder.com/questionTerminal/e8a1b01a2df14cb2b228b30ee6a92163
来源：牛客网

思路二：如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，
若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。
遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
 */


public int MoreThanHalfNum_Solution(int[] array){
    if (array<=0) {
        return 0;
    }
    int result = array[0];
    int count = 1;
    for (int i=1; i<array.length; i++) {
        if (array[i] == result) {
            count++;
        }else{
            if (count == 0){
                result = array[i];
                count = 1;
            }else{count--;}
        }
    }
    count = 0;
    for (int i = 0; i<array.length; i++) {
        if (array[i] == result) {
            count++;
        }
    }
    return count>array.length/2 ? result:0;
}
