/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a
tuple of points (i, j, k) such that the distance between i and j equals the
distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and
coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

*/

//超时解法：
//计算出任意两个点之间的距离，定义line类保存两个点的坐标，将所有距离和点坐标数据保存在map<Length,Line>中
//双重循环遍历map，对于每个距离，找到和这个距离相等的Line，然后比较line的点信息，找出不重复并且有一个点为共同点的line，并res++
//代码极其复杂，解法很笨重，并且对于较大数据直接超时。


//正确解法：
//对于每一个点i，计算其他点到这个点的距离，对于每个距离，用map计数，然后对于每个距离个数c， res+=c*(c-1)。然后清空map，i++查找下一个点。
//res+=c*(c-1）的原因，相当于从等距离线中，随即有序挑选出两条的排列组合相当于A(2)(c)
class Solution {
    public int numberOfBoomerangs(int[][] points){
		int res = 0;
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i<points.length;i++ ) {
			for (int j = 0; j<points.length; j++) {
				if (i == j) {
					continue;
				}
				int dis = getDistance(points[i],points[j]);
				map.put(dis,map.getOrDefault(dis,0)+1);
			}
			for (Integer v :map.values() ) {
				res+= v*(v-1);
			}
			map.clear();
		}
		return res;
	}
	public int getDistance(int[] x,int [] y){
		int a = x[0] - y[0];
		int b = x[1] - y[1];
		return a*a + b*b;
	}
}
