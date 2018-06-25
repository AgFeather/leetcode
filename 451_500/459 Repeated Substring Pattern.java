/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 */


/*
思路：
首先如果为true，那么子串一定是从s[0]开始，所以不需要遍历每一位char判断是否为子串的起点。
遍历子串长度从1~s.length/2，也是判断子串s[0:i]是否可以构成该string

check函数中，首先判断string长度是否可以被substring长度整除，
如果可以则判断每一位是否和子串对应位置的char相同

反思：最开始没有想到子串一定是以s[0]为开头，所多了一层循环，然后没有进行字符串和子串长度整除检查
*/
public boolean repeatedSubstringPattern(String s){
    for (int j = 1; j<=s.length()/2; j++) {
        if(s.length()%j==0 && checkRepeated(s, j))
            return true;
    }
    return false;
}

public boolean checkRepeated(String s, int length){
    for (int k = 0;k<s.length() ;k++ ) {
        if (s.charAt(k) != s.charAt(k%(length)))
            return false;
    }
    return true;
}
