//Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
public String reverseWords(String s) {
        char[] res = s.toCharArray();
		int begin = 0;
		int end = 0;
		for (int i = 0; i < res.length; i++) {
			if (res[i] == ' ') {
				end--;
				int a = begin,b=end;
				for (; b>a; ) {
					char temp = res[a];
					res[a] = res[b];
					res[b] = temp;
					b--;
					a++;	
				}
				begin = i+1;
				end = begin;
			}
			else
				end++;
		}
		int a = begin,b=--end;
		for (; b>a; ) {
			char temp = res[a];
			res[a] = res[b];
			res[b] = temp;
			b--;
			a++;
		}
		String ss = new String(res);
		return ss;
    }

