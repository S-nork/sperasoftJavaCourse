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
      // generating an array of random int of size n
      generatedArray = generateRandomArrayOfInt(n);
      System.out.println("\nGenerated Array: " + java.util.Arrays.toString(generatedArray));
  }

  public int[] generateRandomArrayOfInt(int size) {
      int[] resultingArray = new int[size];

      Random randomGenerator = new Random();  // a single Random object is reused
      for (int j = 0; j < size; j++) {
          int randomInt = randomGenerator.nextInt(n);
          resultingArray[j] = randomInt;
      }

      return resultingArray;
  }

  private void searchOneByOne() {
      for (int j = 0; j < generatedArray.length; j++) {
          if (generatedArray[j] == i) {
            System.out.println("\nManage to find " + i + " in the array: TRUE");
            return;
          }
      }
      System.out.println("\nCan't find " + i + " in the array: FALSE");
      return;
  }
  
  public static int requestUserInput(String msg) {
       int n = 0;
       Scanner sc = new Scanner(System.in);
       System.out.print(msg);
       try {
          n = sc.nextInt();
       } catch (InputMismatchException ex) {
          System.err.println("You've entered not an integer number. Try again...");
          requestUserInput(msg);
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
        System.out.print("\nError: Size of an error can't be less or equal to zero, please enter a valid array size\n");
        n = requestUserInput("Please enter size of an array to generate as an integer number: ");
    }
    // Creating an instance of a class by invoking Constructor
    ArraySearch arrS = new ArraySearch(n, i);

    long startTime = System.currentTimeMillis();
    arrS.searchOneByOne();
    long stopTime = System.currentTimeMillis();
    System.out.print("Execution time of regular One by One Search (ms): " +elapsedTime(startTime, stopTime));
  }
}