# dp = [[[0]*2222 for i in range(11)] for j in range(2222)]
# for i in range(0,2023): dp[i][0][0]=1
# for i in range(1,2023):
#     for j in range(1,11):
#         for k in range(1,2023):
#             if k<i: dp[i][j][k]=dp[i-1][j][k]
#             else:dp[i][j][k]=dp[i-1][j-1][k-i]+dp[i-1][j][k]
# print(dp[2022][10][2022])
print(379187662194355221)