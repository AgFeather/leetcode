//Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
public boolean judgeCircle(String moves) {
        char[] c = moves.toCharArray();
        int x = 0,y = 0;
        for (int i =0; i<c.length; i++) {
        	switch (c[i]) {
        		case 'U':
        		x++;break;
        		case 'D':
        		x--;break;
        		case 'R':
        		y++;break;
        		case 'L':
        		y--;break;
        		default:
        		break;
        	}
        }
        if (x==0&&y==0) {
        	return true;
        }
        return false;
    }
//define two int number to mark the robot posion.
