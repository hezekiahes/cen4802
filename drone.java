package CEN4802.drone_manager;

public class drone {
	// x-position controls left and right movement; default position is 0
		private int x_pos;
		
		// y-position controls forward and backward movement; default position is 0
		private int y_pos;
		
		// z-position controls up and down movement; default position is 0
		private int z_pos;
		
		// orientation number 1 = N, 2 = E, 3 = S, 4 = W; Default is N
		private int orientationNumber = 1;
		
		/**

		/**
		 * Default constructor with no parameters
		 */
		public drone() {
			// Set positions
			setX_pos(0);
			setY_pos(0);
			setZ_pos(0);
			
			
			
		}
			

		/**
		 * Getter for x_position 
		 * @return x_position
		 */
		public int getX_pos() {
			return x_pos;
		}


		/**
		 * Setter for x_pos
		 * @param x_pos
		 */
		public void setX_pos(int x_pos) {
			this.x_pos = x_pos;
		}

		/**
		 * Getter for y_pos
		 * @return y_pos
		 */
		public int getY_pos() {
			return y_pos;
		}

		
		/**
		 * setter for y_pos
		 * @param y_pos
		 */
		public void setY_pos(int y_pos) {
			this.y_pos = y_pos;
		}

		/**
		 * getter for z_pos
		 * @return z_pos
		 */
		public int getZ_pos() {
			return z_pos;
		}

		/**
		 * setter for z_pos
		 * @param z_pos
		 */
		public void setZ_pos(int z_pos) {
			this.z_pos = z_pos;
		}
		
		
		/**
		 * getter for Orientation Number
		 * @return orientationNumber 1 = N, 2 = E, 3 = S, 4 = W
		 */
		public int getOrientationNumber() {
			return orientationNumber;
		}

		/**
		 * setter for orientationNumber
		 * @param orientationNumber
		 */


		/**
		 * Move Drone Up
		 */
		public void moveUp() {
			// get current z_pos
			int currentZPos = getZ_pos();
			// set new z_pos / move up
			currentZPos++;
			setZ_pos(currentZPos);
			
			
		}	
		
		/**
		 * Setter for orientationNumber / compass
		 * @param orientationNumber
		 */
		public void setOrientationNumber(int orientationNumber) {
			this.orientationNumber = orientationNumber;
		}


		/**
		 * Move drone down
		 */
		public void moveDown() {
			// get current z_pos
			int currentZPos = getZ_pos();
			
			//determine if drone is on the ground; 
			if (currentZPos <= 0) {
				System.out.println("DRONE IS ON GROUND LEVEL"); // notify user that drone is one ground level
			}
			else {
				// set new z_pos / move down
				currentZPos--;
			setZ_pos(currentZPos);
			}
		}
		
		
		/**
		 * Move drone forward 
		 */
		public void moveForward() {
			//determine orientation
			int currentOrientation = checkOrientation(orientationNumber);
			
			// Move drone forward based on orientation
			switch (currentOrientation) {
			case 1: // Drone facing N 	
				int currentYPos = getY_pos();// get current y_pos
				currentYPos++;
				setY_pos(currentYPos);	// set new y_pos / move forward	facing N
				break;
			
			case 2: // Drone facing E
				int currentXPos = getX_pos(); // get current x
				currentXPos++;
				setX_pos(currentXPos); // set new x_pos / move forward facing E
				break;
			
			case 3: // Drone facing S
				currentYPos = getY_pos(); // get current y_pos
				currentYPos--;
				setY_pos(currentYPos); // set new y_pos / move forward facing S
				break;
				
			case 4: // Drone facing W
				currentXPos = getX_pos(); // get current x_pos
				currentXPos--;
				setX_pos(currentXPos); // set new x_pos / move forward facing W

			}
			
		}
		
		
		
		/**
		 * Move drone backwards
		 */
		public void moveBackward() {
			//determine orientation
			int currentOrientation = checkOrientation(orientationNumber);
			

			// Move drone forward based on orientation
			switch (currentOrientation) {
			
			case 1: // Drone facing N 	
				int currentYPos = getY_pos();// get current y_pos
				currentYPos--;
				setY_pos(currentYPos);	// set new y_pos / move forward	facing N
				break;
			
			case 2: // Drone facing E
				int currentXPos = getX_pos(); // get current x
				currentXPos--;
				setX_pos(currentXPos); // set new x_pos / move forward facing E
				break;
			
			case 3: // Drone facing S
				currentYPos = getY_pos(); // get current y_pos
				currentYPos++;
				setY_pos(currentYPos); // set new y_pos / move forward facing S
				break;
				
			case 4: // Drone facing W
				currentXPos = getX_pos(); // get current x_pos
				currentXPos++;
				setX_pos(currentXPos); // set new x_pos / move forward facing W

			}
		}
		
		/**
		 * Turn drone left
		 */
		public void turnLeft() {
			// get current orientation
			int currentOrientation = checkOrientation(getOrientationNumber());
			
			// change orientation
				// Determine if orientation is N
				if (currentOrientation == 1) {
					// If orientation is N, set key value for orientation to be W
					currentOrientation = 4; 
					setOrientationNumber(currentOrientation);
				}
				else {
					// Move orientation 1 spot to the left
					currentOrientation--;
					setOrientationNumber(currentOrientation);
				}

		}
		
		/**
		 * Turn drone right
		 */
		public void turnRight() {
			// get current orientation
			int currentOrientation = checkOrientation(getOrientationNumber());
			
			// change orientation
						// Determine if orientation is N
						if (currentOrientation == 4) {
							// If orientation is N, set key value for orientation to be W
							currentOrientation = 1;  
							setOrientationNumber(currentOrientation);
						}
						else {
							// Move orientation 1 spot to the right
							currentOrientation++;
							setOrientationNumber(currentOrientation);

						}
		}
		
		/**
		 * Check orientation Number to make sure it is not out of calibration (greater than 4 or less than 1)
		 * @param orientationNumber 
		 * @return orientationNumber 
		 */
		public int checkOrientation(int orientationNumber) {
			// Check if orientation number is greater than 4 or less than 1; if so - will default to North (1)
			if (orientationNumber > 4 | orientationNumber < 1) {
				orientationNumber = 1;
				return orientationNumber;
			}
			else {
				return orientationNumber;
			}
					
		}

		/**
		 * 
		 * @param orientation
		 * @return String format identifying orientation code
		 */
		public String identifyOrientation(int orientation) {
			// ID Orientation based on 1 = N, 2 = E, 3 = S, 4 = W
			String orientationString = "North"; 
			switch (checkOrientation(orientation)) {
			case 1:
				orientationString = "North";
				break;
			case 2: 
				orientationString = "East";
				break;
			case 3: 
				orientationString = "South";
				break;
			case 4:
				orientationString = "West";
				break;
			}
			
			return orientationString;
		}

		/**
		 * toString method to display position
		 */
		@Override
		public String toString() {
			return "Mcclure_Drone [x_pos = " + x_pos + ", y_pos = " + y_pos + ", z_pos = " + getZ_pos() + ", Orientation = "
					+ identifyOrientation(getOrientationNumber()) + "]";
		}
		
		
		
		

}
