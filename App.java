package CEN4802.drone_mcclure;

import java.util.Scanner;

import CEN4802.drone_manager.drone;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner keyboardInput = new Scanner(System.in); // keyboard input
	static int userInput = 0; // userInput variable
	static String userInputString = null; // userInput String
	static drone drone = new drone(); // create new drone object

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
	
		do { displayMenu();  // display menu until user selects to Exit Navigation
		} while (userInput != 8);
		
	}  // End of main method
		
	
	/**
	 * Displays menu, accepts user input
	 * @param drone
	 */
	public static int displayMenu() {
		System.out.println("Which direction would you like to move the drone?\n"
				+ "1 - Move Up\n"
				+ "2 - Move Down\n"
				+ "3 - Move Forward\n"
				+ "4 - Move Backward\n"
				+ "5 - Turn Left\n"
				+ "6 - Turn Right\n"
				+ "7 - Display Position\n"
				+ "8 - Exit Navigation");
		
		userInputString = keyboardInput.nextLine();
		
		try {
			userInput = Integer.parseInt(userInputString);  // Parse userInput String to integer
		}
		catch (NumberFormatException e) {
			System.out.println("Invaid Entry.  A number is required."); // Error message if user enters in non-menu selection
		}
		
		switch (userInput) {
		case 1: drone.moveUp();  // Move drone up
				System.out.println("You have moved the drone UP\n");
				return userInput;
		case 2: drone.moveDown();  // Move drone down
				System.out.println("You have moved the drone DOWN\n");
				return userInput;
		case 3: drone.moveForward(); // Move drone forward
				System.out.println("You have moved the drone FORWARD\n");
				return userInput;
		case 4: drone.moveBackward(); // Move drone backward
				System.out.println("You have moved the drone BACKWARD\n");
				return userInput;
		case 5: drone.turnLeft();  // turn drone left
				System.out.println("You have turned the drone LEFT\n");
				return userInput;
		case 6: drone.turnRight(); // turn drone right
				System.out.println("You have turned the drone RIGHT\n");
				return userInput;
		case 7: System.out.println(drone.toString() + "\n"); // Display drone position
				return userInput;
		case 8: System.out.println("Thank you for flying with Mcclure_Drone, Goodbye."); // Exit
				System.exit(1);
		default: System.out.println("Please enter a number from the menu");
				return userInput;
		}
	
	} // End of displayMenu
}
