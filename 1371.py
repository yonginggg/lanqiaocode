s = input()
n = len(s)
i=0
j=n-1
flag=0
while(i<j):
    if s[i]!=s[j]:
        print('N')
        flag=1
        break
    i+=1
    j-=1
if(flag==0):print('Y')