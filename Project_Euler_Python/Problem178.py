## Project Euler Problem 178
## Rose Olson
## 7/3/2014
## Result:126461847755
## Solve Time:2ms

import time
current_milli_time = lambda: int(round(time.time() * 1000))

def solve():

    hitN = [0,1,1,1,1,1,1,1,1,0]
    hit0 = [0,0,0,0,0,0,0,0,0,0]
    hit9 = [0,0,0,0,0,0,0,0,0,1]
    hitB = [0,0,0,0,0,0,0,0,0,0]

    HITN = 0
    HIT0 = 1
    HIT9 = 2
    HITB = 3

    NEXT = 1
    PREV = 0

    arrys = [[hitN, [0]*10],[hit0, [0]*10],[hit9, [0]*10],[hitB, [0]*10]]

    # Move the next set of values to the current set
    # Zero out next set
    def cpyArrayNZero(ary):
        for i in range(4):
            for j in range(10):
                ary[i][PREV][j] = ary[i][NEXT][j]
                ary[i][NEXT][j] = 0

    GOAL = 40
    result =0
    for i in range(1,GOAL):
        
        for k in range(10):
            if(k==0):
                for ary in arrys:
                    ary[NEXT][1] += ary[PREV][0]
            elif(k==9):
                for ary in arrys:
                    ary[NEXT][8] += ary[PREV][9]
            elif(k==1):
                arrys[HIT0][NEXT][0] += arrys[HITN][PREV][k]
                arrys[HIT0][NEXT][0] += arrys[HIT0][PREV][k]
                arrys[HITB][NEXT][0] += arrys[HIT9][PREV][k]
                arrys[HITB][NEXT][0] += arrys[HITB][PREV][k]

                for ary in arrys:
                    ary[NEXT][2] += ary[PREV][k]
                    
            elif(k==8):
                arrys[HIT9][NEXT][9] += arrys[HITN][PREV][k]
                arrys[HIT9][NEXT][9] += arrys[HIT9][PREV][k]
                arrys[HITB][NEXT][9] += arrys[HIT0][PREV][k]
                arrys[HITB][NEXT][9] += arrys[HITB][PREV][k]

                for ary in arrys:
                    ary[NEXT][7] += ary[PREV][k]
            else:
                for ary in arrys:
                    ary[NEXT][k-1] += ary[PREV][k]
                    ary[NEXT][k+1] += ary[PREV][k]
        cpyArrayNZero(arrys)

        for i in arrys[HITB][PREV]:
            result += i

    return str(result)

ts = current_milli_time()
rr = solve()
tt = current_milli_time() - ts
print("Result:"+rr)
print("Solve Time:"+str(tt)+"ms")
