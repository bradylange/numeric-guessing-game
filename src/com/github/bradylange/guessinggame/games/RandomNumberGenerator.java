/*
 * Developer: Brady Lange
 * Course: CSIS 161 - Programming I
 * Institution: University of Wisconsin-River Falls
 * Class: RandomNumberGenerator
 * Development Language: Java
 * Copyright Notice: MIT License, Copyright (c) 2019 Brady Lange
 */

package com.github.bradylange.guessinggame.games;

// Import swing library - message box
import javax.swing.JOptionPane;

/**
 * <p>
 * 		Generates a random number between 0 and 100 for the user to 
 * 		guess which one it is while giving them hints. The number needs to be 
 * 		guessed correctly by 5 guesses. Contains the {@link #main} method which 
 * 		instantiates and sets up the program.
 * </p>
 * 
 * @author  Brady Lange - <a href = "https://www.linkedin.com/in/brady-lange/" 
 *                           target = "_blank">LinkedIn</a>
 * @version  1.0.1, 01/08/2019
 * @since  1.0, 11/29/2016
 */
public class RandomNumberGenerator
{ 
	// ========================================================================
	// Main Method
	// ========================================================================
	/**
	 * Instantiates and sets up the program.
	 * 
	 * @param args  the array of command line arguments to be passed
	 * 
	 * @version  1.0.1, 01/08/2019
	 * @since  1.0, 11/29/2016
	 */
	public static void main(String[] args) 
	{
		// Random number
		int num = 0; 	
		// Number guess
		int guess = 0; 			
		// Guess from dialog box as a String
		String strGuess;	
		// Flag to control the loop
		boolean done = false; 	
		// Difference between guess and actual number
		int diff = 0; 			
		// Total amount of guesses
		int counter = 1; 										
		
		// Generate random number and convert Math.random() to Integer
		num = (int) (Math.random() * 100); 																
		
		System.out.println("************************************************");
		System.out.println("Random Number Guessing Game:");
		System.out.println("************************************************");
		System.out.println("\nYour Guesses: ");
		// Continue until correct guess or 5 guesses 
		while (!done && counter <= 5)							
		{  
			// Ask for and retrieve numeric guess
			strGuess = JOptionPane.showInputDialog("Enter an Integer:\n" 
			                                       + "greater than or equal to "
			                                       + "zero and less than one "
			                                       + "hundred.");
			// Convert guess from String to Integer
			guess = Integer.parseInt(strGuess);	
			// Print blank line 
			System.out.println();
			// Difference of the target number and guess
			diff =  Math.abs(num - guess); 						
	
			// ----------------------------------------------------------------
			// Give Appropriate Hint
			// ----------------------------------------------------------------
			// Not greater than 0 or within 100
			if (guess < 0 || guess > 100) 						
			{ 
				JOptionPane.showMessageDialog(null, "Invalid input. "
				                              + "Please try again.");
			}	
			// Correct guess
			else if (guess == num && diff == 0) 				 
			{
				JOptionPane.showMessageDialog(null, "You guessed the correct "
				                              + "number.");
				done = true; 
			}
			// Somewhat low guess
			else if (guess < num && diff >= 0 && diff < 15) 	
			{
				JOptionPane.showMessageDialog(null, "Your guess is somewhat "
				                              + "low compared to the number.");
			}
			// Moderately low guess
			else if (guess < num && diff >= 15 && diff < 30) 	
			{
				JOptionPane.showMessageDialog(null, "Your guess is moderately "
				                              + "low compared to the number.");
			}
			// Low guess
			else if (guess < num && diff >= 30 && diff < 50)	
			{
				JOptionPane.showMessageDialog(null, "Your guess is low "
				                              + "compared to the number.");
			}
			// Very low guess
			else if (guess < num && diff >= 50) 				
			{
				JOptionPane.showMessageDialog(null, "Your guess is very low "
				                              + "comapared to the number.");
			}
			// Lower guess than the number 
			else if (guess < num) 								
			{
				JOptionPane.showMessageDialog(null, "Your guess is lower than "
				                              + "the number. \n Guess again!");
			}
			// Somewhat high guess
			else if (guess > num && diff > 0 && diff < 15) 		 
			{
				JOptionPane.showMessageDialog(null, "Your guess is somewhat "
				                              + "high compare to the number.");
			}
			// Moderately high guess
			else if (guess > num && diff >= 15 && diff < 30) 	
			{
				JOptionPane.showMessageDialog(null, "Your guess is moderately "
				                              + "high compared to the number.");
			}
			// High guess 
			else if (guess > num && diff >= 30 && diff < 50) 	
			{
				JOptionPane.showMessageDialog(null, "Your guess is high "
				                              + "compared to the number.");
			}
			// Very high guess
			else if (guess > num && diff >= 50) 				
			{
				JOptionPane.showMessageDialog(null, "Your guess is very high "
				                              + "compared to the number.");
			}
			// Higher guess than the number
			else if (guess > num) 								
			{
				JOptionPane.showMessageDialog(null, "Your guess is higher than "
				                              + "the number. \n Guess again!");
			}
			// Invalid guess
			else 												
			{
				JOptionPane.showMessageDialog(null, "Your input couldn't be "
				                              + "determined. Please try again.");
			}
			// Print guess
			System.out.println(guess);	
			// Increment by one to count the number of guesses
			counter++;											
		} 																	
		// Correct guess
		if (guess == num && diff == 0)							
		{
			JOptionPane.showMessageDialog(null, "Congrats for guessing the "
			                              + "correct number!");
			System.out.println("Correct guess: " + guess);
		}
		// Too many wrong guesses
		else													
		{
			JOptionPane.showMessageDialog(null, "You have guessed the number "
			                              + "wrong too many times (5) restart "
			                              + "the program please.");
			System.out.println("\nYou did not guess the correct number. Better "
			                   + "luck next time!\n");
		}
	} 
}