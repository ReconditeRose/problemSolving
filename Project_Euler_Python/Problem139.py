## Project Euler Problem 139
## Rose Olson
## 7/14/2014
## Result: 10057761
## Solve Time: 111749ms
import time
import Queue
import math
current_milli_time = lambda: int(round(time.time() * 1000))

def GCD(a,b):
    if(b==0):
        return a
    return GCD(b,a%b)

def pythagoreanGenerator(GOAL):
    pQ = Queue.PriorityQueue()
    pQ.put([12,[[1,2],[3,4,5]]])
    while(True):
        nV = pQ.get()
        n = nV[1][0][0]
        m = nV[1][0][1]
        if(nV[0] > GOAL):
            return
        if(GCD(m,n)==1 and (abs(m-n) % 2 ==1)):
            yield nV[1][1]
        if(n==1):
            m = m+1
            a = m*m - n*n
            b = 2*m*n
            c = m*m+n*n
            pQ.put([a+b+c,[[n,m],[a,b,c]]])
            m = m-1
        if(n<m-1):
            n = n+1
            a = m*m - n*n
            b = 2*m*n
            c = m*m+n*n
            pQ.put([a+b+c,[[n,m],[a,b,c]]])

def solve():
    GOAL = 100000000
    pGen = pythagoreanGenerator(GOAL)
    total = 0
    for i in pGen:
        a= i[0]
        b = i[1]
        c = i[2]
        if(c % abs(a - b)==0):
            total += int(math.floor(GOAL/(a+b+c)))
            print i
    Goal = 10000000
    return str(total)


ts = current_milli_time()
rr = solve()
tt = current_milli_time() - ts
print("Result: "+rr)
print("Solve Time: "+str(tt) +"ms")
