import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Setting up the front-end of the application */
		System.out.println("Welcome to this sorting algorithm application.");
		System.out.println("The application itself will allow you an unsorted array using on of the following sorting algorithms: ");
		System.out.println("MergeSort, BubbleSort, Insertion Sort and Selection Sort");
		System.out.println("I hope you will enjoy this application of mine!");
		System.out.println("Have fun while sorting and enjoy! :)");
		System.out.println(" ");
		System.out.println("Please select what you want to do?");
		
		/* Creating an infinite loop so you can spam different commands */
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				String option = scan.nextLine();
				new SortingAlgorithm(option);
			}catch(InputMismatchException e) {
				System.out.println("Input mismatch, maybe check the type of the values you are entering. :)");
			}
		}
	}

}
