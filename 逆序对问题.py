'''
逆序数
给定一个数组[7,5,6,4]
这个数组的逆序数为5对(7,5) (7,6) (7,4) (5,4) (6,4)

'''

#最直观的做法，双循环找到所有逆序对，时间复杂度为 O(n2)
def inersenum(nums):
    count = 0
    for i in range(len(nums)):
        for j in range(i, len(nums)):
            if nums[i] > nums[j]:
                count += 1
    return count


# 归并思想，把数据分成前后两个数组(递归分到每个数组仅有一个数据项)。
# 合并数组，合并时，出现前面的数组值array[i]大于后面数组值array[j]时；
# 则前面数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i。

count = 0
import copy
def inversePairs(array):
    global count
    def mergeSort(array):
        global count
        if len(array) <= 1:
            return array
        num = len(array) // 2
        left = mergeSort(array[:num])
        right = mergeSort(array[num:])
        r, l = 0, 0
        result = []
        while l < len(left) < r < len(right):
            if left[l] < right[r]:
                result.append(left[l])
                l += 1
            else:
                result.append(right[r])
                r += 1
                count += len(left) - l
        result += right[r:]
        result += left[l:]

        return result
    mergeSort(array)
    return count



def inversePairs(array):
    if data == []:
        return 0
    else:
        num = 0
        while len(array) > 1:
            num += array.index(min(array))
            array.pop(array.index(min(array)))
        return num

        
