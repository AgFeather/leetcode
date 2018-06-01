/*
Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.
Example 1:
Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller
 */


/*
也算是思路比较清晰的一道题，将整个words放入一个set中，然后遍历words，对于每个string
的每个符合条件的substring，判断set是否contains，如果否就返回
最后从符合条件的string找出最长的，注意题干中强调如“Apple”和“apply”这样的情况返回字典序更小的那个
 */
public String longestWord(String[] words){
    Set<String> set = new HashSet<>();
    for (int i = 0; i<words.length; i++) {
        set.add(words[i]);
    }
    String res = "";
    for (int i = 0; i<words.length ; i++) {
        String substring = null;
        boolean flag = true;
        for (int j = 1; j<words[i].length() ;j++ ) {
            substring = words[i].substring( 0, j);
            if (!set.contains(substring)) {
                flag = false;
                break;
            }
        }
        if (flag && words[i].length() > res.length()) {
            res = words[i];
        }else if(flag && words[i].length() == res.length()){
            if(res.compareTo(words[i]) < 0)
                res = words[i];
        }
    }
    return res;
}
