/*
We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */

/*
最直接的方法就是遍历 1~num-1，如果整除就加入sum最后比较是否相等
因为循环最多进行到Math.sqrt(num)，所以并不需要遍历 1~num-1，减小时间复杂度
 */
public boolean checkPerfectNumber(int num){
    if (num<=1) return false;
    int sum = 1;
    for (int i = 2; i<Math.sqrt(num); i++) {
        if (num%i == 0) {

            sum += i;
            System.out.println(sum+"++++");
            sum += num/i;
            System.out.println(sum);
        }
    }
    if(sum == num) return true;
    return false;
}
