package prep.day14;

public class StringManipualation {

	public static void main(String[] args) {
		String input = "r@56vi Ku$%mar67";
		//expected output:rvi kumar 24
		StringBuilder sb = new StringBuilder();
		int sum=0;
		char[] arr = input.toCharArray();
		for (char ch : arr) {
			if (Character.isLetter(ch)||ch==' ') {
				sb.append(ch);
			}else if(Character.isDigit(ch)) {
				sum +=Character.getNumericValue(ch);
			}

		}
		sb.append(" ").append(sum);
		System.out.println(sb.toString());

	}

}
