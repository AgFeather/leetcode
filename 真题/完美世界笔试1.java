/*
田忌赛马
 */


 import java.util.*;
 public class Main{
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         long[] a  = new long[n];
         long[] b  = new long[n];
         for (int i = 0; i<n; i++) {
             a[i] = in.nextLong();
         }
         for (int i = 0; i<n; i++) {
             b[i] = in.nextLong();
         }
         Arrays.sort(a);
         Arrays.sort(b);
         int i = n-1;
         int j = n-1;
         int res = 0;
         int jump = 0;
         while(j>=0){
             if (a[i]>b[j]) {
                 res++;
                 i--;
                 j--;
             }else if(a[i] == b[j]){
                  i--;
                  j--;
             }else{
                 jump++;
                 j--;
             }
         }
         res  = res - jump;
         System.out.println(res*100);
     }
 }
