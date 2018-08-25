//Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

//Substrings that occur multiple times are counted the number of times they occur.

//使用一个arraylist将所有连续的0，1子串长度存储起来，返回的结果res即为：res+=min(list.get(i),list.get(i+1))
//（对于第i个连续子串，它所能生成符合要求的子串长度为其长度和后一位长度的相对小值）

//最开始的思路，是在一个循环里记录并判断子串的内容是否改变，如果改变，则记录上一次的大小，并重新开始记录这个子串的大小然后比较，但发现实现难度非常大
//经过discuss启发，可以先利用一个循环和arraylist存储所有相同子串长度，然后再遍历list比较长度即可。

public int countBinarySubstrings(String s) {
        
//         char tempNumber = s[0];//tempNumber用来记录当前遍历的数字是0还是1
// 		int tempMax = 1;//tempMax用来记录本次tempNumber重复出现的次数
// 		tempCounter = 0;//用来记录本次tempNumber重复结束后，另一个数重新出现的次数
// 		int flag = 0;//用来记录是否又一次遍历到tempNumber
// 		int [] res = new int[2];
// 		for (int i = 1;i<s.length ;i++ ) {
// 			if (s[i] == tempNumber) {
				
// 				if (flag == 1) {
// 					flag = 0;
// 					res[tempNumber] +=Math.min(tempMax,tempCounter);
// 					tempMax = tempCounter-1;
// 					tempCounter = 1;
// 					tempNumber = tempNumber==1?0:1;
// 				}
// 				tempMax++;

// 			}
// 			else{
// 				flag = 1;
// 				tempCounter++;
// 			}
// 		}
        char [] cs = s.toCharArray();
		List<Integer> list = new ArrayList<>();
		int tempCount = 1;
		int tempNumber = cs[0] - 48;
		for (int i = 1; i<cs.length; i++) {
			if (tempNumber == cs[i]-48) {
				tempCount++;
			}
			else{
				list.add(tempCount);
				tempNumber = cs[i]-48;
				tempCount = 1;
			}
		}
        list.add(tempCount);
		int res = 0;
		for (int i = 0; i < list.size()-1; i++) {
			res+=Math.min(list.get(i), list.get(i+1));
		}
		return res;
    }
