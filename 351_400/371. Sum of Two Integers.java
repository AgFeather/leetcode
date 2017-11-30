//Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

//Example:
//Given a = 1 and b = 2, return 3.


//this is my stupid solution and it has not been finished 
class Solution {
    public int getSum(int a,int b){
        if (a<0||b<0){
        }
    }
    public int minusSum(int a,int b){
    }
    public int plusSum(int a, int b) {
        int res = 0;
		int c = 0;
        int i = 0;
		for (; a!=0||b!=0; i++) {
			int bByte = b%2;
			int aByte = a%2;
			if ((aByte^bByte^c) == 1) {
				res+=Math.pow(2,i);
			}
			if ((aByte&bByte) == 1||(aByte&c) == 1||(bByte&c) == 1) {
				c = 1;
			}
			else{
				c = 0;
			}
			a/=2;
			b/=2;
		}
        if(c == 1){
            res+=Math.pow(2,i);
        }
		return res;
    }
}



public int getSum(int a int b){
  if(b == 0)
    return a;
  int sum,carry;
  sum = a^b;
  carry = (a&b)<<1;
  return getSum(sum,carry);
  
}











