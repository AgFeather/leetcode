//Given  two strings, you need to find the longest uncommon subsequence of two strings.
//The longest uncommon subsequence is defined as the longest subsequence of one of these strings
//and this subsequence should not be any subsequence of the other strings.










//解题思路：注意理解uncommon subsequence的内涵，即较长string一定是较短string的uncommon subsequence
public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        return a.length()>b.length()?a.length():b.length();
    }
