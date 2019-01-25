package fracCalc;

import java.util.*;

public class FracCalc {

    public static void main(String[] args) {
    	boolean done = false;
    	Scanner userInput = new Scanner(System.in);
    	while (!done) {
    		System.out.print("Enter your equation or type 'quit' to quit. ");
    		String input = userInput.nextLine();
    		if (input.equals("quit")) {
    			done = true;
    		} else {
    			System.out.println(produceAnswer(input));
    		}
    	}	
    	userInput.close();	
    }
    

    public static String produceAnswer(String input) { 
    	String[] inputArr = input.split(" ");
    	
    	return "";
    }

    
//  public static 
    public static Fraction mdas (String input) {
    	return null;
    }
  
    
    public static int[] parseFrac(String oprnd) {
		int whole = 0;
		int numer = 0;
		int denom = 1;
		String[] firstSplit = oprnd.split("_"); 
		if (oprnd.contains("/")) //if there is a fraction
		{ 
			String fraction = firstSplit[firstSplit.length - 1]; //get the last value split
			String[] secondSplit = fraction.split("/"); //split into numer and denom
			numer = Integer.parseInt(secondSplit[0]); //assign 0 to numer
			denom = Integer.parseInt(secondSplit[1]); //assign 1 to denom	
			if (oprnd.contains("_")) 
			{ //if there also is a whole
				whole = Integer.parseInt(firstSplit[0]); //assign first value to whole
			}
		} else 
		{ //if there is no fraction
			whole = Integer.parseInt(firstSplit[0]); //assign first value to whole
		}

		int[] returnArr = {whole, numer, denom};
		return returnArr;
    }

}
