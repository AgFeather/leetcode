

'''
给出一组活动，告诉每个活动的开始时间和结束时间，要求出算出能参加的最多活动的数量

贪心算法的典型问题：活动安排问题，解题思想是：
按照结束时间从小到大对活动进行排序
参加活动指针i指向第一个活动，然后比较下一个活动，
如果下一个活动的起始时间晚于i，参加该活动并将i移到当前活动
否则跳过该活动

'''
n = int(input())
nums = []
for i in range(n):
    a, b = [int(x) for x in input().split()]
    nums.append([min(a, b), max(a, b)])

nums = sorted(nums, key=lambda x:x[1])
count = [True] * n
i = 0
for j in range(1, n):
    if nums[j][0] >= nums[i][1]:
        i = j
        count[j] = True
    else:
        count[j] = False


res = 0
for i in count:
    if i:
        res += 1
print(res)
