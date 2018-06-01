/*
替换空格


请实现一个函数，将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */



public String replaceSpace(StringBuffer str) {
    String res = "";
    for (int i = 0; i<str.length(); i++) {
        if (str.charAt(i) == ' ')
            res += "%20";
        else
            res += str.charAt(i);
    }
    return res;
}
