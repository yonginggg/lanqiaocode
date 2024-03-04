from datetime import *
dt1 = datetime(2022,1,1)
cnt = 0
for i in range(0,365):
    s = "%02d%02d%02d" %(dt1.year,dt1.month,dt1.day)
    dt1 += timedelta(days=1)
    if "012" in s or "123" in s or "234" in s or "345" in s or "456" in s or "567" in s or "678" in s or "789" in s:
        cnt+=1
print(cnt)