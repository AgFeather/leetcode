/*
题目描述
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */



/*
需要复习！！！

解题思路：
因为不允许用if，所以需利用逻辑与的短路特性实现递归终止。
当n == 0时  (n>0) && ((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
 */
public int Sum_Solution(int n){
    int sum = n;
    boolean ans = (n>0) && ((sum += Sum_Solution(n-1)) < 0);//后面的>0判断其实没有意义，只是将表达式转为boolean而已，可以为任意布尔运算
    return sum;
}
