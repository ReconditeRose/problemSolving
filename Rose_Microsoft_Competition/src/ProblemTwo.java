
import java.util.Scanner;

public class ProblemTwo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x=0;
		int y=0;
		int dir =0;
		while(s.hasNext()){
			String a = s.next();
			if(a.equals("Move")){
				int dist = s.nextInt();
				switch(dir){
				case 0: y+=dist;
				break;
				case 1: x+=dist;
				break;
				case 2: y-=dist;
				break;
				case 3: x-=dist;
				}
				
				
			}else if(a.equals("Turn")){
				String b = s.next();
				if(b.equals("right")){
					dir+=1;
				}else{
					dir-=1;
				}
				if(dir==4)
					dir=0;
				if(dir== -1)
					dir=3;
			}
			System.out.println(String.format("%d,%d", x,y));
		}
		s.close();
	}

}