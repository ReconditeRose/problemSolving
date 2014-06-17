
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProblemThree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){


			String e = s.nextLine();
			String[] values = e.split("\\|");
			String degree = values[0];
			int unit = Integer.parseInt(values[1]);

			ArrayList<String> splitter = new ArrayList<String>();
			int num = degree.length()/unit;
			for(int j=0;j<num;j++){
				String blank = "";
				for(int i=0;i<unit;i++)
					blank+=degree.charAt(unit*j+i);
				splitter.add(blank);
			}
			
			boolean evalf = true;
			if(!checkMirror(splitter))
				evalf= false;
			
			if(evalf)
				System.out.println(degree+"|"+unit+"|1"+"\n");
			else
				System.out.println(degree+"|"+unit+"|0"+"\n");
		}
		s.close();
	}
	
	static boolean checkMirror(ArrayList<String> a){
		for(int i=0;i<a.size();i++)
			if(!(a.get(i).equals(a.get(a.size()-1-i)))){
				
			//	System.out.println("False");
				return false;
			}
		return true;
	}

}