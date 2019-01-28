package fracCalc;

public class TestingFraction {
	
	public static void main(String[] args) {
		Fraction frac1 = new Fraction("4");
		System.out.println(frac1);
		Fraction frac2 = new Fraction("-1/0");
		System.out.println(frac2);
		System.out.println(frac1.numerator() + " " + frac1.denominator());
		System.out.println(frac2.numerator() + " " + frac2.denominator());
		frac1.divide(frac2);
		System.out.println("done");
		System.out.println(frac1.numerator() + " " + frac1.denominator());
		System.out.println(frac1); //the answer
		System.out.println(frac2);
		
	}
}
