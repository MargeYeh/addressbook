import java.io.*;
import java.util.Scanner;

public class AddressBook {

	// An array of Contacts - each stores info for one entry
    private Contact[] entry; 
   
    // Number of entries in the address book
    private int numentry; 

    // Create an empty AddressBook that is initially empty
    public AddressBook() {
		entry = new Contact[25];
		numentry = 0;
    }

    // Adds a new contact to the address book
    public void addContact(Contact c) {
		entry[numentry] = c;
		numentry++;
    }

    // Print out info on all contacts using method Contact class.
    public void printContacts() {
		for (int i=0;i<numentry;i++)
	    	entry[i].printContact();
    }

    // Returns the number of contacts currently in the address book
    public int numContacts() {
		return numentry;
    }

    // Search function: Incomplete
    private int haveContact(String s) {
	
		for (int i=0;i<numentry;i++)
	    	if (entry[i].getName().equals(s))
				return i;
		return -1;
    }

    // Deletes a contact from the address book if the user exists
    public void deleteContact(String s) {
	
		int place = haveContact(s);
		if (place >= 0) {
	    	entry[place] = entry[numentry-1];
	    	numentry--;
		}
    }

    public static void main(String[] args) throws IOException {

    	// Instantiate new Scanner object
		Scanner stdin = new Scanner(System.in);
	
		// Instantiate AddressBook object
		AddressBook blackbook = new AddressBook();

 		// Calls menu and looks for taking in user input
		menu();
		int choice = stdin.nextInt();
	

		while (choice!=6) {
	    
	    	// Only adds contact if the address book has room
	    	if (choice == 1) {
			
				if (blackbook.numContacts() < 25) {
		    
		    		// Take in the user input from the terminal
		    		System.out.println("Enter first name:");
		    		String name = stdin.next();
		    		System.out.println("Enter last name:");
		    		String lastName = stdin.next();
		    		System.out.println("Enter phone number.");
		    		int phone = stdin.nextInt();
		    		System.out.println("Enter email address.");
		    		String email = stdin.next();

		    		// Creates a contact object for the address book
		    		// from the data given by the user
		    		blackbook.addContact(new Contact(name, lastName, phone,email));
				}
				else
		    		System.out.println("Sorry, can not add anyone, your blackbook is full.");
	    	}
	    	
	    	// Takes in user input
	    	// Numbers (from the user input) represent choices for interacting with the address book
	    	else if (choice == 2) {
				System.out.println("What is the email of the entry you want to delete?");
				String email = stdin.next();
				blackbook.deleteContact(email);
	    	}
	    	else if (choice == 3) {
				System.out.println("You have " + blackbook.numContacts() + " contacts.");
	    	}
	    	else if (choice == 4) {
				blackbook.printContacts();
	    	}
	    	else if (choice !=5) {
				System.out.println("Sorry, that was an invalid menu choice, try again.");
	    	}
	    
	    	menu();
	    	choice = stdin.nextInt();
		}
	
    }
    
    // Prints choices to the console for the user to see
    public static void menu() {
		System.out.println("1.Add an entry to address book.");
		System.out.println("2.Remove an entry from address book.");
		System.out.println("3.Print address book.");
		System.out.println("4.Search for an entry.");
		System.out.println("5.Delete address book.");
		System.out.println("6.Quit.");
		System.out.println("Please choose what you'd like to do with the database:");
    }
}