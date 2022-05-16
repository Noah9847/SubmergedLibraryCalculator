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

    public void firstPrintOutput(int input, int input2) {
       
        if (input == 0){
            System.out.print("Top level, ");
            secondPrintOutput(input2);
        }
        else if (input == 1){
            System.out.print("Second level down from top, ");
            secondPrintOutput(input2);
        }
        else if (input == 2){
            System.out.print("Third level down from the top, ");
            secondPrintOutput(input2);
        }
        else if (input == 3){
            System.out.print("Bottom level, ");
            secondPrintOutput(input2);
        }
    }
    
    public void secondPrintOutput(int input){
        // System.out.println(answer[0] + " " + answer[1]);
        if (input == 1){
            System.out.println("first door down (from left)");
        }
        else if (input == 2){
            System.out.println("second door down (from left)");
        }
        else if (input == 3){
            System.out.println("third door down (from left)");
        }
        else if (input == 4){
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
               // System.out.println(library[i][j]);
               // System.out.println(library[i][j+1]);
               // System.out.println(library[i][j+2]);
               // System.out.println(i);
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
                   // System.out.println(i);
                   // System.out.println(a + " " + sum);
                    for (int b = 0; b < 6; b++){
                        if (library[a][b].equals(leftDoor) && library[a][b+1].equals(middleDoor) && library[a][b+2].equals(rightDoor)){
                           // System.out.println(library[a][b]);
                           // System.out.println(library[a][b+1]);
                           // System.out.println(library[a][b+2]);
                           // System.out.println(a);
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
        boolean save = true;
        String saveState;
        int saveCount = 0;
        int[] answer1 = new int[2];
        int[] answer2 = new int[2];
        int[] answer3 = new int[2];
        int[] answer4 = new int[2];
        // System.out.println("test");
        System.out.println("Initialized. The following print statements will tell you what to enter. When it says to enter the door, enter the color of the door as r, b, y, or g depending on the color of the door. If there is no door to the left or right of you, press n");
        
        while (save == true && saveCount < 4){
        System.out.println();
        System.out.println("Is there a floor above you?");
        calculator.floorThereString = scanner.nextLine();
        if (calculator.floorThereString.equals("yes") || calculator.floorThereString.equals("Yes")){
            if (!calculator.floorThereString.equals("yes") && !calculator.floorThereString.equals("Yes")){
                System.out.println("Invalid input entered. Please enter 'yes' or 'Yes'. Shutting down. Please try again");
                scanner.close();
                System.exit(0);
            }
            calculator.floorThere = true;
        }
       
        else if (calculator.floorThereString.equals("no") || calculator.floorThereString.equals("No")){
            calculator.floorThere = false;
        }
        if (!calculator.floorThereString.equals("no") && !calculator.floorThereString.equals("No") && !calculator.floorThereString.equals("yes") && !calculator.floorThereString.equals("Yes")){
            System.out.println("Invalid input entered. Please enter 'yes' or 'no'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        // calculator.floorThere = scanner.nextBoolean();
        // System.out.println(calculator.floorThere);
        if (calculator.floorThere == true){
        System.out.println("Enter first door that is the floor above you and to the left");
        // calculator.leftDoorTop = scanner.nextLine();
        // System.out.println(calculator.leftDoorTop);
        calculator.leftDoorTop = scanner.nextLine();
        if (!calculator.leftDoorTop.equals("r") && !calculator.leftDoorTop.equals("y") && !calculator.leftDoorTop.equals("g") && !calculator.leftDoorTop.equals("b") && !calculator.leftDoorTop.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        // System.out.println(calculator.leftDoorTop);
        // System.out.println(calculator.doorFinder());
        System.out.println("Enter the second door that is the floor above you in the middle");
        calculator.middleDoorTop = scanner.nextLine();
        if (!calculator.middleDoorTop.equals("r") && !calculator.middleDoorTop.equals("y") && !calculator.middleDoorTop.equals("g") && !calculator.middleDoorTop.equals("b") && !calculator.middleDoorTop.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        // System.out.println(calculator.middleDoorTop);
        System.out.println("Enter the third door that is the floor above you and to the right");
        calculator.rightDoorTop = scanner.nextLine();
        if (!calculator.rightDoorTop.equals("r") && !calculator.rightDoorTop.equals("y") && !calculator.rightDoorTop.equals("g") && !calculator.rightDoorTop.equals("b") && !calculator.rightDoorTop.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        }
        System.out.println("Enter the first door that is on your floor and to the left");
        calculator.leftDoor = scanner.nextLine();
        if (!calculator.leftDoor.equals("r") && !calculator.leftDoor.equals("y") && !calculator.leftDoor.equals("g") && !calculator.leftDoor.equals("b") && !calculator.leftDoor.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        System.out.println("Enter the second door that is on your floor and in the middle");
        calculator.middleDoor = scanner.nextLine();
        if (!calculator.middleDoor.equals("r") && !calculator.middleDoor.equals("y") && !calculator.middleDoor.equals("g") && !calculator.middleDoor.equals("b") && !calculator.middleDoor.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        System.out.println("Enter the third door that is on your floor and to the right");
        calculator.rightDoor = scanner.nextLine();
        if (!calculator.rightDoor.equals("r") && !calculator.rightDoor.equals("y") && !calculator.rightDoor.equals("g") && !calculator.rightDoor.equals("b") && !calculator.rightDoor.equals("n")){
            System.out.println("Invalid input entered. Please provide a 'r', 'y', 'g', 'n', or 'b'. Shutting down. Please try again");
            scanner.close();
            System.exit(0);
        }
        if (calculator.floorThere == false){
            calculator.leftDoorTop = calculator.leftDoor;
            calculator.middleDoorTop = calculator.middleDoor;
            calculator.rightDoorTop = calculator.rightDoor;
        }
        
        int[] answer = calculator.doorFinder();
        calculator.answer = answer;

        System.out.println();

      /* public void firstPrintOutput(int input, int input2) {
       
        if (input == 0){
            System.out.print("Top level, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 1){
            System.out.print("Second level down from top, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 2){
            System.out.print("Third level down from the top, ");
            calculator.instructionOutput();
        }
        else if (answer[0] == 3){
            System.out.print("Bottom level, ");
            calculator.instructionOutput();
        }
    }
    */

      //  System.out.println("The door color is " + calculator.library[answer[0]][answer[1]]);

        System.out.println();

        System.out.println("Would you like to save this door and repeat this process?");
        saveState = scanner.nextLine();
        if (!saveState.equals("yes") && !saveState.equals("Yes")){
            if (!saveState.equals("no") && !saveState.equals("No")){
                System.out.println("Invalid input entered. Please enter 'yes' or 'no'. Shutting Down.");
                scanner.close();
                System.exit(0);
            }
        }
        if (saveState.equals("yes") || saveState.equals("Yes")){
            if (saveCount == 0){
            answer1[0] = answer[0];
            answer1[1] = answer[1];
            }
            if (saveCount == 1){
                answer2[0] = answer[0];
                answer2[1] = answer[1];
            }
            if (saveCount == 2){
                answer3[0] = answer[0];
                answer3[1] = answer[1];
            }
            if (saveCount == 3){
                answer4[0] = answer[0];
                answer4[1] = answer[1];
            }
            save = true;
            saveCount++;
            System.out.println(saveCount);
        }
        if(saveState.equals("no") || saveState.equals("No")){
            save = false;
        }

    }

    if (saveCount == 4){
        calculator.firstPrintOutput(answer1[0], answer1[1]);
        calculator.firstPrintOutput(answer2[0], answer2[1]);
        calculator.firstPrintOutput(answer3[0], answer3[1]);
        calculator.firstPrintOutput(answer4[0], answer4[1]);
    }
        // System.out.println()

        scanner.close();



    }

}