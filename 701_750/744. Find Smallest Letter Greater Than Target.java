/*
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"
*/


class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char res = ' ';
		int i = 0;
		boolean flag = true;
		for (; i<letters.length; i++) {
			if (letters[i]>target) {
				res = letters[i];
				flag = false;
				break;
			}
		}
		if (flag) {
			return letters[0];
		}
		return res;
    }
}
