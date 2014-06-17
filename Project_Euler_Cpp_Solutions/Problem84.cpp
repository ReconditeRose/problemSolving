#include <stdio.h>

#define ITERATES 100
#define CELLS 40

#define DEBUG 1

#define JAIL 10
#define GTJ 30
#define CC1 2
#define CC2 17
#define CC3 33
#define CH1 7
#define CH2 22
#define CH3 36
#define GO 0

#define DIE 4
void CCAdv(double rollBase, double * grid,double cellProb);
void CHAdv(double rollBase, double * grid,double cellProb, int nextR, int nextU, int back3);

int main(){
    int i,j;
    double currentCellProbability[3][CELLS];
    double nextCellProbability[3][CELLS];

    double * NCGrid;
    double * CCGrid;
    double finalProb[CELLS];

    for(i=0;i<CELLS;i++){
        for(j=0;j<3;j++){
            currentCellProbability[j][i] =0;
            nextCellProbability[j][i]=0;
        }
    }

    currentCellProbability[0][0]=1.0;

    double rollBase = 1.0/(DIE*DIE);

    for(int iteration=0;iteration<ITERATES;iteration++){
        for(i=0;i<CELLS;i++){
            for(int d1=1;d1<=DIE;d1++){
                for(int d2=1;d2<=DIE;d2++){
                    for(j=0;j<3;j++){
                        int nCell = (i+d1+d2)%CELLS;
                        double modifier = 1;
                        CCGrid = currentCellProbability[j];
                        if(d1==d2){
                            if(j==2){
                                nextCellProbability[0][JAIL] +=  rollBase * CCGrid[i] * modifier;
                                continue;

                            }else{
                                NCGrid = nextCellProbability[j+1];

                            }
                        }  else{
                            NCGrid = nextCellProbability[0];
                        }

                        switch(nCell){
                            case(CC1):
                            case(CC2):
                            case(CC3):
                                CCAdv(rollBase,NCGrid,CCGrid[i]);
                                modifier = (14.0/16.0);
                                break;

        					case(CH1):
                                CHAdv(rollBase,NCGrid,CCGrid[i],15,12,CH1-3);
                                modifier = (6.0/16.0);
                                break;

							case(CH2):
                                CHAdv(rollBase,NCGrid,CCGrid[i],25,28,CH2-3);
                                modifier = (6.0/16.0);
                                break;

							case(CH3):
                                CHAdv(rollBase,NCGrid,CCGrid[i],5,12,CH3-3);
                                modifier = (6.0/16.0);
                                break;

							case(GTJ):
                                nCell = JAIL;
                                break;

                            default:
                                break;
                        }
                        // if(nCell==10 || nCell ==15)
                        // printf("Adding %f\n",(rollBase * CCGrid[i] * modifier));
                        NCGrid[nCell] += (rollBase * CCGrid[i] * modifier);
                    }
                }
            }
        }


        for(i=0;i<CELLS;i++){
            for(j=0;j<3;j++){

                currentCellProbability[j][i] =nextCellProbability[j][i];

                nextCellProbability[j][i]=0;
            }
        }


    }


    #ifdef DEBUG
    for(i=0;i<CELLS;i++){
        finalProb[i] = 0;
        for(j=0;j<3;j++){
            finalProb[i] += currentCellProbability[j][i];
        }
        printf("Probability of Cell %d= %.5f\n",i,finalProb[i]);
    }
    #endif
	return 1;
}

void CCAdv(double rollBase, double * grid,double cellProb){
    grid[GO] += cellProb * (1.0/16.0)* rollBase;
    grid[JAIL] += cellProb * (1.0/16.0)* rollBase;
}

void CHAdv(double rollBase, double * grid,double cellProb, int nextR, int nextU, int back3){
    grid[GO] += cellProb * (1.0/16.0)* rollBase;
    grid[JAIL] += cellProb * (1.0/16.0)* rollBase;
    grid[nextU] += cellProb * (1.0/16.0)* rollBase;
    grid[back3] += cellProb * (1.0/16.0)* rollBase;
    grid[nextR] += cellProb * (2.0/16.0)*rollBase;

    grid[11] += cellProb * (1.0/16.0)*rollBase;
    grid[24] += cellProb * (1.0/16.0)*rollBase;
    grid[39] += cellProb * (1.0/16.0)*rollBase;
    grid[5] += cellProb * (1.0/16.0)*rollBase;
}