
import java.util.Scanner;

public class ProblemSix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String query = s.nextLine();
			String query2 = s.nextLine();
			System.out.println(query+" "+query2);
			boolean check = true;
			boolean result = false;
			boolean blankstart = true;
			int start=0;
			int interum =0;
			while(check){
				int i;
				for(i=0;i<query.length();i++){
					if(start==query2.length()){
						check = false;
						break;
					}
					if(start+i+interum>=query2.length()){
						i=0;
						start++;
						break;
					}
					char c = Character.toLowerCase(query2.charAt(start+i+interum));
					char d = Character.toLowerCase(query.charAt(i));

					
					if(c==d && blankstart){
						continue;
					}else if(c==' '){
						blankstart=true;
						interum++;
						i--;
					}else{
						i=0;
						start++;
						blankstart=false;
						break;
						
					}
				}

				if(i==query.length()){
					check= false;
					result= true;
				}
			}
			System.out.println(result);
		}
		s.close();
	}

}