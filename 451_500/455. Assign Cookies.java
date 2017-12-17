/*
Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

Note:
You may assume the greed factor is always positive. 
You cannot assign more than one cookie to one child.



*/

//讲输入的两个array从大到小排序，然后遍历两个list
//比较两者当前的最大值,s的最大值大于g最大值时，将这个饼干分给这个孩子，结果++，两个array的指针分别向后移。
//这个解法非常慢。
class Solution {
    public int findContentChildren(int[] g,int[] s){
		Arrays.sort(g);
    Arrays.sort(s);
		int j = s.length-1;
		int res = 0;
		for (int i = g.length-1;i>=0&&j>=0 ;i-- ) {
			if (g[i]<=s[j]) {
				j--;
				res++;
			}
		}
		return res;
	}
}
