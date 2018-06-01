/*
最长回文子串，是一个典型的动态规划问题，使用动态规划可以在时间复杂度和空间复杂度都为O(n2)的情况下解题
步骤如下：
1. 首先构建二维数组：boolean[][] table
2. 初始化table[i][i]=true，表示所有长度为1的子串都为回文子串
3. 初始化table[i][i+1]=true if(s[i]==s[i+1])，表示如果两个字符相同则该子串为回文子串。之所以需要两次初始化，
是因为判断长度为3的子串需要看长度为1，而判断长度为4的子串需要看长度为2.
4. 分别判断子串长度从2~s.length的子串是否为回文子串，状态转移方程为：
table[i][j] = table[i+1][j-1]&&s[i]==s[j]
表示如果字符串S(i+1,j-1)为回文子串并且s[i]==s[j]，那么字符串S(i,j)也为回文子串
 */



 public String findLongestPalindrome(String s){
     if (s.length() <= 1)
         return s;
     String longestStr = null;
     boolean[][] table = new boolean[s.length()][s.length()];
     //初始化所有长度为1的子串都为回文串=true
     for (int i = 0; i<s.length(); i++) {
         table[i][i] = true;
     }
     //初始化所有长度为2的，两个字符一样的字符串为回文串=true
     for (int i = 0; i<s.length()-1; i++) {
         if (s.charAt(i) == s.charAt(i+1)) {
             table[i][i+1] = true;
             longestStr = s.substring(i, i+2);
         }
     }
     //从长度为3开始遍历，直到长度为s.length()
     for (int i = 3; i<=s.length(); i++) {
         //从第1个字符按照长度为i进行判断是否是回文子串
         for (int j = 0; j<=s.length()-i; j++) {
             int k = i + j - 1;
             table[j][k] = table[j+1][k-1]&&(s.charAt(j)==s.charAt(k));
             if (table[j][k] == true && i > longestStr.length())
                 longestStr = s.substring(j, k+1);
         }
     }
     return longestStr;
 }
