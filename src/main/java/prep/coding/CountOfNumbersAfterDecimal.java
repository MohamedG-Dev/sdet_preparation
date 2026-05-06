package prep.coding;

public class CountOfNumbersAfterDecimal {

	public static void main(String[] args) {
		double num = 123.456789;
		String input = String.valueOf(num);
		int indexOfDecimal = input.indexOf(".");
		System.out.println(input.length()-indexOfDecimal-1);

	}

}
