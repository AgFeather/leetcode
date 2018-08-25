/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".
 */


//思路很清晰
public String reverseVowels(String s) {
    char[] cs = s.toCharArray();
    int l = 0;
    int r = cs.length-1;
    while(l<r){
        while(!isVowels(cs[l]) && l<s.length()){l++;}
        while(!isVowels(cs[r]) && r>=0){r--;}
        if (l>r){break;}
        char temp = cs[l];
        cs[l] = cs[r];
        cs[r] = temp;
        l++;
        r--;
    }
    return new String(cs);
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
