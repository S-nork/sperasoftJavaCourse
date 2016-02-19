import java.util.Scanner;
import java.util.InputMismatchException;

public class HanoiTower {

  public static void tower(int n, char sourceRod, char destinationRod, char auxiliaryRod) {
    // exit point
    if (n == 0) {
      return;
    }
    tower(n - 1, sourceRod, auxiliaryRod, destinationRod);
    System.out.println(n + " moved from " + sourceRod + " to " + destinationRod);
    tower(n -1, auxiliaryRod, destinationRod, sourceRod);
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

  public static void main(String[] args) {
    int n = requestUserInput("Please enter a number of disks as integer number greater than 0: ");
    // sanity check
    while (n <= 0) {
        System.out.print("\nError: Number of disks can't be less or equal to zero, please enter a valid number\n");
        n = requestUserInput("Please enter a number of disks as integer number greater than 0: ");
    }

    tower(n, 'A', 'B', 'C');
  }
}