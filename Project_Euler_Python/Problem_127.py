import Queue
import math
maxVal = 1000

pQ = Queue.Queue()
pQ.put([1,2,0])
pQ.put([1,3,0])

def GCD(a,b):
    if(b==0):
        return a
    else:
        return GCD(b,a%b)

def mP(i):
    r = 1
    if(i%2==0):
        r = 2
        i /= 2
    while(i%2==0):
        i /= 2

    j= 3
    while(i > 1):
        if(j > math.sqrt(i)+1):
            r *=i
            break

        
        if(i%j==0):
            r*=j
            i/=j
        while(i%j==0):
            i/=j
        j +=2
    return r
        
count =0
while(not pQ.empty()):
    p = pQ.get()
    c = p[0] + p[1]
    
    if(c >maxVal):
        continue
    
    pQ.put([p[1],p[1]*2-p[0],1])
    pQ.put([p[1],p[1]*2+p[0],2])
    pQ.put([p[0],p[1]+2*p[0],3])

    if(GCD(p[0],c) ==1 and GCD(p[1],c) == 1):
        if(mP(p[0]) * mP(p[1]) * mP(c) < c):
            count += 1
            print "Valus obtained: " + str([p[0],p[1],c])
            print "summation: " + str(mP(p[0]))+ " " + str(mP(p[1]))+ " "+ str(mP(c))  
print count

