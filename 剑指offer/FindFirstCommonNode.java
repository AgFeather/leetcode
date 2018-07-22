/*
题目描述
输入两个链表，找出它们的第一个公共结点。
公共节点意味着p1和p2中间的某个节点的next事相同的，整个链表的结构类似于双头蛇一样，有一个共同的尾巴
 */

/*
解法1：使用hashset将一个链表的元素存起来，然后遍历另一个链表，如果set包含该节点，表示共同节点
 */
import java.util.*;
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    Set<ListNode> set = new HashSet<>();
    ListNode temp = pHead2;
    while(temp != null){
        set.add(temp);
        temp = temp.next;
    }
    temp = pHead1;
    while(temp != null){
        if (set.contains(temp)) {
            return temp;
        }
        temp = temp.next;
    }
    return null;
}
/*
解法2：计算两个链表的长度a，b。假设a>b，就让a先走a-b个节点，然后相互对比
 */
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    int i=0, j=0;
    ListNode temp = pHead1;
    while(temp != null){
        temp = temp.next;
        i++;
    }
    temp = pHead2;
    while(temp != null){
        temp = temp.next;
        j++;
    }
    ListNode t1 = pHead1;
    ListNode t2 = pHead2;
    if (i > j) {
        for (int k = 0; k<i-j; k++) {
            t1 = t1.next;
        }
    }else{
        for (int k = 0; k<j-i; k++) {
            t2 = t2.next;
        }
    }
    while(t1 != t2){
        t1 = t1.next;
        t2 = t2.next;
    }
    return t1;
}
