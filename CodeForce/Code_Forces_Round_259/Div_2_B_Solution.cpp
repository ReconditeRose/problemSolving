#include <iostream>
#include <stdio.h>
using namespace std;

int main() {

    int m;
    scanf("%d ", &m);

    int _t,_tl,first;
    scanf("%d",&_tl);
    first = _tl;
    int i=1;
    int shift =0;
    for(;i<m;i++){
        scanf("%d",&_t);
        if(_t < _tl){
            _tl = _t;
            i++;
            shift++;
            break;
        }
        _tl = _t;
    }

    for(;i<m;i++){
        scanf("%d",&_t);
        // printf("%d\n",_t);
        if(_t < _tl){
            printf("-1");
            return 0;
        }
        shift++;
        _tl = _t;
    }
    if(shift >0 && (first < _t)){
        printf("-1");
        return 0;
    }
    printf("%d",shift);
    return 0;
}