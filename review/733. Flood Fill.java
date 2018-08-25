//实现洪水算法
//An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

//Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

//To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

//At the end, return the modified image.


class Image_re{
	public int x;
	public int y;
	public Image_re(int x, int y){
		this.x = x;
		this.y = y;
	}
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
		Stack<Image_re> stack = new Stack<>();
		stack.push(new Image_re(sr, sc));
		while(!stack.isEmpty()) {
			Image_re temp = stack.pop();
			image[temp.x][temp.y] = newColor;
			if (temp.x-1>=0&&image[temp.x-1][temp.y] == original) {
				stack.push(new Image_re(temp.x-1, temp.y));
			}
			if (temp.x+1<image.length&&image[temp.x+1][temp.y] == original) {
				stack.push(new Image_re(temp.x+1, temp.y));
			}
			if (temp.y-1>=0&&image[temp.x][temp.y-1] == original) {
				stack.push(new Image_re(temp.x, temp.y-1));
			}
			if (temp.y+1<image[0].length&&image[temp.x][temp.y+1] == original) {
				stack.push(new Image_re(temp.x, temp.y+1));
			}
		}
		return image;
    }
}




//recursive method

	public int[][] floodFill(int[][] image,int sr,int sc,int newColor){		
		if (image[sr][sc] == newColor) {
			return image;
		}
		int original = image[sr][sc];
		fill(image, sr, sc, newColor,original);
		return image;
		
	}
	public void fill(int[][] image, int sr, int sc, int newColor,int original) {
		
		if (sr<0||sc<0||sr>=image.length||sc>=image[0].length||image[sr][sc]!=original) {
			return;
		}
		image[sr][sc] = newColor;
		fill(image, sr-1, sc, newColor,original);
		fill(image, sr+1, sc, newColor,original);
		fill(image, sr, sc+1, newColor,original);
		fill(image, sr, sc-1, newColor,original);
	}
