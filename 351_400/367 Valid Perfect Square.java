/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */


//一个平方数可以分解为：1+3+5+7+...
public boolean isPerfectSquare(int num){
    int i = 1;
    while(num > 0){
        num -= i;
        i += 2;
    }
    return num == 0;
}


//二分查找
public boolean isPerfectSquare(int num){
    if(num == 1)
       return true;

    long low = 1, high = num / 2, mid = 0;
    long nums = (long)num;

    while(low <= high){
       mid = low + (high - low) / 2;
       if((mid * mid) == nums)
           return true;
       else if( (mid * mid) < nums)
           low = mid + 1;
       else
           high = mid - 1;
    }
    return false;
}
