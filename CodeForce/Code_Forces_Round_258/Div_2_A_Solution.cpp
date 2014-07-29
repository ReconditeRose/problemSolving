#include <iostream>
#include <stdio.h>
using namespace std;

int main() {

    int i,j,m;

    scanf("%d %d",&i,&j);

    if (i>j)
        m = j;
    else
        m = i;

    if(m%2 == 0)
        printf("Malvika");
    else
        printf("Akshat");
    fflush(stdout);


    return 0;
}