/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */


/*
最开始的思想是按顺序直接构建整个杨辉三角到rowIndex，但是时间复杂度是O(n2)，
于是考虑到直接计算第rowIndex行，注意到杨辉三角的每位的取值其实是：C(i, rowIndex)，即可计算每位数值
比较直接的思想是对于每一个值，都从头计算，但发现其实每次计算的数值只是在之前数值上再乘一个(rowIndex-i+1)，
然后再除一个i。这样做更有效率
 */
public List<Integer> getRow(int rowIndex){
    List<Integer> list = new ArrayList<>();
    list.add(1);
    if (rowIndex == 0) return list;
    long numerator = 1;
    for (int i = 1; i<=rowIndex; i++) {
        numerator *= (rowIndex-i+1);
        numerator /= i;
        list.add((int)numerator);
    }
    return list;
}
