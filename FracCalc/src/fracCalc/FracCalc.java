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
    		int openParenIndex = inputList.lastIndexOf("(");
    		int closeParenIndex = indexOfAfter(inputList, ")", openParenIndex);
    		//create an arraylist for just the stuff in the parenthesis
    		ArrayList<String> parenList = new ArrayList<String>(inputList.subList(openParenIndex, closeParenIndex+1));
    		Fraction newFrac = mdas(parenList);
    	}   
    	
    	return "";
    }

    
    public static Fraction mdas (ArrayList<String> input) {
//    	if(input.contains("*")||input.contains("/")) {
//    		if 
//    	}
    	
    	
    	
    	
    	
    	return null;
    }

//helper methods
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
