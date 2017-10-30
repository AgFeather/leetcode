//Write a function that takes a string as input and returns the string reversed.
public String reverseString(String s) {
        char[] res = s.toCharArray();
		for (int i = 0; i < s.length()/2; i++) {
			char temp = res[i];
			res[i] = res[res.length-i-1];
			res[res.length-i-1] = temp;
		}
		String ss = new String(res);
		return ss;
    }
