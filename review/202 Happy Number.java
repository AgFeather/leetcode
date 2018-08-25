/*
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 02 = 1
 */



//最开始的想法是使用递归判断，后来发现无法找到递归出口，导致Stack Overflow。
//后来发现有些需要return false的数会无限循环，所以使用一个set记录所有中间的数，如果重复出现且不为1，说明false
public boolean isHappy(int n) {
    if (n < 1) {
        return false;
    }
    HashSet<Integer> set = new HashSet<>();
    while(set.add(n)) {
        int sum = 0;
        while(n != 0) {
            sum += (n%10) * (n%10);
            n /= 10;
        }
        n = sum;
    }
    return n == 1;
}
