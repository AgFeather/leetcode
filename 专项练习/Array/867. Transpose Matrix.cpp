/*
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.



Example 1:

Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
Example 2:

Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 */


/*
完成矩阵转置，较为简单注意下标问题
 */


 class Solution {
 public:
     vector<vector<int>> transpose(vector<vector<int>>& A) {
         vector<vector<int>> res(A[0].size(), vector<int>(A.size()));
         for (size_t i = 0; i < A.size(); i++) {
             for (size_t j = 0; j < A[0].size(); j++) {
                 res[j][i] = A[i][j];
             }
         }
         return res;
     }
 };
