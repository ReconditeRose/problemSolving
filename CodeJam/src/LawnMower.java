import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class LawnMower {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			solve();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public static void solve() throws IOException {
		int total = 0;
		File aFile = new File("src//input.in");
		File save = new File("src//output.in");
		if (!save.exists()) {
			save.createNewFile();
		}
		FileWriter fw = new FileWriter(save.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		Scanner inScanner = new Scanner(aFile);
		try {
			total = inScanner.nextInt();
			inScanner.nextLine();
			for(int j=0;j<total;j++){
				int q,p;
				q = inScanner.nextInt();
				p = inScanner.nextInt();
				int[][] newA = new int[q][p];
				for(int i=0;i<q;i++){
					for(int n=0;n<p;n++){
						newA[i][n] = inScanner.nextInt();
					}
					if(inScanner.hasNextLine()){
						inScanner.nextLine();
					}
				}
				bw.write(String.format("Case #%d: %s\n",(j+1),getResult(newA)));
				System.out.println(String.format("Case #%d: %s",(j+1),getResult(newA)));
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		inScanner.close();

		bw.close();
	}
	
	
	public static String getResult(int[][] results){
		for(int i=0;i<results[0].length;i++){
			for(int j=0;j<results.length;j++){
				boolean minl,minh;
				minl= false;
				minh= false;
				for(int m =0;m<results.length;m++){
					if(results[m][i] > results[j][i])
						if(j!= m)
							minl = true;
				}
				for(int m =0;m<results[0].length;m++){
					if(results[j][m] > results[j][i])
						if(i!=m)
							minh = true;
				}
				if(minh && minl)
					return "NO";
			}
		}
		return "YES";
	}
}
