import os
import sys

# 请在此输入您的代码
n = int(input())
nums={}
for i in range(n):
    x = int(input())
    if x in nums: nums[x]+=1
    else: nums[x]=1
key = list(nums.keys())
key.sort()
for i in key:
    print(i, nums[i])

# 根据value降序排列
# import os
# import sys

# # 请在此输入您的代码
# n = int(input())
# nums = {}
# for i in range(n):
#     x = int(input())
#     if x in nums:
#         nums[x] += 1
#     else:
#         nums[x] = 1

# sorted_nums = sorted(nums.items(), key=lambda x: x[1], reverse=True)
# for item in sorted_nums:
#     print(item[0], item[1])