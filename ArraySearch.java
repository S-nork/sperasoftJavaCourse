import java.lang.System;
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class ArraySearch {

  private int n;  // array size
  private int i;  // number to search in the array
  private int[] generatedArray;

  // Constructor
  public ArraySearch(int n, int i) {
      this.n = n;
      this.i = i;
      // generating an array of random ints of size n
      generatedArray = generateRandomArrayOfInt(n);
      System.out.println("\nGenerated Array: " + java.util.Arrays.toString(generatedArray));
  }

  private int[] generateRandomArrayOfInt(int size) {
      int[] resultingArray = new int[size];

      Random randomGenerator = new Random();  // a single Random object is reused
      for (int j = 0; j < size; j++) {
          int randomInt = randomGenerator.nextInt(n);
          resultingArray[j] = randomInt;
      }

      return resultingArray;
  }

  private int searchOneByOne() {
      for (int j = 0; j < generatedArray.length; j++) {
          if (generatedArray[j] == i) { // i is an class instance variable, a number to search in the array
            return j;
          }
      }
      return -1; // element is not found
  }

  private int binarySearch() {
    int start = 0;
    int end = generatedArray.length - 1;
    while (start <= end) {
      int mid = (start + end)/2;
      if (generatedArray[mid] == i) { // i is an class instance variable, a number to search in the array
        return mid;
      } else if (i < generatedArray[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }
    return -1; // element is not found
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

  public static long elapsedTime(long startTime, long stopTime) {
    return stopTime - startTime;
  }

  public static void main(String[] args) {
    int n = requestUserInput("Please enter size of an array to generate as an integer number: ");
    int i = requestUserInput("Please enter a number to search in the array as an integer: ");
    // sanity check
    while (n <= 0) {
        System.out.print("\nError: Size of an array can't be less or equal to zero, please enter a valid array size\n");
        n = requestUserInput("Please enter size of an array to generate as an integer number: ");
    }
    // Creating an instance of a class by invoking Constructor
    ArraySearch arrS = new ArraySearch(n, i);
    int foundIndex = -2;
    
    // Linear Search
    long startTime = System.nanoTime();
    foundIndex = arrS.searchOneByOne();
    long stopTime = System.nanoTime();
    long oneByOneSearchExecutionTime = elapsedTime(startTime, stopTime);
    if (foundIndex != -1 && foundIndex > 0) {
      System.out.println("\nTRUE - managed to find \"" + i + "\" in the array with index " + foundIndex + "\n");
    } else {
      System.out.println("\nFALSE - element is not found\n");
    }
    System.out.print("Execution time of Linear Search (nanoseconds): " + oneByOneSearchExecutionTime + "\n");

    // Binary Search
    // sorting the array
    java.util.Arrays.sort(arrS.generatedArray);
    System.out.println("\nSorted Array: " + java.util.Arrays.toString(arrS.generatedArray));
    startTime = System.nanoTime();
    foundIndex = arrS.binarySearch();
    stopTime = System.nanoTime();
    long binarySearchExecutionTime = elapsedTime(startTime, stopTime);
    if (foundIndex != -1 && foundIndex > 0) {
      System.out.println("\nTRUE - managed to find \"" + i + "\" in the array with index " + foundIndex + "\n");
    } else {
      System.out.println("\nFALSE - element is not found\n");
    }
    System.out.println("Execution time of Binary Search (nanoseconds): " + binarySearchExecutionTime);

    System.out.println("\nBinary search is faster on " + (binarySearchExecutionTime/oneByOneSearchExecutionTime)*100 + "% in comparison to Linear Search");
  }
}