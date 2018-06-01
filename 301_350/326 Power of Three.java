/*
Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 */

//思路和求2的倍数一样
 public boolean isPowerOfThree(int n) {
     if(n <= 0)
         return false;
     while(n%3 == 0)
         n /= 3;
     return n == 1;
 }


//不使用循环的答案。。。
public boolean isPowerOfThree(int n) {
// 1162261467 is 3^19,  3^20 is bigger than int
    return ( n>0 &&  1162261467%n==0);
}
