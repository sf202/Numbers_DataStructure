/*Santiago Fleiderman
 * CSC 3410
 * Spring 2016
 * Assignment 1 Numbers
 */
/** ----Documentation----
 * 1.  This program creates multiple arrays to store random numbers, there are two groups,
 * one group is composed of one array size 5 and the other is one is size 1. It is up the the user to decide which
 * the length of the array. Finally after it generate the random numbers it gives the end result to the user which then it prompts the user
 * to buy more tickets or terminate the program. Like a Lottery.

 2. The best way to first apporach this program is to use the loops do,for,while and do while. These methods were used to enable the user to be restricted
 from 1 to 5 groups. Also to see if the user wishes to continue the program. Moreover hashset was use to create a table of arrays so that
 it may be possible to have group 1 and group 2. Also random numbers and hash set were used to create a unique numbers and no repetition. 
 I used the while loop algorithm to restrict user input and to end the program also to restart it.
 * The first problem was how to decide how to implement an array to generate group 1 and group2 , this was solved using random numbers and hashset. Moreover  another
 * problem of figuring out how to group 1 and group 2, this was solved by having subgroup 1 and subgroup 2 made for group 1 and group 2.
 *second problem of how to do this I had to use another class called createNewTicketsDisplayUser which created the array, and random numbers class.
 Using random numbers fixes the part where I have to have no repetiition I used the variable band1 to store group 1 in the array and proceed to use it for the random numbers.
 *third problem was how to restart the program, I fixed this by using strings for user input and scanner. 
 *Fourth problem how to sort I then used a for loop to manuelly order the numbers sequentially. Using a sort method.
Finally I  display it to the user user print method.

3.  The data structures that I have used in this program include Arrays, hashset,set and class createNewTicketsDisplayUser.

4. The program is used in this way, first it ask the user for the amount of groups the user wishes to create between 1 and 5 ,
 if the user enters a number that is not in between that number then the program rejects the user input. Once the user has entered the right
input the program then tells the user the Group 1 tickets Group 2 ticket and then displays the tickets the user entered and got due to random numbers.
If the user wants more tickets the program will generate more if the user answers Y.

5. The public static void class is the main class where the program starts to ask the user for the input and limits their reply to the right input. The 
createNewTicketsDisplayUser class recieves the userinput and it checks the numbers to proceeds to make multiple arrays through loops and generates 
the random number, it then orders the numbers sequentially from least to greatest. The ThreadLocalRandom was used to generate the random numbers then bounded 
them.
 */
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet; /*HashSet extends AbstractSet and implements the Set interface. It creates a collection that uses a hash table for storage.*/

public class numbers {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// instance variables
		char repeat;
		String input;
		int inputIn;
		Scanner answer ;
		// Required for user input
		answer = new Scanner(System.in);
		// Asks the user to enter a number bewteen 1 and 5
		do{
			do{
				System.out.println("Please enter the number of groups  that you wish to  generate :");
				inputIn = answer.nextInt();
				if (inputIn > 5 ||  inputIn < 1)
					System.out.println("The number you entered is either too large or too small. Try Again.");
			} while (inputIn > 5 ||  inputIn <1);
			// If reply is correct it procceeds with the program
			for (int i = 0; i < inputIn; i++) {
				createNewTicketsDisplayUser();
			}  
			// This repeat the program using loops
			System.out.println("");
			answer.nextLine();
			System.out.println("Would you like to buy more tickets?");
			System.out.print("Enter Y for yes or N for No : ");
			input = answer.nextLine();
			repeat = input.charAt(0);
			if (repeat == 'N'){
				System.out.println("Have a nice day");
				break;
			}
		} while (repeat == 'Y' || repeat =='y');
	}

	public static void createNewTicketsDisplayUser() {
		// Variables
		int band2;
		int hawk = 0; 
		int brief;
		// /declare array
		int  band1 [];
		band1 = new int[5];
		// creates an array that generate random numbers 1-26 random numbers
		// Hash set creates a table for storage of an array.
		HashSet<Integer> hashSet = new HashSet<>();
		band2 = ThreadLocalRandom.current().nextInt(1, 26);

		// Creates group 1 that generates 1-69 random numbers
		while (true) {
			brief = ThreadLocalRandom.current().nextInt(1, 69);
			if (hashSet.contains(brief))
				continue;
			else {
				hashSet.add(brief);
				band1[hawk++] = brief;
			}
			if (hawk == 5)
				break;

		}
		//  checking numbers sequentially sort
		for (int add = 0; add < 5; add++) {
			for (int more = 0; more < 4; more++) {
				if (band1[more] > band1[more+1]) {
					brief = band1[more];
					band1[more] = band1[more+1];
					band1[more+1] = brief;
				}
			}
		}
		// Displays the users random numbers that user purchased
		System.out.print("Here are Group 1&& 2 Ticket(s) :" + " " );
		for (int summary: band1) {
			System.out.print(" " + summary );
		}
		System.out.print(":" + band2);
		System.out.println("");
	}

}