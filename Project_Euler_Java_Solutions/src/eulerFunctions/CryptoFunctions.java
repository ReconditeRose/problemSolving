package eulerFunctions;



public class CryptoFunctions {
	
	public static String xorMap(String m,String k){
		int i=0;
		int check = k.length();
		StringBuilder newString = new StringBuilder();
		for(int j=0;j<m.length();j++){
			if(i==check)
				i=0;
			newString.append(((char) (m.charAt(j)^k.charAt(i))));
			i++;
		}
		return newString.toString();
	}
	
	static String commonEnglish[] = {"the","it","and","you","me","I","be","to","of","in","that","have"};
	
	public static boolean checkEnglish(String m){
		String listOfWords[] = m.split(" ");
		int number=0;
		for(int i=0;i<m.length();i++){
			if(!(((int) m.charAt(i))>=31 || ((int) m.charAt(i))<=127))
				return false;
		}
		for(int i=0;i<listOfWords.length;i++){
			for(int j=0;j<commonEnglish.length;j++){
				if(listOfWords[i].toLowerCase().equals(commonEnglish[j].toLowerCase())){
					number++;
				}
				
			}
		}
		
		if(number>10)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String defaultA = "Hello world";
		System.out.println(defaultA);
		defaultA = xorMap(defaultA,"abc");
		System.out.println(defaultA);
		defaultA = xorMap(defaultA,"abc");
		System.out.println(defaultA);
		System.out.println(CryptoFunctions.checkEnglish("I am be a potato"));
	}
}
