/*
Given an integer, write a function to determine if it is a power of two.
判断一个数是否是2的倍数
 */


//不断除2，指导无法整除为止，如果结果是1，返回true，否则返回false
 public boolean isPowerOfTwo(int n) {
     if(n == 0)
         return false;
     while(n%2 == 0)
         n/=2;
     return n == 1;
 }



 //一个更好的解法，看二进制中1的个数是否为1
 public boolean isPowerOfTwo(int n){
    return n>0 && Integer.bitCount(n) == 1;
 }
