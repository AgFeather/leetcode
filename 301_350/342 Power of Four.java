/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example:
Given num = 16, return true. Given num = 5, return false.

Follow up: Could you solve it without loops/recursion?


 */

//如果一个数是2的N次方，那么有：num&(num-1) = 0
//再将从中剔除掉不是4的n次方的数。
//0x55555555 is a hexametrical number，
//it is 1010101010101010101010101010101 in binary with a length of 32. 
//To make sure the 1 locates in the odd location.
public boolean isPowerOfFour(int num){
    if(num<=0) return false;
    if(num & (num-1)) return false;
    if(num & 0x55555555) return true;
    return false;
}


public boolean isPowerOfFour(int num){
    if (num == 1) return true;
    if (num%4!=0) return false;
    if (num <= 0) return false;
    return isPowerOfFour(num / 4);
}
