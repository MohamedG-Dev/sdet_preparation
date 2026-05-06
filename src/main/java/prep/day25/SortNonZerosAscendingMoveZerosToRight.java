package prep.day25;

import java.util.Arrays;

public class SortNonZerosAscendingMoveZerosToRight {

	public static void main(String[] args) {
		//int[] arr = { 1, 3, 0, 4, 5, 0, 2, 0 };
		int[] arr = { 1, 3, 0, 4, 5, 0, 2, 0 ,6,7,0,0,8,9};
		System.out.println(Arrays.toString(arr));
		int index = 0;
		for (int num : arr) {
			if (num != 0) {
				arr[index] = num;
				index++;
			}
		}
		for (int i = index; i < arr.length; i++) {
			arr[i] = 0;
		}

		Arrays.sort(arr, 0, index);

		System.out.println(Arrays.toString(arr));

	}

}
