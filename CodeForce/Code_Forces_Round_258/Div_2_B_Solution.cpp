#include <stdio.h>
#define maxSize 10000
using namespace std;
int main() {

    int s[maxSize];

    int i,q,lq,llq;

    int sB,eB;
    int sBv,k,bSv;

    scanf("%d\n",&i);

    scanf("%d",&lq);
    sB = -1;
    eB = 0;
    sBv = 0;
    bSv = 0;
    llq =-1;

    int r =0;

    for(k=1;k<i;k++){
        scanf("%d",&q);

        if(q < lq){
            sB = k-1-r;
            sBv = lq;
            bSv = llq;
            llq = lq;
            lq = q;
            break;
        }
                if(lq == q)
            r++;
        else
            r =0;
        llq = lq;
        lq = q;
    }
   if(sB == -1){
        printf("yes\n1 1");
        return 0;
    }
    for(;k<i;k++){
        scanf("%d",&q);

        if(q > lq){
            eB = k;
            llq = lq;
            lq = q;
            break;
        }
        llq = lq;
        lq = q;
    }
       if(bSv > lq){
            printf("no");
            return 0;
    }

    if(k== i){
        printf("yes\n%d %d",sB+1,i);
        return 0;
    }




    if(sBv > q){
            printf("no");
            return 0;
    }




    for(;k<i;k++){
        scanf("%d",&q);
        if(q < lq){
            printf("no");
            return 0;
        }

        llq = lq;
        lq = q;
    }

    printf("yes\n%d %d",sB+1,eB+1);

    return 0;
}
