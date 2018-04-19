/*
There are 1000 buckets, one and only one of them contains poison, the rest are filled
with water. They all look the same. If a pig drinks that poison it will die within 15
minutes. What is the minimum amount of pigs you need to figure out which bucket contains
 the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:

If there are n buckets and a pig drinking poison will die within m minutes,
how many pigs (x) you need to figure out the "poison" bucket within p minutes?
There is exact one bucket with poison.

 */

//毒猪问题，最开始的想法是分治算法，但得到的不是最小值。查看答案后，发现这题考查的是思考维度：
//想象一下，如果只有一头猪，那么在一个小时，15分钟毒发的条件下，它可以试五桶水
//如果有两头猪呢，就可以组成一个2*2的矩阵，两头猪分别从行和列开始喝，通过这两头猪的死亡时间可以确定毒的坐标，也就是说，两头猪可以确定5^2个桶
//同理，如果三头猪，就从三个维度喝，可以确定5^3=125桶水
//总结规律，就是： N^5 >= 1000

public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    if (buckets <= 1) {
        return 0;
    }
    int times = (minutesToTest / minutesToDie) + 1;
    int res = 1;
    double temp = times;
    while(true){
        if(Math.pow(times, res) >= buckets)
            return res;
        res++;
    }
}
