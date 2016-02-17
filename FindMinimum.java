public class FindMinimum {

  public static int findMin(int ... nums) {
      int min = nums[0];
      for(int i = 0; i < nums.length; i++) {
          if (min > nums[i]) {
            min = nums[i];
          }
      }
      return min;
  }
  
  public static void main(String[] args) {
      System.out.println("Finding Minimum");
      System.out.println("min(4,2) = " + findMin(4,2));
      System.out.println("min(8,2, -1) = " + findMin(8,2,-1));
      System.out.println("min(4364,45, 0, -55) = " + findMin(4364,45, 0, -55));
  }
}