/*

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */

/*
从后向前对字符串每一位进行相加，注意进位。
如果两个字符串不等长，记得将较长的字符串加入result
注意返回时仍然需要对当前进位的值进行判断
 */
public String addBinary(String a, String b){
    int flag = 0;
    int indexA = a.length()-1;
    int indexB = b.length()-1;
    StringBuffer res = new StringBuffer();
    while(indexA>=0 || indexB>=0){
        int temp = flag;
        if(indexA >= 0) temp += a.charAt(indexA--)-'0';
        if(indexB >= 0) temp += b.charAt(indexB--)-'0';
        flag = temp/2;
        res.append(temp%2);
    }
    if (flag != 0) res.append(flag);
    return res.reverse().toString();
}
