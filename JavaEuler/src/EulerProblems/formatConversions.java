package EulerProblems;

import java.util.Scanner;

public class formatConversions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String st = "[\"";
		while(s.hasNext()){
			String e = s.next();
			if(e.equals("end"))
				break;
			st = st + e;
			st = st+ "\",\"";
		}
		st = st.substring(0,st.length()-2);
		st = st+"]";
		System.out.println(st);
	}

}
