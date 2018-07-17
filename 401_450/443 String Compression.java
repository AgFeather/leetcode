/*
Given an array of characters, compress it in-place.

The length after compression must always be smaller than or equal to the original array.

Every element of the array should be a character (not int) of length 1.

After you are done modifying the input array in-place, return the new length of the array.


Follow up:
Could you solve it using only O(1) extra space?


Example 1:
Input:
["a","a","b","b","c","c","c"]

Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]

Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
Example 2:
Input:
["a"]

Output:
Return 1, and the first 1 characters of the input array should be: ["a"]

Explanation:
Nothing is replaced.
Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]

Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
 */


/*
思路比较清晰，记录插入位置的index，然后比较每两个相邻字符，如果相同count++，如果不同就将
该字符和该字符连续出现的次数记录在index处

trick:将int每一位数转换为char数组不需要用loop循环不断/10,%10。可以先用valueOf将其
转换为string，然后toCharArray
 */



public int compress(char[] chars) {
    int index = 0;
    int count = 0;
    for (int i = 0; i<chars.length; i++) {
        count++;
        if (i == chars.length-1 || chars[i] != chars[i+1]) {
            chars[index++] = chars[i];
            if (count != 1) {
                char[] arr = String.valueOf(count).toCharArray();
                for (int j = 0; j<arr.length; j++) {
                    chars[index++] = arr[j];
                }
            }
            count = 0;
        }
    }
    return index;
}
