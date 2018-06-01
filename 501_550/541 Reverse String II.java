/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
 */

/*
总体上是一个循环，当index i为偶数时，对子串进行翻转加入结果中，i为奇数时直接将子串加入res
需要注意的是，
1：对于s.length()<k的情况，仍然需要翻转，这点题干没有写明
2：原题干写的是对于最后不够k个字符直接进行保留，但test case中，仍然需要判断是直接加入还是翻转后加入结果
所以说这里使用一个int flag用来标记是否需要翻转
 */
public String reverseStr(String s, int k) {
    if (s.length()<k) {
		return new StringBuffer(s).reverse().toString();
	}
    String res = "";
    int flag = 0;
	for (int i = 0; i<s.length()/k; i++) {
		if (i%2 == 0) {
			res += new StringBuffer(s.substring(i*k, (i+1)*k)).reverse().toString();
			flag = 0;
		}else{
			res += s.substring(i*k, (i+1)*k);
			flag = 1;
		}
	}
	if (s.length()%k !=  0 && flag == 0) {
		res += s.substring((s.length()/k)*k, s.length());
	}
	if (s.length()%k != 0 && flag == 1) {
		res += new StringBuffer(s.substring((s.length()/k)*k, s.length())).reverse().toString();
	}
	return res;
}
