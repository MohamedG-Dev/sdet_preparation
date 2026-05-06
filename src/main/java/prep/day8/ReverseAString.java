package prep.day8;

import java.util.Arrays;

public class ReverseAString {

	public static void main(String[] args) {
		String str = "Hello";
		char[] arr = str.toCharArray();
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]);
		}
		System.out.println();
		String str1 = "Hello World";
		System.out.println(str1);
		String[] strarr = str1.split(" ");
		for(int i=0;i<strarr.length;i++) {
			char[] chararr = strarr[i].toCharArray();
			int left=0;
			int right =chararr.length-1;
			while(left<right) {
				char temp = chararr[left];
				chararr[left]=chararr[right];
				chararr[right]=temp;
				left++;
				right--;
			}
			strarr[i]=new String(chararr);
		}
		System.out.println(String.join(" ", strarr));
		
	}

}
