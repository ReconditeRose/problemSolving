#include <stdio.h>
using namespace std;
int main() {

    int i =0;

    scanf("%d\n",&i);

    long long n,k,d1,d2;
    for(int j=0;j<i;j++){
        scanf("%I64d",&n);
        scanf("%I64d",&k);
        scanf("%I64d",&d1);
        scanf("%I64d",&d2);

       if(d2 > d1){
            long long temp = d2;
            d2 = d1;
            d1 = temp;
        }

        if(n%3 !=0){
            printf("no\n");
            continue;
        }

        long long r;
        r = (k -2*d1 -d2);
        if( (r % 3 ==0 ) && (r >= 0 )){
            r = (n-k - d1 - 2*d2);
            if((r%3 ==0) && (r>=0)){
                printf("yes\n");
                continue;
            }
        }

        r = (k -d1 -d2);
        if( (r % 3 ==0 ) && (r >= 0 )){
            r = (n-k - 2*d1+d2) ;
            if((r%3 ==0) && (r>=0)){
                printf("yes\n");
                continue;
            }
        }

        r = (k -2*d1 +d2);
        if( (r % 3 ==0 ) && (r >= 0 )){
            r = (n-k - d2 - d1);
            if((r%3 ==0) && (r>=0)){
                printf("yes\n");
                continue;
            }
        }

        r = (k -2*d2 -d1);
        if( (r % 3 ==0 ) && (r >= 0 )){
            r = (n-k - d1*2 - d2);
            if((r%3 ==0) && (r>=0)){
                printf("yes\n");
                continue;
            }
        }


            printf("no\n");
       }

    return 0;
}
