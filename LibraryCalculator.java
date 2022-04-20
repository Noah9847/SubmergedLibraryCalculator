import java.util.Scanner;

public class LibraryCalculator {

    String[][] library = {{"r", "b", "y", "y", "y", "b"}, 
                          {"b", "b", "y", "g", "b", "b"}, 
                          {"b", "b", "y", "r", "b", "y"},
                          {"y", "g", "b", "r", "g", "r"}};
    
    


    public static void main (String args[]){

        Scanner scanner = new Scanner(System.in);
        System.out.println("test");
        System.out.println("Initialized. The following print statements will tell you what to enter. When it says to enter the door, enter the color of the door as r, b, y, or g depending on the color of the door. If there is no floor above you when it prompts you to, enter n.");
        System.out.println();
        System.out.println("Enter first door that is the floor above you and to the left");
        String leftDoorTop = scanner.nextLine();
        System.out.println("Enter the second door that is the floor above you in the middle");
        String middleDoorTop = scanner.nextLine();
        System.out.println("Enter the third door that is the floor above you and to the right");
        String rightDoorTop = scanner.nextLine();

    }

}