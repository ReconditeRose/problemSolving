#include <iostream>
#include <stdio.h>
using namespace std;

int main() {

    int i;
    scanf("%d", &i);

    int g = -1;
    int k=(i-1)/2;
    for(int j=0;j<i;j++){

        for(int n=0;n<k;n++)
            printf("*");
        for(int n=0;n<(i-2*k);n++)
            printf("D");
        for(int n=0;n<k;n++)
            printf("*");
        if(k==0)
            g = 1;
        k+=g;
        printf("\n");
    }

    return 0;
}