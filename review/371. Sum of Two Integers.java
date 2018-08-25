//Calculate the sum of two integers a and b,
//but you are not allowed to use the operator + and -.

//Example:
//Given a = 1 and b = 2, return 3.





//本题的解题思路分为两步：1：对应位进行加法，2：计算进位，然后继续进行加法
public int getSum(int a int b){
    if(b == 0)
    return a;
    int sum,carry;
    sum = a^b;
    carry = (a&b)<<1;//&运算将所有产生进位的地方置1，
    //<<运算将进位左移，对应到需要加法的位置
    return getSum(sum,carry);//将现在的结果和进位递归相加
}
