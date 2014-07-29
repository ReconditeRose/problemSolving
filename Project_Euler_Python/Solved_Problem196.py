# Project Euler Problem 196
# Rose Olson
# 7/14/2014
#
# Result: 322303240771079935
# Solve Time: 57003ms
import Util_PESupport

import math
def solveRow(i):

    _max = ((i+2)*(i+3)/2)
    _min = ((i-2)*(i-3)/2)+1

    rows = [1]*(5*i)

    _pmax = int(math.sqrt(_max))


    primes = [1] * (_pmax)

    for k in range(2,_pmax):
        if(primes[k]==1):
            j=k+k
            while(j<_pmax):
                primes[j] = 0
                j+=k
            jump = int(math.ceil(_min/k))
            j = (jump+1)*k
            while(j<_max):
                rows[j-_min] = 0
                j+=k


    trap = []
    trapVal = []
    for j in range(5):
        trap.append([0]*(j+i))
        trapVal.append([0]*(j+i))

    #Convert to trapezoid and pad all sides
    count = _min
    count_unadj = 0
    for m in range(5):
        for n in range(1,m+i-1):
            trap[m][n] = rows[count_unadj]
            trapVal[m][n] = count
            count_unadj += 1
            count += 1

    trapTri = []
    for j in range(3):
        trapTri.append([0]*(j+i+1))

    #Find all the triples
    for m in range(1,4):
        for n in range(1,m+i-1):
            if(trap[m][n] == 0):
                continue
            count = -1
            for x in range(-1,2):
                for y in range(-1,2):
                    if(trap[m+y][n+x] == 1):
                        count +=1
            if(count >=2):
                trapTri[m-1][n] = count


    #Sum of triples
    result =0
    for n in range(1,i+1):
        if(trap[2][n] == 1):
            count = 0
            for x in range(-1,2):
                for y in range(-1,2):
                    if(trapTri[1+y][n+x] > 1):
                        count +=1
            if(count > 0):
                result += (i-1)*(i)/2+n

    return result


def solve():
    return str(solveRow(5678027) + solveRow(7208785))
#Test cases for verification
Util_PESupport.testCase(solveRow,8, 60)
Util_PESupport.testCase(solveRow,9, 37)
Util_PESupport.testCase(solveRow,10000, 950007619)
#Final Execution
Util_PESupport.timedSolution(solve)
