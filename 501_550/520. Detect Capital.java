Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.



很简单的题，对三种情况分别判断即可


   public boolean detectCapitalUse(String word) {
        if (word.equals(word.toLowerCase())||word.equals(word.toUpperCase())) {
			return true;
		}
        char[] array = word.toCharArray();
        if (array[0]<65||array[0]>90) {
			return false;
		}
        for (int i = 1; i < array.length; i++) {
			if (array[i]>=65&&array[i]<=90) {
				return false;
			}
		}
        return true;
  }
