package eulerProblems201_250;

import EulerProblems.Problem;

public class Problem206 implements Problem {

	
	public static boolean checkForm( long d){

		String a = String.format("%d",d);

		if(a.charAt(18)!='0')
			return false;
		for(int i=0;i<9;i++)
			if(a.charAt(2*i)!=((i+1)+'0'))
				return false;
		return true;
	}
	
	
	@Override
	public String solve() {
		for(long d = 1010101010;d<1389026623;d+=10)
			if(checkForm(d*d))
				return ""+d;
		return ""+0;
	}

}
