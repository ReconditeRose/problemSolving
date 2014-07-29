import time
current_milli_time = lambda: int(round(time.time() * 1000))

def testCase(func,inp,out,time=False):
    if(time):
        ts = current_milli_time()
    result = func(inp)
    print "Expected Output:" + str(out)
    print "Resulted Output:" + str(result)
    if(time):
        print "Time Taken:"+ str(current_milli_time()-ts) + "ms"
    if(result == out):
        print "--PASSED--"
    else:
        print "--FAILED--"

def timedSolution(func):
    ts = current_milli_time()
    rr = func()
    tt = current_milli_time() - ts
    print("# Result: "+rr)
    print("# Solve Time: "+str(tt) +"ms")
