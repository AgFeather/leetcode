//Reverse a singly linked list.

//iterative method: 先找到最后一个节点last，然后不断在last.next插入当前的头部节点
public ListNode reverseList(ListNode head) {
    if (head == null||head.next == null) {
		return head;
	}
    ListNode last = head;
	for (;last.next!=null ;last = last.next ) {}
	ListNode headTemp = head;
	ListNode lastTemp = last;
	while(headTemp != last){
		ListNode temp = last.next;
		last.next = headTemp;
		ListNode temp2 = headTemp.next;
		headTemp.next = temp;
		headTemp = temp2;
	}
	return headTemp;
}


//recursive method
public ListNode reverseList(ListNode head){
	if (head == null||head.next == null) {
		return head;
	}
	ListNode last = head;
	for (;last.next!=null ;last = last.next ) {}
	recursiveReverse(head,last);
	return last;
}
public void recursiveReverse(ListNode head,ListNode last){
	if (head == last) {
		return;
	}
	ListNode temp = last.next;
	last.next = head;
	ListNode temp2 = head.next;
	head.next = temp;
	recursiveReverse(temp2,last);
}

//最直观的想法：使用stack进行倒序
public ListNode reverseList(ListNode head){
	Stack<ListNode> stack = new Stack<>();
	for (ListNode temp = head;temp != null ;temp = temp.next ) {
		stack.push(temp);
	}
	ListNode res = stack.pop();
	while(!stack.isEmpty()){
		ListNode temp = stack.pop();
		res.next = temp;
		res = temp;
	}
	return res;
}
