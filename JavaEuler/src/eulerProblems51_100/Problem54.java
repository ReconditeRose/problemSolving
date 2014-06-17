package eulerProblems51_100;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.*;

import EulerProblems.Problem;

public class Problem54 implements Problem{
	private static Map<String,Integer> keyMap;
	static{
		keyMap = new HashMap<String,Integer>();
		for(int i=1;i<10;i++){
			keyMap.put(""+i, i);
		}
		keyMap.put("T", 10);
		keyMap.put("J", 11);
		keyMap.put("Q", 12);
		keyMap.put("K", 13);
		keyMap.put("A", 14);
		
	}
	
	static class HandComparator implements Comparator<String>
	{
		@Override
		public int compare(String o1, String o2) {
			return keyMap.get(o1.charAt(0))-keyMap.get(o2.charAt(0));
		}
		
	}
	private class cardCompare implements Comparator<String>{

		@Override
		public int compare(String arg0, String arg1) {
			return cardValue(arg0) - cardValue(arg1);
		}
		
	}
	

	private class Hand{
		private String[] Hand;
		private int[] overFlow;
		public int highCard;
		public int secondHigh;
		public int highType;
		
		public Hand(String[] values){
			Hand = values;
			highCard=0;
			highType=0;
		}
		
		public void computeType(){
			int max=-1;
			int total,tempHigh;
			int currentHigh = 0;
			boolean flush= false;
			for(int i=0;i<5;i++){
				total=0;
				for(int j=i;j<5;j++){
					if(Hand[i]==Hand[j])
						total++;
					else
						if(currentHigh<keyMap.get(Hand[i].charAt(0)));
							currentHigh = keyMap.get(Hand[i].charAt(0));
				}
				if(total==2 && max ==2){
					
					
				}
				if((total==2 && max ==3) || (total==3 && max==2)){
					
						
				}
				if(total>max){
					max=total;
					if(total==2){
						
						
					}
					if(total==3){
						
						
					}
					if(total==4){
						
						
					}
					if(total==5){
						
						
					}
				}
			}
			
			if(Hand[0].charAt(1)==Hand[1].charAt(1)
			&& Hand[0].charAt(1)==Hand[2].charAt(1)
			&& Hand[0].charAt(1)==Hand[3].charAt(1) 
			&& Hand[0].charAt(1)==Hand[4].charAt(1)){
				flush = true;
			}
			
			boolean straight = true;
			boolean royal = false;
			int start = keyMap.get(Hand[0].charAt(0));
			if(start == 10)
				royal= true;
			for(int i=1;i<5;i++){
				if(keyMap.get(Hand[i].charAt(0))!=start+i)
					straight=false;
			}
			
			
		}
		
	}
	private int cardValue(String a){
		char[] compareArray = {'T','J','Q','K','A'};
		char a1 = ((String) a).charAt(0);
		int a2;
		a2 = 0;
		for(int i =0;i<5;i++){
			if(compareArray[0]==a1){
				a2 = i+10;
			}
		}
		if(a2 == 0){
			a2= (int) (a1);
		}
		return a2;
	}


	@Override
	public String solve() {
		File aFile = new File("src//EulerProblems//poker.txt");
		ArrayList<String> strings = new ArrayList<String>();
		int totalPlayer = 0;
		try {
			Scanner inScanner = new Scanner(aFile);
			while (inScanner.hasNextLine()) {
				if(testHand(inScanner.nextLine())==1){
					totalPlayer+=1;
				}
			}
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		return String.valueOf(totalPlayer);
	}
	
	private int testHand(String combine){
		String a[] = new String[5];
		String b[] = new String[5];
		String result[] = combine.split(" ");
		for(int i=0;i<5;i++){
			a[i]= result[i];
			b[i]= result[i+5];
		}
		for(int i=0;i<5;i++){
			System.out.print(a[i]+" ");
			System.out.print(b[i]+" ");
		}
		System.out.println();
		
		//TODO add in checking of variables
		
		return 1;
	}


}
