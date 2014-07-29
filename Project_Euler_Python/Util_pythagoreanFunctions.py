import Queue

def GCD(a,b):
    if(b==0):
        return a
    return GCD(b,a%b)

def pythagoreanGenerator():
    pQ = Queue.PriorityQueue()
    pQ.put([3,[[1,2],[3,4,5],[1,[3,4,5]]]])
    while(True):
        nV = pQ.get()
        n = nV[1][0][0]
        m = nV[1][0][1]
        if(GCD(m,n)==1 and (abs(m-n) % 2 ==1)):
            yield nV[1][1]

        a = nV[1][2][1][0]
        b = nV[1][2][1][1]
        c = nV[1][2][1][2]

        mul =nV[1][2][0] + 1

        pQ.put([a*mul,[[n,m],[a*mul,b*mul,c*mul],[mul,[a,b,c]]]])


        if(mul==2):
            if(n==1):
                m = m+1
                a = m*m - n*n
                b = 2*m*n
                c = m*m+n*n

                if(a>b):
                    temp = a
                    a =b
                    b = temp

                pQ.put([a,[[n,m],[a,b,c],[1,[a,b,c]]]])
                m = m-1
            if(n<m-1):

                n = n+1
                a = m*m - n*n
                b = 2*m*n
                c = m*m+n*n

                if(a>b):
                    temp = a
                    a =b
                    b = temp

                pQ.put([a,[[n,m],[a,b,c],[1,[a,b,c]]]])
