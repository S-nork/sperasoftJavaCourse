import java.lang.System;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class ArraySort {
  
  private int n;  // array size
  private int[] generatedArray;
  
  // Constructor
  public ArraySort(int n) {
      this.n = n;
      // generating an array of random ints of size n
      generatedArray = generateRandomArrayOfInt(n);
      System.out.println("\nGenerated Array: \n" + java.util.Arrays.toString(generatedArray));
  }

  private int[] generateRandomArrayOfInt(int size) {
      int[] resultingArray = new int[size];

      Random randomGenerator = new Random();  // a single Random object is reused
      for (int j = 0; j < size; j++) {
          int randomInt = randomGenerator.nextInt(n + n);
          resultingArray[j] = randomInt;
      }

      return resultingArray;
  }

  private static int requestUserInput(String msg) {
       int n = 0;
       Scanner sc = new Scanner(System.in);
       System.out.print(msg);
       try {
          n = sc.nextInt();
       } catch (InputMismatchException ex) {
          System.err.println("You've entered not an integer number. Try again...");
          n = requestUserInput(msg);
       }
       return n;
  }

  public static int[] selectionSort(int[] unsortedArray) {
       int iMin; // index of the minimum element in the array
       for (int i = 0; i < unsortedArray.length - 1; i++) {
          iMin = i; // assuming the first element to be the minimum
          // Scanning elements after i to find the smallest of them 
          for (int j = i+1; j < unsortedArray.length; j++) {
            // if we've found a new minimum
            if (unsortedArray[j] < unsortedArray[iMin]) {
              iMin = j; // updating the index of the minimum
            }
          } // for(j)
          // rearranging the elements and setting a new minimum
          int temp = unsortedArray[i];
          unsortedArray[i] = unsortedArray[iMin];
          unsortedArray[iMin] = temp;
       } // for(i)
       return unsortedArray; // the array is sorted at this point
  }

  public static int[] unoptimizedBubbleSort(int[] unsortedArray) {
      for (int k = 0; k < unsortedArray.length - 1; k++) {
        for (int i = 0; i < unsortedArray.length - 2; i++) {
          if (unsortedArray[i] > unsortedArray[i+1]) {
            // swapping the elements
            int temp = unsortedArray[i+1];
            unsortedArray[i+1] = unsortedArray[i];
            unsortedArray[i] = temp;
          }
        } // for(i)
      } // for(k)
      return unsortedArray; // the array is sorted at this point
  }

  public static int[] optimizedBubbleSort(int[] unsortedArray) {
      for (int k = 0; k < unsortedArray.length - 1; k++) {
        int flag = 0;
        for (int i = 0; i < unsortedArray.length - k - 1; i++) {
          if (unsortedArray[i] > unsortedArray[i+1]) {
            // swapping the elements
            int temp = unsortedArray[i+1];
            unsortedArray[i+1] = unsortedArray[i];
            unsortedArray[i] = temp;
            flag = 1;
          }
        } // for(i)
        if (flag == 0) {
          break;
        }
      } // for(k)
      return unsortedArray; // the array is sorted at this point
  }

  public static int[] insertionSort(int[] unsortedArray) {
      for (int i = 0; i < unsortedArray.length - 1; i++) {
        int value = unsortedArray[i];
        int hole = i;
        while (hole > 0 && unsortedArray[hole-1] > value) {
          unsortedArray[hole] = unsortedArray[hole - 1];
          hole -= 1;
        } // while
        unsortedArray[hole] = value;
      } // for(i)
      return unsortedArray; // the array is sorted at this point
  }

  public static long elapsedTime(long startTime, long stopTime) {
    return stopTime - startTime;
  }

  public static void main(String[] args) {
      int n = requestUserInput("Please enter size of an array to generate as an integer number: ");
      // sanity check
      while (n <= 0) {
          System.out.print("\nError: Size of an array can't be less or equal to zero, please enter a valid array size\n");
          n = requestUserInput("Please enter size of an array to generate as an integer number: ");
    }
    ArraySort arrSort = new ArraySort(n);

    // Selection sort
    long startTime = System.nanoTime();
    System.out.println("\nSorted Array (Selection Sort): \n" 
        + java.util.Arrays.toString(arrSort.selectionSort(arrSort.generatedArray)) + "\n");
    long stopTime = System.nanoTime();
    System.out.print("Execution time of Selection Sort (nanoseconds): " + elapsedTime(startTime, stopTime) + "\n");

    // Unoptimized Bubble sort
    startTime = System.nanoTime();
    System.out.println("\nSorted Array (Unoptimized Bubble Sort): \n" 
        + java.util.Arrays.toString(arrSort.unoptimizedBubbleSort(arrSort.generatedArray)) + "\n");
    stopTime = System.nanoTime();
    System.out.print("Execution time of Unoptimized Bubble Sort (nanoseconds): " + elapsedTime(startTime, stopTime) + "\n");

    // Optimized Bubble sort
    startTime = System.nanoTime();
    System.out.println("\nSorted Array (Optimized Bubble Sort): \n" 
        + java.util.Arrays.toString(arrSort.optimizedBubbleSort(arrSort.generatedArray)) + "\n");
    stopTime = System.nanoTime();
    System.out.print("Execution time of Optimized Bubble Sort (nanoseconds): " + elapsedTime(startTime, stopTime) + "\n");

    // Insertion sort
    startTime = System.nanoTime();
    System.out.println("\nSorted Array (Insertion sort): \n" 
        + java.util.Arrays.toString(arrSort.insertionSort(arrSort.generatedArray)) + "\n");
    stopTime = System.nanoTime();
    System.out.print("Execution time of Insertion sort (nanoseconds): " + elapsedTime(startTime, stopTime) + "\n");
  }
}