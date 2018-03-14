/*
We are given two strings, A and B.
A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

Example 1:
Input: A = 'abcde', B = 'cdeab'
Output: true

Example 2:
Input: A = 'abcde', B = 'abced'
Output: false
*/


//解题思路：刚刚读题时，想法较为简单，将a字符串的第一位在b字符串的index找出，然后用取模的方式遍历两个字符串对比每一位的字符。
//但这个解法有个漏洞就是如果存在字符多次重复的时候，第一步返回的index仅仅是该字符在b字符串出现的第一个位置，无法找到正确位置。

//后来通过题干的提醒（swift操作），对字符重复进行swift操作，并将每次的结果和b字符串对比。
//注意swift方法的实现以及string自带方法substring的第二个参数并不被包含在截取的substring中。


class Solution {
		public boolean rotateString(String A, String B){
		if (A.length() != B.length()) {
			return false;
		}
		for (int i = 0; i < A.length()+1; i++) {
			A = shift(A);

			if (B.equals(A)) {
				return true;
			}
		}
		return false;
	}
	public String shift(String s) {
		String sub = s.substring(1, s.length());
		sub = sub + s.charAt(0);
		return sub;
	}
  
}


//最完美的解法
//we can easily see whether it is rotated if B can be found in (A + A)
return A.length() == B.length && (A + A).contains(B);
