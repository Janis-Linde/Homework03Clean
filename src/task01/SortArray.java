package task01;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {
		//input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the size of array in the range of 20 to 40: ");
		int arraySize = scanner.nextInt();
		while (arraySize < 20 || arraySize > 40){
			System.out.println("Keep the range in 20 to 40: ");
			arraySize = scanner.nextInt();
		}
		scanner.close();
		
		//processing and output
		int[] arr = new int[arraySize];
		for (int i = 0; i < arraySize; i++){
			arr[i] = (int) (Math.random()*90 + 10);
		}
		System.out.println(Arrays.toString(arr).substring(1,Arrays.toString(arr).length()-1));
		
		
		while (true) {
			boolean done = true;
			for (int i = 0; i < arraySize - 1; i++) {
				int first = arr[i];
				int second = arr[i + 1];
				if (first > second) {
					arr[i] = second;
					arr[i + 1] = first;
					done = false;
				}
			}
			if (done) {
				break;
			}
		}
		
		System.out.println(Arrays.toString(arr).substring(1,Arrays.toString(arr).length()-1));

	}

}
