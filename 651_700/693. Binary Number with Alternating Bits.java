//Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.


public boolean hasAlternatingBits(int n) {
        int mark = n%2;
		n/=2;
		for (int i = 0; n!=0; i++) {
			int temp = n%2;
			if (temp == mark) {
				return false;
			}
			n/=2;
            mark = temp;
		}
		return true;
    }

