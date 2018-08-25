


// 使用ArrayList保存然后排序，最后输出，不知道原因，最后一个测试用例不通过
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            Set<Integer> set = new HashSet<>();
            ArrayList<Integer> res = new ArrayList<>();
            int n = in.nextInt();
            int m = in.nextInt();
            for (int i = 0; i<m+n; i++) {
                int temp = in.nextInt();
                if(!set.contains(temp)){
                    set.add(temp);
                    res.add(temp);
                }
            }
            Collections.sort(res);
            for (int i = 0; i<res.size(); i++) {
                System.out.print(res.get(i));
                if(i!=res.size()){
                    System.out.print(" ");
                }
            }
        }
    }
}


// 使用TreeSet，TreeSet默认元素由自然升序保存。
// 不过TreeSet集合没有get方法，所以想要获取它的元素就需要使用迭代对象iterator
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<Integer>();
        while(in.hasNext()){
            int m = in.nextInt();
            int n = in.nextInt();
            for(int i=1; i<=m+n; i++){
                set.add(in.nextInt());
            }
            Iterator<Integer> it = set.iterator();
            while(it.hasNext()){
                System.out.print(it.next());
                if(it.hasNext())
                    System.out.print(" ");
            }
        }
    }
}
