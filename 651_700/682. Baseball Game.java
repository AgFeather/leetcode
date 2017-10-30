//You're now a baseball game point recorder. Given a list of strings, each string can be one of the 4 following types: Integer (one round's score): Directly represents the number of points you get in this round.
//"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
//"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
//"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
//Each round's operation is permanent and could have an impact on the round before and the round after. You need to return the sum of the points you could get in all the rounds.
//switch语句分离各个标签，然后将得分压入栈中，并根据标签对得分进行更新。
public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
		int res = 0;
		for (int i = 0; i < ops.length; i++) {
			switch (ops[i]) {
			case "D":
				res+=stack.peek()*2;
				stack.push(2*stack.peek());
				break;
			case "C":
				int temp = stack.pop();
				res-=temp;
				break;
			case "+":
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				res = res+temp1+temp2;
				stack.push(temp2);
				stack.push(temp1);
				stack.push(temp1+temp2);
				break;
			default:
				int temp3 = Integer.valueOf(ops[i]);
				res+=temp3;
				stack.push((int)temp3);
				break;
			}
		}
		return res;
    }
