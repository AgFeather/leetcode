/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).

Each LED represents a zero or one, with the least significant bit on the right.

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.

Example:

Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 */



/*
这道题一直没有特别好的思路，想法是不断进行排列组合，然后将所有结果放入list中返回。
也有人用switch case结构将所有结果都写在程序中，然后返回
下面是一个较好的方法：对小时h遍历0~11，对分钟m遍历0~59。然后判断h和m的bitCount和是否等于输入的num，
如果等于就说明当前h和m表示的时间满足要求。

trick：熟练运用了Integer.bitCount()函数进行bit统计
 */
public List<String> readBinaryWatch(int num){
    List<String> times = new ArrayList<>();
    for (int h = 0; h<12 ; h++) {
        for (int m = 0; m<60; m++) {
            if (Integer.bitCount(h)+Integer.bitCount(m) == num)
                times.add(String.format("%d:%02d", h, m));
        }
    }
    return times;
}
