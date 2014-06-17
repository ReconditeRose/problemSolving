
import java.util.Scanner;

public class ProblemFive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[][] array = new int[9][9];
		
		while(s.hasNext()){
			for(int i=0;i<9;i++){
				String q = s.nextLine();
				int skip =0;
				for(int j=0;j<9;j++){
					char e = q.charAt(j+skip);
					if(Character.isDigit(e) || e =='x')
						if(e=='x')
							array[i][j]=0;
						else
							array[i][j] = e-48;
					else{
						j--;
						skip++;
					}
				}
			}

			SudokuSolver e = new SudokuSolver(array);
			e.solve();
			array = e.getGrid(); 
			
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++)
					System.out.print(array[i][j]);
				System.out.print("\n");
			}
		}
		s.close();
	}

}