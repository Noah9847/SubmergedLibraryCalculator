import java.util.Scanner;

public class LibraryCalculator {

    String leftDoorTop;
    String middleDoorTop;
    String rightDoorTop;
    String leftDoor;
    String middleDoor;
    String rightDoor;

    String[][] library = {{"r", "b", "y", "y", "y", "b"}, 
                          {"b", "b", "y", "g", "b", "b"}, 
                          {"b", "b", "y", "r", "b", "y"},
                          {"y", "g", "b", "r", "g", "r"}};

    public LibraryCalculator(String leftDoorTop, String middleDoorTop, String rightDoorTop, String leftDoor, String middleDoor, String rightDoor){
        this.leftDoorTop = leftDoorTop;
        this.middleDoorTop = middleDoorTop;
        this.rightDoorTop = rightDoorTop;
        this.leftDoor = leftDoor;
        this.middleDoor = middleDoor;
        this.rightDoor = rightDoor;
    }
    
    public int[] doorFinder(){

        int topRow = 0;
        boolean foundTheDoor = false;
        int[] answer = new int[2];

        for (int i = 0; i < library.length - 1; i++){
            System.out.println("1st for loop started");
            for (int j = 0; j < 4; j++){
               // System.out.println("2nd for loop started");
               // System.out.println(library[i][j] + " " + leftDoorTop);
               // System.out.println(library[i][j+1] + " " + middleDoorTop);
               // System.out.println(library[i][j+2] + " " + rightDoorTop);
               System.out.println(library[i][j].equals(leftDoorTop));
              if (library[i][j] == leftDoorTop && library[i][j+1] == middleDoorTop && library[i][j+2] == rightDoorTop) {
                System.out.println(library[i][j+1]);
                System.out.println(i);
                i = topRow;
                // break;
                for (int a = i + 1; a < library.length - i + 1; a++){
                    for (int b = 0; b < 4; b++){
                        if (library[a][b] == leftDoor && library[a][b+1] == middleDoor && library[a][b+2] == rightDoor){
                            System.out.println(library[a][b+1]);
                            System.out.println(a);
                            System.out.println("Found both doors");
                            answer[0] = a;
                            answer[1] = b + 1;
                            foundTheDoor = true;
                            break;
                        }
                    }
                    if (foundTheDoor == true){
                        break;
                    }
                }
              }
              if (foundTheDoor == true){
                  break;
              }
            }
            if (foundTheDoor == true){
                break;
            }
        }
        return answer;
    }

    public static void main (String args[]){

        LibraryCalculator calculator = new LibraryCalculator("", "", "", "", "", "");
        Scanner scanner = new Scanner(System.in);
        System.out.println("test");
        System.out.println("Initialized. The following print statements will tell you what to enter. When it says to enter the door, enter the color of the door as r, b, y, or g depending on the color of the door. If there is no floor above you when it prompts you to, enter n.");
        System.out.println();
        System.out.println("Enter first door that is the floor above you and to the left");
        calculator.leftDoorTop = scanner.nextLine();
        // System.out.println(calculator.doorFinder());
        System.out.println("Enter the second door that is the floor above you in the middle");
        calculator.middleDoorTop = scanner.nextLine();
        System.out.println("Enter the third door that is the floor above you and to the right");
        calculator.rightDoorTop = scanner.nextLine();

        System.out.println("Enter the first door that is on your floor and to the left");
        calculator.leftDoor = scanner.nextLine();
        System.out.println("Enter the second door that is on your floor and in the middle");
        calculator.middleDoor = scanner.nextLine();
        System.out.println("Enter the third door that is on your floor and to the right");
        calculator.rightDoor = scanner.nextLine();

        int[] answer = calculator.doorFinder();
        System.out.println(answer[0] + " " + answer[1]);

        scanner.close();



    }

}