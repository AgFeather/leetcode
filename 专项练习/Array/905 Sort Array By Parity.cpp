/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.



Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */


// 将所有偶数放到数组前，所有奇数放到数组后

 class Solution {
 public:
     vector<int> sortArrayByParity(vector<int>& A) {
         vector<int> even;
         vector<int> odd;
         for(int i = 0;i<A.size();i++){
             if (A[i]%2 == 0) {
                 even.push_back(A[i]);
             }else{
                 odd.push_back(A[i]);;
             }
         }
         for(int i = 0;i<odd.size(); i++){
             even.push_back(odd[i]);
         }
         return even;
     }


    vector<int> sortArrayByParity(vector<int>& A) {
        int begin = 0;
        int end = A.size()-1;
        while(begin < end){
            while(A[begin]%2 == 0){begin++;}
            while(A[end]%2 == 1){end--;}
            if(begin < end)
                swap(A[begin], A[end]);
        }
    return A;
    }


    vector<int> sortArrayByParity(vector<int>& A) {
        for(int i=0, j=0; j<A.size(); j++)
            if(A[j] % 2 == 0)
                swap(A[i++], A[j]);
        return A;
    }
 };
