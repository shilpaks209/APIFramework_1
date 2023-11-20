package assisgnments;

public class Assignments_1 {
	public static int[] countCharacter(String inputString) {
		 
		int[] charCountArray = new int[128];
		 
		
	       
	        for (int i = 0; i < inputString.length(); i++) {
	            char currentChar = inputString.charAt(i);
	
	            charCountArray[currentChar]++;
	        }

	        for (int i = 0; i < charCountArray.length; i++) {
	           if (charCountArray[i] > 0) {
	                System.out.println("Character: " + (char) i + ", Count: " + charCountArray[i]);
	            }}
			return charCountArray ;
	}

}
