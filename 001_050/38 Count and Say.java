/*
The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

 */

/*
将连续出现n次的字符c改写成为“nc”
 */
public String countAndSay(int n){
    String s = "1";
    for (int i = 1; i<n; i++) {
        char current = s.charAt(0);
        int count = 1;
        String temp = "";
        for (int j = 1; j<s.length(); j++) {
            if (current == s.charAt(j)) {
                count++;
            }else{
                temp += count + "" + current;
                current = s.charAt(j);
                count = 1;
            }
        }
        temp += count + "" + current;
        s = temp;
    }
    return s;
}
