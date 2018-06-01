/*
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011

 */

/*
也是思路狠清晰的一道题，通过位运算进行计数，注意可以通过（n&1)的方法取到最右位的值
同时test case里面有一个坑，就是2147483648（100000..00），因为正常计算机中，最高位为1
表示负数，所以导致了这个问题。也因此没办法用最直接的循环方法进行计数
 */
public int hammingWeight(int n){
    int res = 0;
    while(n != 0){
        res += (n & 1);
        n >>>= 1;
    }
    return res;
}
