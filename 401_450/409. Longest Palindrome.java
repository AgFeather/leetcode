/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/
//用map计算所有字母出现次数。
class Solution {
    public int longestPalindrome(String s) {
       Map<Character,Integer> map = new HashMap<>();
		for (int i = 0; i<s.length(); i++) {
			map.put(s.charAt(i),map.containsKey(s.charAt(i))?map.get(s.charAt(i))+1:1);
		}
		int res = 0;
		for (Character c : map.keySet()) {
			res+=map.get(c)/2;
		}
		if (res*2 >= s.length()) {
			return 2*res;
		}
		return 2*res+1;
    }
}



//优秀答案，不需要hashmap，直接使用hashset
public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
}
