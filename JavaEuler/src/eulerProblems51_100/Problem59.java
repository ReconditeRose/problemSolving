package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import EulerProblems.Problem;
import eulerFunctions.CryptoFunctions;

public class Problem59 implements Problem {


	public String readDelimitedFileToString(String file, String Del) {
		StringBuilder a = new StringBuilder();
		File aFile = new File(file);
		Scanner inScanner;
		try {
			inScanner = new Scanner(aFile);
			inScanner.useDelimiter(Del);
			while (inScanner.hasNext()) {
				a.append(((char) inScanner.nextInt()));
			}
			inScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return a.toString();
	}

	@Override
	public String solve() {
		int sum=0;
		String text = readDelimitedFileToString("src//EulerProblems//cipher1.txt",",");
		for(char a= 'a';a<'z';a++){
			for(char b= 'a';b<'z';b++){
				for(char c= 'a';c<'z';c++){
					String concat = a+""+b+""+c;
					String result = CryptoFunctions.xorMap(text, (concat));
					if(CryptoFunctions.checkEnglish(result))
						for(int i=0;i<result.length();i++)
							sum+=result.charAt(i);
				}
			}
		}
//		System.out.println(CryptoFunctions.xorMap(b, "zzz"));
		return ""+sum;
	}
}
