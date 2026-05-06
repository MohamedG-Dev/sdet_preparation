package prep.coding;

public class CalculateDoubleDigitIntegersfromString {

	public static void main(String[] args) {
		String str = "12abc34xyz56lmn10";
		int sum = 0;
		StringBuilder numSb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (Character.isDigit(ch)) {
				numSb.append(ch);
			} else {
				if (numSb.length() > 0) {
					sum += Integer.parseInt(numSb.toString());
					numSb.setLength(0);
				}
			}
		}
		// below if condition is for only when the digits are at the end of the string.
		if (numSb.length() > 0) {
			sum += Integer.parseInt(numSb.toString());
		}
		System.out.println(sum);
	}

}
