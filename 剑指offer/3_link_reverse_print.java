/*
从尾到头打印链表

输入一个链表，从尾到头打印链表的每个值
 */


/*
最直接的思路是先将链表翻转，然后逐一打印值，但是由于给定返回时arraylist，
所以只需要顺序遍历然后reverse即可。
 */

import java.util.*;
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> list = new ArrayList<>();
    ListNode temp = listNode;
    while(temp != null){
        list.add(temp.val);
        temp = temp.next;
    }
    Collections.reverse(list);
    return list;
}
