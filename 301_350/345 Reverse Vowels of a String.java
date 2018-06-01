/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 */


//思路很清晰，相当于变相考察StringBuffer的应用
 public String reverseVowels(String s) {
    int l = 0;
    int r = s.length()-1;
    StringBuffer ss = new StringBuffer(s);
    while(l < r){
        while(!isVowels(ss.charAt(l)) && l < r) l++;
        while(!isVowels(ss.charAt(r)) && l < r) r--;
        char temp = ss.charAt(l);
        ss.setCharAt(l, ss.charAt(r));
        ss.setCharAt(r, temp);
        r--;
        l++;
    }
    return ss.toString();
 }
public boolean isVowels(char c){
    if (c =='a'||c =='e'||c =='i'||c == 'o'||c =='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
        return true;
    return false;
}



//一个更简洁的答案
public String reverseVowels(String s) {
    char[] ca = s.toCharArray();
    for(int h=0,t=ca.length-1;h<t;){
        if("AEIOUaeiou".indexOf(ca[h])==-1) h++;
        if("AEIOUaeiou".indexOf(ca[t])==-1) t--;
        if("AEIOUaeiou".indexOf(ca[h])!=-1&&"AEIOUaeiou".indexOf(ca[t])!=-1){
            char tmp = ca[h];
            ca[h++]=ca[t];
            ca[t--]=tmp;
        }
    }
    return new String(ca);
}
