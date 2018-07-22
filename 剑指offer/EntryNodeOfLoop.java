/*
链表中环的入口节点


题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */

// 判断链表是否有环，利用set的特性，非常简单
public ListNode EntryNodeOfLoop(ListNode pHead){
    ListNode temp = pHead;
    Set<ListNode> set = new HashSet<>();
    while(temp!=null){
        if (set.contains(temp)){return temp;}
        set.add(temp);
        temp = temp.next;
    }
    return null;
}



/*
不适用set，利用快慢指针求解

第一步，找环中的一个点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
第二步，链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
来源：牛客网

第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,
p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，
p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
 */

ListNode EntryNodeOfLoop(ListNode pHead){
    if (pHead == null || pHead.next == null) return null;
    ListNode p1 = pHead, p2 = pHead;
    while(p2 != null && p2.next != null){
        p1 = p1.next;
        p2 = p2.next.next;
        if (p1 == p2) {
            p2 = pHead;
            while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            if (p1 == p2)
                return p1;
        }
    }
    return null;
}
