/*
Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:
Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:
Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
Note:

0 < s1.length, s2.length <= 1000.
All elements of each string will have an ASCII value in [97, 122].
 */


/*
题目所求为使得两个字符串ascii和相同的最小删除字符ascii和，所以我们直接设C[i][j] 为s1 前 i个字符与s2 前j个字符得到题目要求所需删除的字符和。
那么我们开始构造转移方程：
对于s1[0...i−1] 和 s2[0...j−1] 所需要删除的和应该是这样的：

若 s1[i−1]==s2[j−1] ，则C[i][j]=C[i−1][j−1]
若不相等，则s1[i−1], s2[j−1] 选择删除一个，
C[i][j]=min(C[i−1][j]+s1[i−1],C[i][j−1]+s2[j−1])
这里应该还是比较容易理解的，从这个字符选择一个能够得到较小的C[i][j] 值的删除。
 */

public int minimumDeleteSum(String s1, String s2){
    int res = Integer.MAX_VALUE;
    char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
    int[][] table = new int[s1.length()+1][s2.length()+1];
    for (int i = 1; i<s2.length()+1;i++ ) {
        table[0][i] = c[0][i-1] + c2[i-1];
    }
    for (int i = 1; i<s1.length()+1;i++ ) {
        table[i][0] = c[i-1][0] + c1[i-1];
    }
    for (int i = 1; i<s1.length()+1; i++) {
        for (int j = 1; j<s2.length()+1; j++) {
            if (c1[i-1] == c2[j-1]) {
                table[i][j] = table[i-1][j-1];
            }else{
                //delelte s1[i-1] or s2[j-1]
                table[i][j] = Math.min(table[i-1][j]+c1[i-1], table[i][j-1]+c2[j-1]);
            }
        }
    }
}
