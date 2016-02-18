import java.util.Scanner;
import java.util.InputMismatchException;

public class CountOccurences {

  private String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut in ante tortor. Phasellus imperdiet odio mauris, eget hendrerit tortor mattis at. Curabitur molestie scelerisque auctor. Etiam nulla diam, facilisis ut urna scelerisque, laoreet dapibus turpis. Maecenas iaculis pharetra imperdiet. Sed euismod tellus sit amet semper congue. Vestibulum enim elit, varius quis molestie non, vehicula nec nunc. Quisque aliquam ornare purus et ultrices. Vestibulum euismod lectus sed libero pulvinar porttitor. Sed lacus mauris, tincidunt et volutpat eu, aliquet sed felis. Vivamus auctor nisl non lorem consectetur, non mollis odio mattis. Phasellus nec tristique metus. Nullam viverra id ex sit amet tempor. Aliquam hendrerit nibh vel nisi imperdiet tristique. Morbi malesuada, nisl sed fermentum scelerisque, erat purus aliquet lorem, non vestibulum eros lectus eget velit. Aliquam ultricies magna in augue faucibus sollicitudin a et elit. Sed ornare, nisi nec congue efficitur, augue neque egestas orci, id auctor ex dolor eu neque.";
  private String symbol;

  //This class should not be instantiated
  private CountOccurences() { }

  private String requestUserInput(String msg) {
       String s = "";
       Scanner sc = new Scanner(System.in);
       System.out.print(msg);
       try {
          s = sc.nextLine();
       } catch (InputMismatchException ex) {
          System.err.println("You've entered not an integer number. Try again...");
          requestUserInput(msg);
       }
       return s.substring(0, 1);
  }

  private int countOccurences() {
      return text.length() - text.replace(symbol, "").length();
  }
    
  public static void main(String[] args) {
      CountOccurences co = new CountOccurences();
      System.out.println("\nText:\n" + co.text);
      co.symbol = co.requestUserInput("\nEnter one character to search for occurences in a text: ");
      System.out.println("Searching for - \"" + co.symbol + "\" in the text\n");      
      System.out.print("Found " + co.countOccurences() + " occurence(s) of \"" + co.symbol + "\" in the text\n");
  }
}