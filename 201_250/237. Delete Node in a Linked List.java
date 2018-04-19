/*
Write a function to delete a node (except the tail) in a singly linked list,
given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third
node with value 3, the linked list should become 1 -> 2 -> 4 after
calling your function.
*/




//这里并没有给出链表的表头而是只给了要删除的节点，所以我们无法通过修改pre指针的方式删除
//所以这里我们通过修改值得方式“模拟”删除节点，即将需要删除节点的值修改为node.next.val，
//然后丢弃node.next
public void deleteNode(ListNode node) {
    if (node!=null&&node.next!=null) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
