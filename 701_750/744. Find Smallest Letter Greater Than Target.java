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

// 注意题干中强调的sorted list，所以不需要比较每个letter和target的距离

public char nextGreatestLetter(char[] letters, char target) {
	for (int i = 0; i<letters.length; i++) {
		if (letters[i]>target) {
			return letters[i];
		}
	}
	return letters[0];
}
