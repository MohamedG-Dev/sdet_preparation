package prep.day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayVsArrayList {

	public static void main(String[] args) {
		// Array Creation
		int numbers[] = new int[10];
		numbers[0]=10;
		numbers[1]=20;
		numbers[2]=30;
		numbers[3]=40;
		numbers[4]=50;
		numbers[5]=60;
		numbers[6]=70;
		numbers[7]=80;
		numbers[8]=90;
		numbers[9]=100;
		System.out.println(Arrays.toString(numbers));
		System.out.println(numbers[5]);
		System.out.println("Array length: "+numbers.length);
		//List/Array List creation
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		arrayList.add(50);
		arrayList.add(60);
		arrayList.add(70);
		arrayList.add(80);
		arrayList.add(90);
		arrayList.add(60);
		arrayList.add(100);
		arrayList.add(110);
		System.out.println(arrayList);
		System.out.println(arrayList.get(5));
		arrayList.add(1,55);
		System.out.println(arrayList);
		arrayList.remove(0);
		System.out.println(arrayList);
		arrayList.add(1,33);
		System.out.println(arrayList);
		System.out.println(arrayList.size());
		arrayList.set(0, 99);
		System.out.println(arrayList);
		arrayList.remove(new Integer(50));//takes an integer object and it removes first occurrence of 50
		System.out.println(arrayList);
		System.out.println(arrayList.isEmpty());//false
		System.out.println(arrayList.indexOf(new Integer(60)));//5
		System.out.println(arrayList.lastIndexOf(new Integer(60)));//99
		System.out.println(arrayList.lastIndexOf(90));//8
		//sorting
		Collections.sort(arrayList);
		System.out.println(arrayList);
		Collections.reverse(arrayList);//it just reverses the list and doesn't sorts the list
		System.out.println(arrayList);
	}

}
