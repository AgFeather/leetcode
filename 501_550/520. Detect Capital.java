// Given a word, you need to judge whether the usage of capitals in it is right or not.

// We define the usage of capitals in a word to be right when one of the following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital if it has more than one letter, like "Google".
// Otherwise, we define that this word doesn't use capitals in a right way.



// 很简单的题，对三种情况分别判断即可
public boolean detectCapitalUse(String word) {
    if (word.equals(word.toLowerCase())||word.equals(word.toUpperCase())) {
		return true;
	}
    if (word.charAt(0)<'A'||word.charAt(0)>'Z') {
		return false;
	}
    for (int i = 1; i < word.length(); i++) {
		if (word.charAt(i)>='A'&&word.charAt(i)<='Z') {
			return false;
		}
	}
    return true;
}


//更便捷的解法，正则表达式
public boolean detectCapitalUse(String word){
    return word.match("[A-Z]+|[a-z]+|[A-Z][a-z]+");
}
