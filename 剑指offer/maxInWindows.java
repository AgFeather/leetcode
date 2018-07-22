/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
{[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */


/*
需要复习！！！ 第二种解法

最直接的想法：使用一个ArrayList表示当前窗口，每次返回窗口元素的最大值即可
 */
public ArrayList<Integer> maxInWindows(int [] num, int size){
    ArrayList<Integer> res = new ArrayList<>();
    if (size > num.length || size == 0) return res;
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = 0; i<size; i++) {
        temp.add(num[i]);
    }
    res.add(Collections.max(temp));
    for (int i=size; i<num.length; i++) {
        temp.remove(0);
        temp.add(num[i]);
        res.add(Collections.max(temp));
    }
    return res;

}





/**
 * 题目：滑动窗口的最大值
 * 思路：滑动窗口应当是队列，但为了得到滑动窗口的最大值，队列序可以从两端删除元素，因此使用双端队列。
 *     原则：
 *     对新来的元素k，将其与双端队列中的元素相比较
 *     1）前面比k小的，直接移出队列（因为不再可能成为后面滑动窗口的最大值了!）,
 *     2）前面比k大的X，比较两者下标，判断X是否已不在窗口之内，不在了，直接移出队列
 *     队列的第一个元素是滑动窗口中的最大值
 */

public ArrayList<Integer> maxInWindows(int [] num, int size){
    ArrayList<Integer> res = new ArrayList<>();
    if (size < 1) return res;
    int begin;
    ArrayDeque<Integer> q = new ArrayDeque<>();
    for (int i = 0; i<num.length; i++) {
        begin = i-size+1;
        if (q.isEmpty()) q.add(i);
        else if (begin > q.peekFirst()) q.pollFirst();

        while(!q.isEmpty() && num[q.peekLast()] <= num[i]) q.pollLast();
        q.add(i);
        if (begin >= 0) res.add(num[q.peekFirst()]);
    }
    return res;

}
