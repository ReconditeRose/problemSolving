public class pythagoreanGenerator{


    public class triple{
        int a,b,c,m,n;

        public String toString(){
            return "["+a+","+b+","+c+"]";
        }

        public triple(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;

        }

                public triple(int m, int n){
            this.m = m;
            this.n= n;

            this.a = m*m - n*n;
            this.b = 2*m*n;
            this.c = m*m + n*n;

            if(a>b){
                int temp = a;
                a = b;
                b = temp;
            }
        }
    }

    private class compareByPerimeter<triple>(){


    }

    PriorityQueue<triple> pQ;


    public pythagoreanGenerator(){
        pQ = new PrioirtyQueue<tripe>();
        pQ.push(new triple(2,1));
        boundry = _boundry;
    }

    public triple next(){
        tripe a = pQ.pop();

    if(a.n+1 < a.m)
        pQ.push(new triple(a.m,a.n+1));
    if(a.n==1)
        pQ.push(new triple(a.m+1,a.n);

        return a;
    }


}

public class Problem_139{

    private static GOAL = 1000;

    public static main(string args[]){

        pythagoreanGenerator pG = new pythagoreanGenerator();

        int total = 0;

        triple next;
        int p = 0;
        while(p<GOAL){
            next = pG.next();
            p = next.a+next.c+next.b;

            if(c%(b-a) == 0)
                total++;
        }

    }

}

public class Problem_138{

    private static GOAL = 5;

    public static main(string args[]){

        pythagoreanGenerator pG = new pythagoreanGenerator();

        int total = 0;

        triple next;

        int sum =0;

        while(total < GOAL){
            next = pG.next();
            if(next.a*2 = next.b +1 || next.a*2 = next.b -1){
                total++;
                sum += next.c;
            }
        }

    }

}