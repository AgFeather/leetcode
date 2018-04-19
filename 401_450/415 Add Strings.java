/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */





//最开始的思路是：先对两个字符串的共有位进行相加，然后将较长字符串省下的直接加到结果字符串上，
//但这样无法处理进位，例如：1+9，或者更极端的：1+19999
//所以最后想到还是直接对两个整体进行相加，在循环中加入判断即可
public String addStrings(String num1, String num2) {
    if (num1==null) {
		return num2;
	}
	if (num2 == null) {
		return num1;
	}
	String s = "";
	int flag = 0;
	String minS = num1.length()>num2.length()?num2:num1;
	String maxS = num1.length()<num2.length()?num2:num1;
	for (int i = 0; i < maxS.length(); i++) {
		if (i < minS.length()) {
			char temp1 = minS.charAt(minS.length()-i-1);
			char temp2 = maxS.charAt(maxS.length()-i-1);
			char temp = (char)(temp1 + temp2 + flag - '0');
			if (temp > '9') {
				flag = 1;
				temp = (char)(temp - 10);
			}
			else
				flag = 0;
			s = temp + s;
		}
		else {
			char temp = (char)(maxS.charAt(maxS.length()-i-1) + flag);
			if (temp > '9') {
				flag = 1;
				temp = (char)(temp - 10);
			}
			else
				flag = 0;
			s = temp + s;
		}
	}
	if (flag == 1) {
		s = '1' + s;
	}
	return s;
}


//one smarter solution
public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();
    int carry = 0;
    for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
        int x = i < 0 ? 0 : num1.charAt(i) - '0';
        int y = j < 0 ? 0 : num2.charAt(j) - '0';
        sb.append((x + y + carry) % 10);
        carry = (x + y + carry) / 10;
    }
    return sb.reverse().toString();
}
