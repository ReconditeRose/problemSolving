# Project Euler Problem 179
# Rose Olson
# 7/3/2014
#
# Result:986262
# Solve Time:10434ms
import Util_PESupport

def solve():

    Goal = 10000000
    divisors = [1]*Goal
    primes = [0]*Goal
    temp = [2]*Goal

    for i in range(2,Goal):
        if(primes[i]==0):
            q = i
            while q<Goal:
                j = q
                while j<Goal:
                    if(q==i):
                        temp[j] = 2
                    else:
                        temp[j] +=1
                    j += q
                q = q*i


            j = i
            while j<Goal:
                divisors[j] *= temp[j]
                primes[j] = 1
                j += i

    result = 0

    for i in range(2,Goal-1):
        if(divisors[i] == divisors[i+1]):
            result+=1
    return str(result)

Util_PESupport.timedSolution(solve)