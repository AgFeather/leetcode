/*
题目描述
将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
输入描述:
输入一个字符串,包括数字字母符号,可以为空
输出描述:
如果是合法的数值表达则返回该数字，否则返回0

示例
输入
+2147483647
    1a33
输出
2147483647
    0
 */


public int StrToInt(String str) {
    if (str == null || str.()) == 0) return 0;
    char[] cs = str.toCharArray();
    int symbol = 1;
    int start = 0;
    int res = 0;
    if (cs[0] == '+'){
        start = 1;
    }else if (cs[0] == '-'){
        symbol = -1;
        start = 1;
    }
    for (int i = start; i<cs.length; i++) {
        if (cs[i] < '0' || cs[i] > '9'){return 0;}
        res = res * 10 + (int)(cs[i]-'0');
    }
    return symbol * res;
}
