package task02;

import java.util.Scanner;

public class PrimeGenerator {
	// method for calculating a prime
	public static boolean isPrime(int number){
		int breakPoint = 0;
		for (int i = 2; i <= number/3; i++){
			if (number % i == 0 ){
				breakPoint++;
				break;
			}
		}
		if (breakPoint == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		//input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the number of primes you wish to print in the range of 1 - 100: ");
		int counterLimit = scanner.nextInt();
		while (counterLimit < 1 || counterLimit > 100){
			System.out.println("Please stick to the range of 1 - 100");
			counterLimit = scanner.nextInt();
		}
		scanner.close();
		
		//processing and output
		int counter = 0;
		String primeList = "2";
		if (counterLimit == 1) {
			System.out.println(primeList);
		} else {
			for (int i = 3; true; i += 2) {
				if (isPrime(i)) {
					primeList = primeList + ", " + i;
					counter++;
				}
				if (counter == counterLimit - 1) {
					break;
				}
			}
			System.out.println(primeList);
		}
	}
}
