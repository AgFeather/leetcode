/*
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1.
 */
import java.util.*;
public int FirstNotRepeatingChar(String str) {
    Map<Character, Integer> map = new HashMap<>();
    char[] temp = str.toCharArray();
    for (int i = 0; i<str.length(); i++) {
        map.put(temp[i], map.getOrDefault(temp[i], 0) + 1);
    }
    for (int i = 0; i<str.length(); i++) {
        if (map.get(temp[i]) == 1) {
            return i;
        }
    }
    return -1;
}
