# Project Euler Problem 179
# Rose Olson
# 7/3/2014
#
# Result: 3D58725572C62302L
# Solve Time: 71ms
import Util_PESupport

def solve():
    return hex(getCombinations(16)).upper()[2:]

def getCombinations(i):
    return startRecur(i)

def startRecur(i):
    if(i ==0):
        return 0
    return (2)*recurSolve(i-1,2,14) + (13) * recurSolve(i-1,3,13)+ startRecur(i-1)

def recurSolve(digits_left, unused_symbols,free_symbols):
    if(digits_left == 0):
        if(unused_symbols ==0):
            return 1
        return 0
    return (free_symbols) * recurSolve(digits_left -1, unused_symbols,free_symbols) + (unused_symbols) * recurSolve(digits_left-1, unused_symbols-1,free_symbols + 1)

##Util_PESupport.testCase(getCombinations,3,4)
##Util_PESupport.testCase(getCombinations,4,4)

Util_PESupport.timedSolution(solve)
