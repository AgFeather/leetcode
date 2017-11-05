//We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
//Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

//从数组头开始遍历，遇到1，则i+=2（遇到1则意味着该位为2bits字符，所以向后移两位），遇到0，则i++（在前者移动规则基础上，如何还可以遇到0，则意味着该位
//为1bit字符），最后判断标志i的位置是否为bits.length-1，如果是，则意味着移动过后指向了最后一个0，也就是说最后一个0是1bit字符。

public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
		while (i<bits.length-1) {
			if (bits[i] == 0) {
				i++;
			}
			else
				i+=2;
		}
		return i == bits.length-1;
    }
