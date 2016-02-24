import java.util.Scanner;
import java.lang.System;
import java.util.ArrayList;

public class FindMinimum {
  
  private ArrayList<Integer> numsList = new ArrayList<Integer>();
// избегай статичных методов
// основная идея задачи была написать методы
// findMin(int first, int second)
// findMin(int first, int second, int third)
// и реализовать их друг через друга (основы overload)
// круто, что использовал varargs (зря только в Integer сконвертил лишние операции)
  public static int findMin(Integer ... nums) {
      int min = nums[0]; // вот тут unboxing (автоматическая операция по конвертации объекту Integer в примитив int)
      for(int i = 0; i < nums.length; i++) {
          if (min > nums[i] // здесь тоже) {
            min = nums[i]// и тут :);
          }
      }
      return min;
  }

  private static void testFindMin() {
     System.out.println("\nTesting findMin method: ");
     System.out.println("min(0) = " + findMin(0));
     System.out.println("min(4,2) = " + findMin(4,2));
     System.out.println("min(8,2, -1) = " + findMin(8,2,-1));
     System.out.println("min(4364,45, 0, -55) = " + findMin(4364,45, 0, -55) + "\n");
  }

  public void requestUserInput() {
       Scanner sc = new Scanner(System.in);
       System.out.println("Please enter integer numbers.");
       System.out.println("To finish your input please enter any character and press Enter:");
       while (sc.hasNextInt()) {
            numsList.add(sc.nextInt());
       }
       // sanity check
       if (numsList.size() == 0) {
         System.out.println("You didn't enter any integer numbers, try again\n");
         requestUserInput();
       } else {
         Integer[] nums = new Integer[numsList.size()];
         nums = numsList.toArray(nums);

         System.out.println("min(" + java.util.Arrays.toString(nums) + ") = "
                + findMin(nums));
       }
  }
  
  public static void main(String[] args) {
      System.out.println("SERACNING THE LOWEST VALUE IN A GIVEN LIST OF INTEGERS");
      System.out.println("-------------------------------------------------------");

      FindMinimum fm = new FindMinimum();
      testFindMin();
      fm.requestUserInput();
  }
}