private static int GOAL = 200;

private static class Sums implements Comparable<Sums>{
    ArrayList<Integer> values;
    int currentMultiple;
    int multiplications;

    public void Sums(){
        values = new ArrayList<Integer();
        values.add(1);
        multiplications =0;
        currentMultple = 1;
    }

    public void Sums(int m, int ArrayList<Integer> v,int mu){
        values =v;
        currentMultple = m;
        multiplications = mu;
    }

    public ArrayList<Integer> getArrayCopy(){
        ArrayList<Integer> newA = new ArrayList<Integer>();
        for(int i: values)
            newA.add(i);
        return newA;

    }

    public int compareTo(Sums o){
        return this.multiplications - o.multiplications;
    }

}

main(){
    PriorityQueue<Sums> nQ = new PriorityQueue<Sums> nQ;

    int[] mins = new int[GOAL+1];
    nQ.add(new Sums());

    while(!nQ.isEmpty()){
        Sums s = nQ.pop();
        int cM = s.currentMultiple;
        int m = s.multiplications;

        for(int i: s.values){
            int tCM = cM + i;
            int tm = m+1;
            if(tCM >GOAL)
                continue;
            if(mins ==0 || mins[tCM] >= tm){
                nQ.add(new Sums(tCM,s.getArrayCopy().add(tCM),tm));
                mins[tCM] = tm;
            }
        }

    }

    int total = 0;
    for(int i=2;i<GOAL+1;i++)
        total+=mins[i];
    System.out.println(mins);
}