//You are given a map in form of a two-dimensional integer grid where 1 represents land
//and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally).
//The grid is completely surrounded by water, and there is exactly one island
// The island doesn't have "lakes"
//One cell is a square with side length 1. The grid is rectangular,
//width and height don't exceed 100. Determine the perimeter of the island.



//解题思路：每个陆地会产生四条边，而每两个相邻陆地会减少两条边。注意边界检查
public int islandPerimeter(int[][] grid) {
	int res = 0;
	for (int i = 0; i < grid.length; i++) {
		for (int j = 0; j < grid[0].length; j++) {
			if (grid[i][j] == 1) {
				res+=4;
				if (j+1!=grid[0].length&&grid[i][j+1]==1) {
					res-=2;
				}
				if (i+1!=grid.length&&grid[i+1][j]==1) {
					res-=2;
				}
			}
		}
	}
	return res;
}
