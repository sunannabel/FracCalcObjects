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
    	ArrayList<String> inputList = new ArrayList<String>(Arrays.asList(inputArr));
    	boolean paren = true;
    	while (paren) {
    		if (inputList.contains("(")) {
    			//find last open parenthesis in equation & first close after that
    			int openParenIndex = inputList.lastIndexOf("(");
    			int closeParenIndex = indexOfAfter(inputList, ")", openParenIndex);
    			//create an arraylist for just the stuff in the parenthesis
    			ArrayList<String> parenList = new ArrayList<String>(inputList.subList(openParenIndex+1, closeParenIndex));
    			//chop that arraylist down into a single number
    			String newFrac = mdas(parenList);
    			//replace the entire parenthesis with that number
    			inputList.set(openParenIndex, newFrac);
    			for(int i = openParenIndex+1; i <= closeParenIndex; i++) {
    			inputList.remove(i);
    			}
    		//then repeat!
    		} else {
    			paren = false;
    		}
    	}
    	//we're done with parenthesis, last mdas
    	String finalFrac = mdas(inputList);
    	return finalFrac;
    }

    
    public static String mdas (ArrayList<String> input) {  
    	
    	if (input.contains("*") || input.contains("/")) {
    		//loop through to handle * and /
    		for (int i = 0; i < input.size(); i++) { 
    			if (input.get(i).equals("*") || input.get(i).equals("/")) {	
    				//calculates, puts val into i+1, replaces the other two with ""
    				//removing blank spaces screws up the for loop
    				//maybe i'll have a less jank solution someday
    				String operand1 = calculate(input.get(i-1), input.get(i+1), input.get(i)).toString();
    				input.set(i+1, operand1);
    				input.set(i, "");
    				input.set(i-1, "");
    				System.out.println("divided input:" + input);
    			}
    		}
    	
    		//remove those blank spaces whoo
    		while (input.contains("")) {
    			input.remove("");
    		}
    		System.out.println("after removing: " + input);
    	}
    	
    	//now do it again for + and -
    	//i'm so tired there's probably a more efficient way rip
    	if (input.contains("+") || input.contains("-")) {
    		for (int i = 1; i < input.size(); i+=2) { 
    			String operand1 = calculate(input.get(i-1), input.get(i+1), input.get(i)).toString();
    			input.set(i+1, operand1);
    			input.set(i, "");
    			input.set(i-1, "");
    			System.out.println("adding / subtracting: " + input);
    		}
    	} 
    	
    	//hecc u we're not getting rid of blank spaces because we'll just:
    	return input.get(input.size()-1);
    }

    //convert strings into fractions and then math those fractions together
    public static Fraction calculate(String op1, String op2, String operator) {
		Fraction operand1 = new Fraction(op1);
		Fraction operand2 = new Fraction(op2);
		operand1.doMath(operand2, operator); 
		return operand1;
    }
    
    
    public static int lastIndexOf(String[] arr, String str) {
    	for(int i = arr.length; i >= 0; i--) {
    		if (arr[i].equals(str)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public static int indexOfAfter(ArrayList<String> list, String str, int startIndex) {
    	for(int i = startIndex; i < list.size(); i++) {
    		if (list.get(i).equals(str)) {
    			return i;
    		}
    	}
    	return -1;
    }
    
}
