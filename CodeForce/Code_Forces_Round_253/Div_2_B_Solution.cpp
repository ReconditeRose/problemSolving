#include <stdio.h>
using namespace std;

int checkMax (int len, char * pointer, int s1, int s2){
    int i=0;
    int _s1 = s1;
    int _s2 = s2;
    while(pointer[s1] == pointer[s2]){
        if(s1== _s2)
            return -1;
        s1++;
        s2++;
        if(s2==len)
            return (s2-s1) - (s1-_s1);
    }
    return -1;
}

int checkTandem (char * pointer, int s1, int e1){
    if((e1-s1 + 1) %2 != 0)
        return -1;

    int s2 = (e1-s1+1)/2 + s1;
    while(pointer[s1] == pointer[s2]){
        if(s1== s2)
            return -1;
        s1++;
        s2++;
        if(s2==e1)
            return (e1-s1)*2;
    }
    return -1;
}

int main() {


    char s[201];
    char next;


    int i=0;
    scanf("%c",&next);
    while(next != '\n'){
        s[i] = next;
        i++;
        scanf("%c",&next);

    }
    s[i] = '\0';
    int max;

    scanf("%d",&max);
    fflush(stdout);
    int min;
    if(i>=max)
        min = max*2;
    if(i<max){
        if((i+max)%2==0)
            min = max+i;
        else
            min = max+i-1;
    }

    for(int j=0;j<i;j++){
        for(int k=j+1;k<i;k++){
            int r = checkMax(i,s,j,k);
            if(r != -1)
                if(r <= max){
                    int save = (k-j)*2;
                    if(save > min)
                        min = save;
                }

            r = checkTandem(s,j,k);
            if(r== -1)
                continue;
            if(r > min)
                min = r;

        }
    }
    printf("%d",min);
    return 0;
}