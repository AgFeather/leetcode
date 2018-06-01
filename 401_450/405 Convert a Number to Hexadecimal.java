/*
Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
Example 1:

Input:
26

Output:
"1a"
Example 2:

Input:
-1

Output:
"ffffffff"

 */
/*
核心思想还是考察位运算，如果从位运算的角度来看，不需要区分输入的num
是否为负数。
 */
public String toHex(int num){
    char [] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    if (num == 0) return "0";
    String res = "";
    while(num != 0){
        res = map[(num&15)] + res;
        num = (num>>>4);
    }
    return res;
}
