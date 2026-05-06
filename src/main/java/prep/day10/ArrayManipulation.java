package prep.day10;

import java.util.Arrays;

public class ArrayManipulation {
	public static void main(String[] args) {
		String[] arr = {"Anindita","is","in","the","interview"};
		System.out.println(Arrays.toString(arr));
		int left=1;
		int right=arr.length-2;
		while(left<right) {
			String temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		System.out.println(Arrays.toString(arr));
	}

}
