
import java.util.Scanner;

public class ProblemOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while(s.hasNext()){
			String e = s.next();
			String[] values = e.split(":");
			double a = Integer.parseInt(values[0]);
			double b = Integer.parseInt(values[1]);
			double c = Integer.parseInt(values[2]);

			double c1 = c/60;
			c1 = c1*360;
			
			double b1 = b/60+c/60/60;
			b1 = b1*360;;
			
			double a1 = (a/12 + b/60/12+c/60/60/12);
			a1 = a1*360;
			
			
			
			long sum =0;
			
			double angle1 = a1-b1;
			double angle2 = a1-c1;
			double angle3 = b1-c1;
			if(angle1 <0)
				angle1+=360;
			if(angle1 >=180)
				angle1 = 360-angle1;

			if(angle2 <0)
				angle2+=360;
			if(angle2 >=180)
				angle2 = 360-angle2;

			if(angle3 <0)
				angle3+=360;	
			if(angle3 >=180)
				angle3 = 360-angle3;

			
			
			System.out.println(String.format("%.2f,%.2f,%.2f", angle1,angle2,angle3));
		}
		s.close();
	}

}