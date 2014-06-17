package eulerProblems51_100;

public class Problem91 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int goal =50;
		int total=0;
		
		for(int x1=0;x1<=goal;x1++){
			for(int y2=0;y2<=goal;y2++){
				for(int x2=x1;x2<=goal;x2++){
					for(int y1=y2;y1<=goal;y1++){
						if(triangleVect(x1,y1,x2,y2)){
							total++;
						}
						
					}
				}	
			}
		}
		
		System.out.println(total);
		

	}
	
	public static boolean triangleVect(int x1, int y1, int x2,int y2){
		if(x1==x2 && y1  ==y2)
			return false;
		if(x1==0 && y1==0)
			return false;
		if(x2==0 && y2==0)
			return false;
		if(x2==0 && x1==0)
			return false;
		if(y1==0 && y2==0)
			return false;
		
		if(x1==0 && y2==0)
			return true;
		if(x1*(x1-x2) + y1*(y1-y2)==0){
			return true;
		}
		if(x2*(x1-x2) + y2*(y1-y2)==0)
			return true;
		return false;
		
		
	}

}
