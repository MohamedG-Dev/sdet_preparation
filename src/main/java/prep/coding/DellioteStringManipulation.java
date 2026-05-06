package prep.coding;

/*
 * input = Java Test
 * output = avaJ tseT
 */
public class DellioteStringManipulation {
	public static void main(String[] args) {
		String input = "Java Test";
		String[] strarr = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for(String str : strarr) {
			char[] arr = str.toCharArray();
			int left=0;
			int right=arr.length-1;
			while(left<right) {
				char temp=arr[left];
				arr[left]=arr[right];
				arr[right]=temp;
				left++;
				right--;
			}
			sb.append(arr).append(" ");
		}
		System.out.println(sb.toString().trim());
	}

}
