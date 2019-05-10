/*
输入节点和边数，判断给定的图是否为二分图。
 */


import java.util.*;

class Node{ // val为该节点包含的边的另一个端点的取值，next指向一下个边
    int val;
    Node next;
    public Node(int val,Node next){
        this.val = val;
        this.next = next;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // n个节点
        int M = in.nextInt(); // m条边
        Node nodes[] = new Node[N+1]; // 一个数组，每一位表示一个节点，元素是一个list表示该节点的所有边
        for(int i=0;i<N;i++)
            nodes[i] = null;
        for(int i=0;i<M;i++){
            int x = in.nextInt();
            int y = in.nextInt();
            nodes[y] = new Node(x,nodes[y]);
            nodes[x] = new Node(y,nodes[x]);
        }
        int first[] = new int[N+1];
        int other[] = new int[N+1];
        int first_p=0,other_p=0;
        for(int i =0;i< N;i++){
        	first[i] = -1;
        	other[i] = -1;
        }
        for(int i=0;i<N;i++){
        	if(!get_solution(i,other)){ // 该节点不在other集合中
        		if(!get_solution(i,first)){ // 也不再first集合中，将其添加到first集合
        			first[first_p++] = i;
        		}
        		for(Node tempNode=nodes[i];tempNode!=null;tempNode=tempNode.next){ //遍历i节点对应的所有边，边的另一个端点
                    // 判断所有边的另一个端点是否在first集合，如果在返回No，如果不再将其添加到other中。
        			if(!get_solution(tempNode.val,other)&&!get_solution(tempNode.val,first)){
        				other[other_p++] = tempNode.val;
        			}else if(get_solution(tempNode.val,first)){
        				System.out.println("No");
        				return;
        			}
        		}
        	}
        	else{ // 该节点i在other集合中
                // 遍历该节点所有边的端点，判断该端点是否在other集合中，如果在返回NO，否则将其加入first集合
        		for(Node tempNode=nodes[i];tempNode!=null;tempNode=tempNode.next){
        			if(!get_solution(tempNode.val,other)&&!get_solution(tempNode.val,first)){
        				first[first_p++] = tempNode.val;
        			}else if(get_solution(tempNode.val,other)){
        				System.out.println("No");
        				return;
        			}
        		}
        	}
        }
        System.out.println("Yes");
    }

	public static boolean get_solution(int x,int [] arrays){
		for(int i = 0;i<arrays.length;i++){
			if(x == arrays[i])
				return true;
		}
		return false;
	}
}
