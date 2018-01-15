/*
You are given a string representing an attendance record for a student. The record only contains the following three characters:
'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/

//注意迟到的判断，多次连续迟到两次是可以的，连续迟到三次以上则直接false
class Solution {
    public boolean checkRecord(String s) {
		int numL = 0, numA = 0, contMark = 0;
		for (int i = 0; i<s.length(); i++) {
			switch(s.charAt(i)){
				case 'A':
					numA++;
					contMark = 0;
					break;
				case 'L':
					contMark++;
					if (contMark > 2) {
						numL++;
					}
					break;
				default:
					contMark = 0;
					break;
			}
		}
		if (numL>=1||numA>1) {
			return false;
		}
		return true;
    }
}

//python会很简单, return s.count('A')<2 and s.count('LLL')<1
