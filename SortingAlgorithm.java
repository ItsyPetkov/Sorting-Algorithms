import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortingAlgorithm {

	private int[] arr;
	
	/* Creating the constructor which links the front-end and the back-end */
	public SortingAlgorithm(String option) {
		switch(option) {
			case "mergeSort":
				arr = createArray();
				arr = randomizeArray(arr);
				mergeSort(arr);
			break;
			case "insertionSort":
				arr = createArray();
				arr = randomizeArray(arr);
				insertionSort(arr);
			break;
			case "bubbleSort":
				arr = createArray();
				arr = randomizeArray(arr);
				bubbleSort(arr);
			break;
			case "selectionSort":
				arr = createArray();
				arr = randomizeArray(arr);
				selectionSort(arr);
			break;
			case "sort":
				arr = createArray();
				arr = randomizeArray(arr);
				sort(arr);
			break;
			case "exit":
				System.exit(0);
			break;
			default:
				System.out.println("Unknown command, please try again!");
			break;
		}
	}
	
	/* Creating the array */
	private int[] createArray() {
		
		/* Prompting the user for the length of the array */
		System.out.println("Please select a size for the array.");
		System.out.println("Note: The size is limited to 10");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		if(length <= 2 || length > 10) {
			System.out.println("The size of the Array must be at least 3 and at most 10");
			return null;
		}else {
			/* Declaring the array with size equal to the input the user has given. */
			arr = new int[length];
			
			/* Filling the array */
			for(int i = 0; i < length; i++) {
				arr[i] = i + 1;
			}
		}
		return arr;
	}
	
	/* Shuffling the array randomly */
	private int[] randomizeArray(int[] arr) {
		
		/* Creating a random number */
		Random rnd = new Random();
		for (int i = arr.length - 1; i > 0; i--){
			int index = rnd.nextInt(i + 1);
			
		    /* Randomly swapping contents of the array */
		    int a = arr[index];
		    arr[index] = arr[i];
		    arr[i] = a;
		}
		
		return arr;
	}
	
	/* Performing Bubble Sort on an unsorted Array */
	private void bubbleSort(int[] arr) {
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		/* Looping through all the elements of the array */
		for(int i = 0; i < arr.length; i++) {
			for(int  j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j + 1]) {
					
					/* Swapping the positions of the elements in the current pair */
					int temp = arr[j];
					arr[j] =  arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
	private int[] mergeSort(int[] arr) {
		
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		/* Creating a base case for the recursive method */
		if(arr.length <= 1) {
			return arr;
		}else {
			
			/* Dividing the initial array in two roughly equal halves */
			int middle = arr.length/2;
			
			
			/* Initialising the two sub-arrays */
			int[] left = new int[middle];
			int[] right;
			if(arr.length % 2 == 0) {
				right = new int[middle];
			}else {
				right = new int[middle + 1];
			}
			
			/* Populating the left array */
			for(int i = 0; i < middle; i++) {
				left[i] = arr[i];
			}
			
			/* Populating the right array */
			for(int i = 0 ; i < right.length; i++) {
				right[i] = arr[middle + i];
			}
			
			int[] result = new int[arr.length];
			
			/* Performing mergeSort recursively */
			left = mergeSort(left);
			right = mergeSort(right);
			
			/* Merging everything back into the initial array */
			result = merge(left,right);
			
			System.out.println("Current Array: " + Arrays.toString(result));
			return result;
		}
	}
	
	private int[] merge(int[] left, int[] right) {
		
		/* Initialising the array which will hold the left and the right array */
		int[] result = new int[left.length + right.length];
		
		/* Initialising pointers for all the arrays */
		int leftPointer = 0;
		int rightPointer = 0;
		int resultPointer = 0;
		
		/* While there elements either in the left or right array, then we merge */
		while(leftPointer < left.length || rightPointer < right.length) {
			
			/* Check if there are elements in both the left and the right array */
			if(leftPointer < left.length && rightPointer < right.length) {
				
				/* Comparing the left array with the right array */
				if(left[leftPointer] < right[rightPointer]) {
					result[resultPointer++] = left[leftPointer++];
				}else {
					result[resultPointer++] = right[rightPointer++];
				}
			}
			
			/* If there are only elements in left array */
			else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}
			
			/* If there are only elements in the right array */
			else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		
		return result;
	}
	
	/* Sorting the array the good'ol fashioned way using the Arrays.sort() method */
	private void sort(int[] arr) {
		System.out.println("Initial Array: " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
	private void insertionSort(int[] arr) {
		
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		/* Create a variable to store the length of the current array */
		int n = arr.length;
		
		/* Loop through all of the elements in the array starting form the second position */
		for(int i = 1; i < n; i++) {
			
			/* The current number to be inserted */
			int current = arr[i];
			
			/* Start comparing with the cell left of i */
			int j = i - 1;
			
			/* while a[j] is out of order with current */
			while((j >= 0) && (arr[j] > current)) {
				/* Move a[j] one position to the right */
				arr[j + 1] = arr[j];
				
				/* Decrement j */
				j = j - 1;
			}
			
			/* This is the proper place for current */
			arr[j + 1] = current;
		}
		
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
	private void selectionSort(int[] arr) {
		
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		int minValue = 0;
		int minIndex = 0;
		
		/* Looping through all the elements */
		for(int i = 0; i < arr.length; i++) {
			
			/* Setting minValue to the first unsorted item of the list and minIndex to the first unsorted index */
			minValue = arr[i];
			minIndex = i;
			
			 /* The inner for loop start at the first unsorted item and it continues through to the last item in the list */
			for(int j = i; j < arr.length; j++) {
				
				/* Doing necessary check so we keep track of the minValue */
				if(arr[j] < minValue) {
					minValue = arr[j];
					minIndex = j;
				}
			}
			
			/* Check if the minValue was the first value or not. */
			if(minValue < arr[i]) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
}
