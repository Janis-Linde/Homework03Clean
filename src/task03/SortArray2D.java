package task03;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortArray2D {
	
	//---- method for calculating average of an array
	public static double arrAvg (int[] arr){
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		double avg = sum/arr.length;
		return avg;
	}
	
	public static void main(String[] args) {
		//input
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of arrays in the range of 10 - 20 you want to generate: ");
		int generatedArr = scanner.nextInt();
		
		while (generatedArr < 10 || generatedArr > 20){
			System.out.println("Keep in the range of 10 - 20: ");
			generatedArr = scanner.nextInt();
		}
		scanner.close();
		
		//processing
		//----- create initial 2D array
		int[][] arr2D = new int[generatedArr][];
		
		//---- create random sized arrays
		Random random = new Random();

		for (int i = 0; i < generatedArr; i++){
			int rnd = random.nextInt(41)+10;
			arr2D[i] = new int [rnd];
			
			for (int j = 0; j < arr2D[i].length; j++ ){
				int rnd2 = random.nextInt(900)+100;
				arr2D[i][j] = rnd2;
			}
		}
		
		//---- sort array elements in descending order
		for (int i = 0; i < arr2D.length; i++) {
			while (true) {
				boolean done = true;
				for (int j = 0; j < arr2D[i].length - 1; j++) {
					int temp = arr2D[i][j];
					if (temp < arr2D[i][j + 1]) {
						arr2D[i][j] = arr2D[i][j + 1];
						arr2D[i][j + 1] = temp;
						done = false;
					}
				}
				if (done) {
					break;
				}
			}
		}
		
		//---- create temp array for sorting purposes
		double[] tempArr = new double[arr2D.length];
		for (int i = 0; i < arr2D.length; i++){
			tempArr[i] = arrAvg (arr2D[i]);	
		}
		
		//---- sort arrays in ascending order
		while (true){
			boolean done = true;
			for (int i = 0; i < tempArr.length-1; i++){
				double temp = tempArr[i];
				int[] temp2D = arr2D[i];
				
				if (temp > tempArr[i+1]){
					tempArr[i] = tempArr[i+1];
					tempArr[i+1] = temp;
					
					arr2D[i] = arr2D[i+1];
					arr2D[i+1] = temp2D;
					
					done = false;
				}
			}
			if(done){
				break;
			}
		}
		
		//output - the last array in ascending list
		System.out.println(Arrays.toString(arr2D[arr2D.length-1]));
	}
}
