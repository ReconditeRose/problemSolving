#include <iostream>
#include <stdio.h>
using namespace std;

int main() {

    int num;
    int j;
    char cArray[26];
    char s[1000];
    char next;
    scanf("%c",&next);
    for(int i=0;i<26;i++){
        cArray[i]=0;
    }

    while(next != '}'){
        if((next-'a' >=0 && (next-'a') <=25))
            cArray[next-'a'] =1;
        scanf("%c",&next);
    }
    int sum=0;
    for(int i=0;i<26;i++)
        if(cArray[i]==1)
            sum++;

    printf("%d",sum);
    fflush(stdout);


    return 0;
}