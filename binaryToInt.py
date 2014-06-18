import random

files = open("H:/files","w+")

arrays = []
count =-1

def aArray(string):
    global count
    count= count+1
    arrays.append(string)

aArray("animationStringBounceClockwise")

files.write("byte "+arrays[count]+" = {")
files.write("0,1")
i=1
for j in range(31):
    if(j>14):
        i = (i>>1)
    else:
        i = (i<<1)+1
    iHi = i/(256)
    iLo = i%(256)

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationStringClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("0,1")
i=1
v=1
for j in range(31):
    if(j>14):
        i= i-v
        v = (v<<1)
    else:
        i = (i<<1)+1
    iHi = i/(256)
    iLo = i%(256)
    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationStringBounceAntiClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("128,0")
i = 32768
q = 32768 
for j in range(31):
    if(j<15):
        i = i/2
        q = q+i
    elif j >15:
        i = i*2
        q = q-i
    else:
        q = q-i
        
    iHi = q/(256)
    iLo = q%(256)

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationStringAntiClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("128,0")
i = 32768
q = 32768
z = 32768
for j in range(31):
    if(j>14):
        q = q-z
        z = z/2
    else:
        i = i/2
        q = q+i
        
    iHi = q/(256)
    iLo = q%(256)

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n\n")

aArray("animationLongPulseClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("15,15")
i1 = 15
for j in range(31):
    i1 = i1<<1

    if(i1 > 255):
        i1 = i1+1
        i1 = i1-256
        
    iHi = i1
    iLo = i1

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationShortPulseClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("51,51")
i1 = 51
for j in range(31):
    i1 = i1<<1

    if(i1 > 255):
        i1 = i1+1
        i1 = i1-256
        
    iHi = i1
    iLo = i1

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationLongPulseAntiClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("15,15")
i1 = 15
for j in range(31):
    if((i1 & 1) ==1):
        i1 = i1+256
        
    i1 = i1>>1
    
    iHi = i1
    iLo = i1

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n")

aArray("animationLongPulseAntiClockwise")
files.write("byte "+arrays[count]+" = {")
files.write("51,51")
i1 = 51
for j in range(31):
    if((i1 & 1) ==1):
        i1 = i1+256
        
    i1 = i1>>1
    
    iHi = i1
    iLo = i1

    files.write("," + str(iHi) + "," + str(iLo))
files.write("};\n\n")

for repeat in range(4):
    aArray("Hold"+str(repeat))
    files.write("byte "+arrays[count]+" = {")
    files.write("255,255")
    for j in range(31):
        files.write(",255,255")

    files.write("};\n")
files.write("\n")

for repeat in range(4):
    aArray("Repeat"+str(repeat))
    files.write("byte "+arrays[count]+" = {")

    ZIndex = [0]*16
    ZIndex[repeat] = 1
    files.write("0,"+str(1<<repeat))
    for j in range(15):

        z = 1
        q = 0
        for l in range(16):
            q = q+ ZIndex[l]*z
            z= z<<1

        iHi = q/(256)
        iLo = q%(256)
        files.write("," + str(iHi) + "," + str(iLo))

        v = random.randrange(0,16)
        while(ZIndex[v] == 1):
            v = random.randrange(0,16)
        ZIndex[v] = 1

    for j in range(16):
        z = 1
        q = 0
        for l in range(16):
            q = q+ ZIndex[l]*z
            z = z<<1
        iHi = q/(256)
        iLo = q%(256)
        files.write("," + str(iHi) + "," + str(iLo))

        v = random.randrange(0,16)
        while(ZIndex[v] == 0):
            v = random.randrange(0,16)
        ZIndex[v] = 0

    files.write("};\n")
files.write("\n")

files.write("byte animations = "+str(count+1)+";\n")
files.write("byte * animations[] = {")
for i in range(len(arrays)):
    if(i!=0):
        files.write(",")
    files.write(arrays[i])

files.write("};");

#define animationLength 32
byte * currentAnimation;
void setup(){
    

}

void setNewAnimation(){
    int i = random(0,animations);
    currentAnimation = animationArray[i];
}

void loop(){
    setNewAnimation();
    for(int i=0;i<animationLength*2;i+=2){
        byte highVal = currentAnimation[i+1];
        byte lowVal = currentAnimation[i];
    }
}



files.close()
