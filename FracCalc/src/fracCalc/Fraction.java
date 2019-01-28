package fracCalc;

public class Fraction {
//NOTE TO SELF: there are ONLY improper fractions
	
	private int numerator = 0;
	private int denominator = 1;
	
	public Fraction(String oprnd) {
		String[] firstSplit = oprnd.split("_"); 
		if (oprnd.contains("/")) { //if there is a fraction
			String fraction = firstSplit[firstSplit.length - 1]; //get the last value split
			String[] secondSplit = fraction.split("/"); //split into numer and denom
			this.numerator = Integer.parseInt(secondSplit[0]); //assign 0 to numer
			this.denominator = Integer.parseInt(secondSplit[1]); //assign 1 to denom	
			
			if (oprnd.contains("_")) { //if there also is a whole
				int whole = Integer.parseInt(firstSplit[0]); //assign first value to whole
				this.numerator += (absValue(whole) * this.denominator()); //convert to improper
	            if (whole < 0) {this.numerator*= -1;} //yay negatives
			}
			
		} else { //if there is no fraction
			this.numerator = Integer.parseInt(firstSplit[0]); 
		}
	}
	
	public int numerator() {
		return this.numerator;
	}
	
	public int denominator() {
		return this.denominator;
	}

	public void add(Fraction num) {
		int numer2 = num.numerator() * this.denominator();
		this.denominator *= num.denominator(); 
		this.numerator *= num.denominator();
		this.numerator += numer2;
	}
	
	public void subtract(Fraction num) {
		int numer2 = num.numerator() * this.denominator();
		this.denominator *= num.denominator(); 
		this.numerator *= num.denominator();
		this.numerator -= numer2;
	}
	
	public void multiply(Fraction num) {
		this.denominator *= num.denominator();
		this.numerator *= this.numerator();
	}
	
	public void divide(Fraction num) {
		this.denominator *= absValue(num.numerator());
		this.numerator *= num.denominator();
		if (num.numerator() < 0) {
			this.numerator *= -1;
		}
	}
		
    public String toString() {

    	//if numerator = 0, return 0
    	if (this.numerator == 0) {
    		return 0 + "";
    	}
    	
    	//simplify fraction
    	int gcf = gcf(this.numerator, this.denominator);
    	if (gcf!=1 && this.denominator!=1) {
    		this.numerator /= gcf;
    		this.denominator /= gcf;
    	}
    	
    	//turn into mixed number and return
    	if (absValue(this.numerator) > this.denominator && this.denominator != 1) {
    		int whole = this.numerator / this.denominator;
    		int numerNew = this.numerator % this.denominator;
    		return whole + "_" + absValue(numerNew) + "/" + this.denominator;
    	} else if (this.denominator == 1) {
    		return this.numerator + "";
    	} else {
    		return this.numerator + "/" + this.denominator;
    	}
    }
   
    
    //helper methods:
    
	//returns the greatest common factor of two ints
	public static int gcf(int num1, int num2) {
		int guess = 1;
		for (int i = 1; i <= absValue(num1); i++) {
			if (isDivisibleBy(num1, i) && isDivisibleBy(num2, i) ) {
				guess = i;
			}
		}
		return guess;
	}
	
	//checks for divisibility of two ints. num1 HAS TO BE GREATER than num2
	public static boolean isDivisibleBy (int num1, int num2) {
		num1 = absValue(num1);
		num2 = absValue(num2);
		
		if (num1 == 0 || num2 == 0) {
			throw new IllegalArgumentException("can't divide by 0!");
		}
		if (num1 % num2 == 0) {
			return true;
		} else {
			return false;
		} 

	}
	
    //returns absolute value of a number
	public static int absValue (int number) {
		if (number < 0) {
			return number * -1;
		} else {
			return number;
		}
	}

}
