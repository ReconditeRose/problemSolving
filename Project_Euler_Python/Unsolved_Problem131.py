import math
rangeSearch = 1000000

primes = [1]*(rangeSearch+1)
primes[1] =0
for i in range(2,int(math.sqrt(rangeSearch)+1)):
    if(primes[i]==0):
        continue
    il = i
    i = i+il
    while(i<=rangeSearch):
        primes[i]=0
        i = i+il

checkRange = 100000
lFound =1
for i in range(1,checkRange):
    tempCube = i*i*i
    for j in range(lFound,i):
        tempSquare = j*j
        if(tempCube%tempSquare==0):
            pCheck = tempCube/tempSquare - j
            if(pCheck>rangeSearch):
                break
            if(primes[pCheck]==1):
                print(str(pCheck) + " "+ str(j))
                lFound = j
                
