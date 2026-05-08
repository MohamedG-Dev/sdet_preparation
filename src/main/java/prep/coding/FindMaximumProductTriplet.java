package prep.coding;

import java.util.Arrays;

public class FindMaximumProductTriplet {

	public static void main(String[] args) {
		int[] arr = { -10, -3, 5, 6, -20 };
		int[] arr1 = arr;
		System.out.println(firstWay(arr));
		System.out.println(optimizedWay(arr1));

	}

	public static int firstWay(int[] arr) {
		if (arr.length < 3) {
			System.out.println("elements count less than 3");
			System.exit(0);
		}
		int length = arr.length;
		Arrays.sort(arr);
		int result1 = arr[length - 1] * arr[length - 2] * arr[length - 3];
		int result2 = arr[0] * arr[1] * arr[length - 1];
		return Math.max(result1, result2);
	}

	public static int optimizedWay(int[] arr) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		for (int num : arr) {
			if (num > max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			}else if(num > max2) {
				max3=max2;
				max2=num;
			}else if(num > max3) {
				max3=num;
			}
			//calculate min values
			if(num<min1) {
				min2=min1;
				min1=num;
			}else if(num<min2) {
				min2 = num;
			}
		}
		int result1 = max1 * max2 * max3;
		int result2 = min1 * min2 * max1;
		return Math.max(result1, result2);
	}

}
