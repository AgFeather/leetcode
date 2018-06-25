/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

回文字符串
 */

public int countSubstrings(String s){
    boolean[][] table = new boolean[s.length()][s.length()];
    int count = s.length();
    for (int i = 0; i<s.length(); i++) {
        table[i][i] = true;
        if(i>0 && s.charAt(i) == s.charAt(i-1)){
            table[i-1][i] = true;
            count++;
        }

    }
    for (int i = 2; i<s.length(); i++) { //从长度为3开始遍历，知道长度为length
        for (int j = 0;j<s.length()-i;j++ ) {
            if (table[j+1][j+i-1] && s.charAt(j)==s.charAt(j+i)) {
                table[j][j+i] = true;
                count++;
            }
        }
    }
    return count;
}
