//Write a function that takes a string as input
//and returns the string reversed.




//提供三种方法
public String reverseString(String s){
    return new StringBuffer(s).reverse().toString()
}


public String reverseString(String s) {
    char[] res = s.toCharArray();
	for (int i = 0; i < s.length()/2; i++) {
		char temp = res[i];
		res[i] = res[res.length-i-1];
		res[res.length-i-1] = temp;
	}
	return new String(res);
}

public String reverseString(String s){
    String res = "";
    for (int i = s.length()-1; i>=0; i--) {
        res += s.charAt(i);
    }
    return res;
}
