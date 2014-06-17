import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TicTacToe {

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
		char Save;
		File aFile = new File("src//input.in");
		File save = new File("src//output.in");
		if (!save.exists()) {
			save.createNewFile();
		}
		FileWriter fw = new FileWriter(save.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		
		try {
			Scanner inScanner = new Scanner(aFile);
			total = inScanner.nextInt();
			inScanner.useDelimiter("");
			for(int j=0;j<total;j++){
				inScanner.nextLine();
				int[][] newA = new int[4][4];
				for(int i=0;i<4;i++){
					for(int n=0;n<4;n++){
						String next = inScanner.next();
						Save = next.charAt(0);
						if(Save == 'X'){
							newA[i][n]=1;
						}else if(Save =='O'){
							newA[i][n]=2;
						}else if(Save =='.'){
							newA[i][n]=0;
						}else{
							newA[i][n]=3;
						}
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
		bw.close();
	}
	public static String getResult(int[][] results){
		int winner =0;
		for(int j=1;j<3;j++){
			int diag=0;
			int diagl=0;
			for(int i=0;i<4;i++){
				if(results[i][i]!=j && results[i][i]!=3)
					diag=1;
				if(results[3-i][i]!=j && results[3-i][i]!=3)
					diagl=1;
				int hor=0;
				int vert =0;
				for(int n=0;n<4;n++){
					if(results[i][n]!=j && results[i][n] != 3)
						hor=1;
					if(results[n][i]!=j && results[n][i] != 3)
						vert=1;
				}
				if(hor==0)
					winner =j;
				if(vert==0)
					winner = j;
			}
			if(diag==0 || diagl==0)
				winner =j;
		}
		if(winner==0){
			int complete=0;
			for(int j=0;j<4;j++){
				for(int i=0;i<4;i++){
					if(results[i][j]==0){
						complete=1;
					}
				}
			}
			if(complete==1)
				winner=3;
		}
		switch(winner){
		case 1: return "X won";
		case 2: return "O won";
		case 0: return "Draw";
		default: return "Game has not completed";
		}
	}
}
