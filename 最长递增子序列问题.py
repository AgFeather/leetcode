'''
最长递增子序列问题

【题目】：

给定数组arr，返回arr的最长递增子序列。

【例子】：
arr=[10,22,9,33,21,50,41,60,80],返回的最长递增子序列为[10,22,33,41,60,80]长度为6。
'''


# 解法1：时间复杂度为O(n2)
nums = [10,22,9,33,21,50,41,60,80]
dp = [1] * (len(nums))
for i in range(len(nums)):
    for j in range(i):
        if nums[i] > nums[j]:
            dp[i] = max(dp[j]+1, dp[i])
print(dp[-1])


# 解法2：时间复杂度为O(nlongn)
# 设tails是一个数组，tails[i]表示最长递增子序列长度为i的序列的末尾元素的值，也就是这个最长递增子序列的最大元素的大小值。
# 然后遍历原数组，分别考察每个元素，更新tails数组

def lengthOfLIS(nums):
    tails = [0] * len(nums)
    size = 0
    for x in nums:
        i, j = 0, size
        while i != j:# 由于tail的性质，其一定是递增序列，通过二分查找，对tails进行更新
            m = (i + j) // 2
            if tails[m] < x:
                i = m + 1
            else:
                j = m
        tails[i] = x
        size = max(i+1, size)
    print(size)
    return size

lengthOfLIS(nums)
