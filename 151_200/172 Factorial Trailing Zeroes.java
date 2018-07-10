/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Note: Your solution should be in logarithmic time complexity.
 */


/*
This question is pretty straightforward.

Because all trailing 0 is from factors 5 * 2.

But sometimes one number may have several 5 factors, for example,
25 have two 5 factors, 125 have three 5 factors. In the n! operation,
factors 2 is always ample. So we just count how many 5 factors in all number
from 1 to n.
 */
 public int trailingZeroes(int n) {
     return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
 }


/*
使用二分法不断分割整个连乘过程，知道分割到相邻的两个数相乘，如果相乘结果可以被10整除，
则res++，并返回相乘结果除10.
 */
 private int res = 0;
 public int trailingZeroes(int n){
     if (n == 0)
         return 0;
     helper(1, n);
     return res;
 }

 public long helper(int l, int r){
     long temp = 0;
     if (r == l){
         return r;
     }
     if (r - l == 1) {
         temp = l * r;
         if(temp%10 == 0){
             res++;
             System.out.println(r + " " + l);
             return temp/10;
         }
         return temp;
     }
     int mid = (r+l)/2;
     long lValue = helper(l, mid);
     long rValue = helper(mid+1, r);
     if (lValue / 10000 != 0)
         lValue %= 10000;
     if (rValue / 10000 != 0)
         rValue %= 10000;
     temp = lValue * rValue;
     if (temp%10 == 0) {
         res++;
         System.out.println(lValue + " " + rValue);
         return temp/10;
     }
     return temp;
 }
