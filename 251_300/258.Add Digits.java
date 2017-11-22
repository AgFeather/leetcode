//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

//For example:

//Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

//Follow up:
//Could you do it without any loop/recursion in O(1) runtime?


//运行时间O(len(num)^2)
public int addDigits(int num){
			int res = num;
			while(res/10!=0){
				res = one_time(res);
			}
			return res;
		}
		public int one_time(int num){
			int res = 0;
			while(num/10!=0){
				res+=num%10;
				num/=10;
			}
            res+=num;
			return res;
		}
    
   //运行时间为O(1)，使用数根的特性
   
   public int addDigits(int num){
    return num == 0?0:(num%9==0?9:(num%9));
    }
