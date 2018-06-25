/*
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */

/*
思路非常清晰的一道题，相当于对用数组表示的正整数+1，注意进位和都为9的情况
 */
public int[] plusOne(int[] digits){
    for (int i = digits.length-1 ; i>=0; i--) {
        if (digits[i]+1 > 9) {
            digits[i] = 0;
        }else{
            digits[i] += 1;
            break;
        }
    }
    if (digits[0] == 0) {
        int [] res = new int[digits.length+1];
        res[0] = 1;
        // for (int i=1; i<res.length;i++ ) {
        //     res[i] = digits[i-1];
        // }
        // //注意，并不需要赋值，因为产生最高位进位只有一种情况就是剩余所有元素都是0
        return res;
    }
    return digits;
}

//非递归方法
public int[] plusOne(int[] digits){
    plus(digits, digits.length-1);
    if (digits[0] == 0) {
        int [] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
    return digits;
}

//递归方法
void plus(int[] digits, int index){
    if (index < 0) {
        return;
    }
    if (digits[index]+1 > 9) {
        digits[index] = 0;
        plus(int[] digits, index-1);
    }else{
        digits[index] += 1;
    }
}
