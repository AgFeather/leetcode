/*
Related to question Excel Sheet Column Title

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    BA -> 53

*/
//讲输入字符串想象为26进制的数字表示
//本题就转换为将26进制转换为10进制

class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i<s.length(); i++) {
          res+=Math.pow(26, i)*(array[s.length()-i-1]-64);
        } 
        return res;
    }
}
