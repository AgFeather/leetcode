/*
实现reshape函数

Example 1:
Input:
nums =
[[1,2],
 [3,4]]
r = 1, c = 4
Output:
[[1,2,3,4]]
Explanation:
The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
Example 2:
Input:
nums =
[[1,2],
 [3,4]]
r = 2, c = 4
Output:
[[1,2],
 [3,4]]
Explanation:
There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.

 */

class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        if (r * c != nums.size() * nums[0].size()) {
            return nums;
        }
        vector<vector<int>> res(r, vector<int>(c, 0));
        int resI = 0, resJ = 0;
        for (size_t i = 0; i < nums.size(); i++) {
            for (size_t j = 0; j < nums[0].size(); j++) {
                if (resJ < c) {
                    res[resI][resJ] = nums[i][j];
                    resJ++;
                }else{
                    resJ = 0;
                    resI++;
                    res[resI][resJ] = nums[i][j];
                    resJ++;
                }
            }
        }
        return res;
    }
};
