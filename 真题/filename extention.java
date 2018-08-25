/*
题目描述
Please create a function to extract the filename extension from the given path,return the extracted filename extension or null if none.
输入描述:
输入数据为一个文件路径
输出描述:
对于每个测试实例，要求输出对应的filename extension
示例1
输入
复制
Abc/file.txt
输出
复制
txt
 */


import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] ss = s.split("\\.");
            if (ss.length == 0||ss.length==1) {
                System.out.println("null");
            }else{
                System.out.println(ss[ss.length-1]);
            }
        }
    }
}
