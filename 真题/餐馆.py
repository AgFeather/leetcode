'''
题目描述
某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数； 有m批客人，每批客人有两个参数:b人数，c预计消费金额。 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
输入描述:
输入包括m+2行。 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000) 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
输出描述:
输出一个整数,表示最大的总预计消费金额
示例1
输入
复制
3 5 2 4 2 1 3 3 5 3 7 5 9 1 10
输出
复制
20
'''


'''
需要使用二分查找，否则超时
'''
import sys

def binarySearach(target, array):
    if array == []:
        return -1
    if target <= array[0]:
        return 0
    if target > array[-1]:
        return -1
    lo, hi = 0, len(array) - 1
    while lo + 1 != hi:
        mid = int((lo + hi) / 2)
        if target <= array[mid]:
            hi = mid
        else:
            lo = mid
    return hi


def findSolution(customers, capacity):
    maxValue = 0
    for i in range(len(customers)):
        idx = binarySearach(customers[i][0], capacity)
        if idx >= 0:
            count += 1
            maxValue += customers[i][1]
            del capacity[idx]
    return maxValue

args = list(map(int, sys.stdin.readline().strip().split()))
capacity = list(map(int, sys.stdin.readline().strip().split()))

numOfTables = args[0]
numOfCustomers = args[1]

customers = []
for i in range(numOfCustomers):
    arg = list(map(int, sys.stdin.readline().strip().split()))
    customers.append(arg)

# 排序 根据人数 降序
customers.sort(key=lambda k:k[0], reverse=True)
# 排序 根据金额 降序
customers.sort(key=lambda k:k[1], reverse=True)
# 升序
capacity.sort()

print(findSolution(customers, capacity, numOfTables))
