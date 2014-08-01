#include <iostream>
#include <stdio.h>
using namespace std;

#define CHECK_BIT(var,pos) (1 & (var>>(pos)))

int main() {

    int m,n;
    scanf("%d %d", &m,&n);
    double valPow[20][m];
    double rArray[m];

    for(int i=0;i<m;i++){
        valPow[0][i] = (1.0)/((float) m);
    }

    int pow = 1;
    for(int i=1;pow<n;i++,pow *= 2){
        double r = 0;
        double n =0;
        for(int j=0;j<m;j++){
            n = r;
            r += valPow[i-1][j];
            valPow[i][j] = valPow[i-1][j] * (r+n);
            // printf("%lf la\n",r);
        }
    }
    pow = 1;
    int i=0;
    for(i=0;pow<=n;i++,pow *= 2){
        if(!CHECK_BIT(n,i)){
            // printf("No bit %d\n",i);
            continue;
        }
        // printf("adding bit %d\n",i);
        for(int j=0;j<m;j++){
            rArray[j] = valPow[i][j];
        }
        break;
    }

    i++;
    pow *=2;
    for(;pow<n;i++,pow *= 2){
        if(!CHECK_BIT(n,i)){
            continue;
        }
        // printf("combining bit %d\n",i);
        double r = 0;
        double n =0;
        double tn = 0;
        for(int j=0;j<m;j++){
            tn += rArray[j];
            r += valPow[i][j];

            rArray[j] = rArray[j] * (r) + valPow[i][j] * n;
            n = tn;
            // printf("%lf la\n",r);
        }
    }

    float result =0;
    for(int i =0;i<m;i++){
        result += (i+1)*rArray[i];
        // printf("%lf %d\n",rArray[i],i);
    }
    // printf("%d\n",pow);
    printf("%lf\n",result);
    return 0;
}