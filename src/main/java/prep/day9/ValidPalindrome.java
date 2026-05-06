package prep.day9;

public class ValidPalindrome {

	public static void main(String[] args) {
		String str = "A man, a plan, a canal: Panama";
		if (validPalindromeUsingStringBuilder(str))
			System.out.println("Valid paindrome");
		else
			System.out.println("Not a valid palindrome");
		
		if (checkValidPalindromeUSingTwoPointerApproach(str))
			System.out.println("Valid paindrome");
		else
			System.out.println("Not a valid palindrome");

	}

	public static boolean validPalindromeUsingStringBuilder(String string) {
		char[] arr = string.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (char ch : arr) {
			if (Character.isLetterOrDigit(ch)) {
				sb.append(Character.toLowerCase(ch));
			}
		}

		String updatedString = sb.toString();
		String reversedString = sb.reverse().toString();
		return reversedString.equals(updatedString) ?  true :  false;
	}
	
	public static boolean checkValidPalindromeUSingTwoPointerApproach(String str) {
		char[] arr = str.toLowerCase().toCharArray();
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			while(left<right&&!Character.isLetterOrDigit(arr[left]))
				left++;
			
			while(left<right&&!Character.isLetterOrDigit(arr[right]))
				right--;
			
			if(arr[left]!=arr[right])
				return false;
			
			left++;
			right--;
		}
		return true;
	}

}
