import java.util.Scanner;

public class LibraryCalculator {

    String leftDoorTop;
    String middleDoorTop;
    String rightDoorTop;
    String leftDoor;
    String middleDoor;
    String rightDoor;
    String floorThereString;
    boolean floorThere;
    int[] answer;

    String[][] library = {{"n", "r", "b", "y", "y", "y", "b", "n"}, 
                          {"n", "b", "b", "y", "g", "b", "b", "n"}, 
                          {"n", "b", "b", "y", "r", "b", "y", "n"},
                          {"n", "y", "g", "b", "r", "g", "r", "n"}};

    public LibraryCalculator(String leftDoorTop, String middleDoorTop, String rightDoorTop, String leftDoor, String middleDoor, String rightDoor, boolean floorThere){
        this.leftDoorTop = leftDoorTop;
        this.middleDoorTop = middleDoorTop;
        this.rightDoorTop = rightDoorTop;
        this.leftDoor = leftDoor;
        this.middleDoor = middleDoor;
        this.rightDoor = rightDoor;
        this.floorThere = floorThere;
        // this.answer = answer;
    }

    public void instructionOutput(){
        // System.out.println(answer[0] + " " + answer[1]);
        if (answer[1] == 1){
            System.out.println("first door down (from left)");
        }
        else if (answer[1] == 2){
            System.out.println("second door down (from left)");
        }
        else if (answer[1] == 3){
            System.out.println("third door down (from left)");
        }
        else if (answer[1] == 4){
            System.out.println("fourth door down (from left)");
        }
        else if (answer [1] == 5){
            System.out.println("fifth door down (from left)");
        }
        else if (answer[1] == 6){
            System.out.println("sixth door down (from left)");
        }
    }
    
    public int[] doorFinder(){

        int topRow = 0;
        boolean foundTheDoor = false;
        int[] answer = new int[2];
        int sum = 0;
        // System.out.println(answer[0] + " " + answer[1]);

        for (int i = 0; i < library.length; i++){
            // System.out.println("1st for loop started");
            for (int j = 0; j < 6; j++){
               // System.out.println("2nd for loop started");
               // System.out.println(library[i][j] + " " + leftDoorTop);
               // System.out.println(library[i][j+1] + " " + middleDoorTop);
               // System.out.println(library[i][j+2] + " " + rightDoorTop);
               // System.out.println(library[i][j].equals(leftDoorTop));
              if (library[i][j].equals(leftDoorTop) && library[i][j+1].equals(middleDoorTop) && library[i][j+2].equals(rightDoorTop)) {
                System.out.println(library[i][j]);
                System.out.println(library[i][j+1]);
                System.out.println(library[i][j+2]);
                System.out.println(i);
                // System.out.println(i);
                topRow = i;
                if (floorThere == false){
                    answer[0] = i;
                    answer[1] = j + 1; 
                    foundTheDoor = true;
                    break;
                }
                // break;
                for (int a = i + 1; a < library.length; a++){
                    sum = i + 1;
                    System.out.println(i);
                    System.out.println(a + " " + sum);
                    for (int b = 0; b < 6; b++){
                        if (library[a][b].equals(leftDoor) && library[a][b+1].equals(middleDoor) && library[a][b+2].equals(rightDoor)){
                            System.out.println(library[a][b]);
                            System.out.println(library[a][b+1]);
                            System.out.println(library[a][b+2]);
                            System.out.println(a);
                            // System.out.println(a);
                            // System.out.println("Found both doors");
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

        LibraryCalculator calculator = new LibraryCalculator("", "", "", "", "", "", true);
        Scanner scanner = new Scanner(System.in);
        // System.out.println("test");
        System.out.println("Initialized. The following print statements will tell you what to enter. When it says to enter the door, enter the color of the door as r, b, y, or g depending on the color of the door. If there is no door to the left or right of you, press n");
        System.out.println();
        System.out.println("Is there a floor above you? If yes, enter true. If no, enter false");
        calculator.floorThereString = scanner.nextLine();
        if (calculator.floorThereString.equals("yes") || calculator.floorThereString.equals("Yes")){
            calculator.floorThere = true;
        }
        else if (calculator.floorThereString.equals("no") || calculator.floorThereString.equals("No")){
            calculator.floorThere = false;
        }
        // calculator.floorThere = scanner.nextBoolean();
        // System.out.println(calculator.floorThere);
        if (calculator.floorThere == true){
        System.out.println("Enter first door that is the floor above you and to the left");
        // calculator.leftDoorTop = scanner.nextLine();
        // System.out.println(calculator.leftDoorTop);
        calculator.leftDoorTop = scanner.nextLine();
        /*if (calculator.leftDoorTop != "r" || calculator.leftDoorTop != "y" || calculator.leftDoorTop != "g" || calculator.leftDoorTop != "b"){
            System.out.println("Invalid input entered. Shutting down. Please try again");
            scanner.close();
        } */
        // System.out.println(calculator.leftDoorTop);
        // System.out.println(calculator.doorFinder());
        System.out.println("Enter the second door that is the floor above you in the middle");
        calculator.middleDoorTop = scanner.nextLine();
        // System.out.println(calculator.middleDoorTop);
        System.out.println("Enter the third door that is the floor above you and to the right");
        calculator.rightDoorTop = scanner.nextLine();
        }
        System.out.println("Enter the first door that is on your floor and to the left");
        calculator.leftDoor = scanner.nextLine();
        if (calculator.floorThere == false){
            calculator.leftDoor = scanner.nextLine();
        }
        System.out.println("Enter the second door that is on your floor and in the middle");
        calculator.middleDoor = scanner.nextLine();
        System.out.println("Enter the third door that is on your floor and to the right");
        calculator.rightDoor = scanner.nextLine();
        if (calculator.floorThere == false){
            calculator.leftDoorTop = calculator.leftDoor;
            calculator.middleDoorTop = calculator.middleDoor;
            calculator.rightDoorTop = calculator.rightDoor;
        }
        
        int[] answer = calculator.doorFinder();
        calculator.answer = answer;

        System.out.println();

        if (answer[0] == 0){
            System.out.print("Top level, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 1){
            System.out.print("second level down from top, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 2){
            System.out.print("third level down from the top, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 3){
            System.out.print("bottom level, ");
            calculator.instructionOutput();
        }

        System.out.println("The door color is " + calculator.library[answer[0]][answer[1]]);

        scanner.close();



    }

}