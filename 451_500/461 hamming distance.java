//calculate the hamming distance of two integers. eg: 4(0,1,0,0) and 1(0,0,0,1).hamming distance is 2
public int hammingDistance(int x, int y) {
    int temp = x^y;
	int res = 0;
	for (int i = 0; temp>0; i++) {
		res+=temp&1;
		temp>>=1;
	}
	return res;
}
