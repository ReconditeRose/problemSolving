# Project Euler Problem 196
# Rose Olson
# 7/14/2014
#
# Result:
# Solve Time:
import PESupport
import pythagoreanFunctions
import math


def solve():
    GOAL = 10000
    GUESS = 100000000
    
    pg = pythagoreanFunctions.pythagoreanGenerator()
    mapR = [0] * GUESS
    for i in pg:
        print(i)
        mapR[i[0]] = mapR[i[0]] + 1
        mapR[i[1]] = mapR[i[1]] + 1
        if(i[0] > GOAL):
            break
    for i in range(GOAL):
        print("#" + str(i) +": "+str(mapR[i]))

    return str(i)


#Final Execution
PESupport.timedSolution(solve)
