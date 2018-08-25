/*
题目描述
小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
输出描述:
输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */

/*
解题思路：相当于定义一个滑动窗口，不断计算窗口中的值，如果小于sum窗口就向前扩展一个位置，大于sum则删除窗口的末尾
注意在删除时不需要进行 i++
 */
public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer> >();
    ArrayList<Integer> temp = new ArrayList<>();
    int tempSum = 0;
    for (int i = 1; i<sum;) { //tempSum>sum 进行删除操作时，不需要i++
        if (tempSum < sum) {
            tempSum += i;
            temp.add(i);
            i++;
        }else if (tempSum > sum){
            tempSum -= temp.get(0);
            temp.remove(0);
        }else{
            res.add(new ArrayList<Integer>(temp));
            temp.add(i);
            tempSum += i;
            i++;
        }
    }
    return res;
}
