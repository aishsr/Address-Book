// The "AddressBookTest" class.
//
// The driver program for the AddressBook class.
// The interactive user can enter, delete, change, look up, and print entries.
// The initial contents of the book, if any, are loaded from a file.  When
// the user wants to quit, the contents of the book is saved to the same file.
// Author
// Date
import java.io.*;

public class AddressBookTest
{
    public static void main (String args[]) throws IOException
    {
	String bookFileName; // File name of the address book.

	String name, address, color;
	String command;
	DataInputStream in = new DataInputStream (System.in);

	System.out.println ("Address Book Program");

	System.out.print ("Enter the file name where the address book is stored: ");
	bookFileName = in.readLine ();

	AddressBook book = new AddressBook (bookFileName);
	book.load ();

	System.out.println ("You must give a command and supply the requested information");
	System.out.println ();
	System.out.println ("enter (e), delete (d), change (c), look up (l), print (p), quit (q).");

	while (true)
	{
	    System.out.print ("Command: ");
	    command = in.readLine ();
	    if (command.equals ("e"))
	    {
		System.out.print ("Give name: ");
		name = in.readLine ();
		if (book.lookUp (name) != null)
		{
		    System.out.println ("Sorry, " + name + " already in the book.");
		}
		else
		{
		    System.out.print ("Give address: ");
		    address = in.readLine ();
		    System.out.print ("Give color: ");
		    color = in.readLine ();
		    if (!book.enter (name, address, color))
		    {
			System.out.println ("Unable to enter " + name + " in book");
		    }
		}
	    }
	    else if (command.equals ("d"))
	    {
		System.out.print ("Give name: ");
		name = in.readLine ();
		if (book.lookUp (name) != null)
		{
		    book.delete (name);
		    System.out.println ("Entry deleted");
		}
		else
		{
		    System.out.println ("Sorry, " + name + " not in book");
		}
	    }
	    else if (command.equals ("c"))
	    {
		System.out.print ("Give name: ");
		name = in.readLine ();
		if (book.lookUp (name) != null && book.lookUp2 (name) != null)
		{
		    System.out.print ("Give new address: ");
		    address = in.readLine ();
		    System.out.print ("Give new color: ");
		    color = in.readLine ();
		    book.change (name, address);
		    book.change2 (name, color);

		}
		else
		{
		    System.out.println ("Sorry, " + name + " not in book");
		}
	    }
	    else if (command.equals ("l"))
	    {
		System.out.print ("Give name: ");
		name = in.readLine ();
		address = book.lookUp (name);
		color = book.lookUp2 (name);
		if (address != null && color != null)
		{
		    System.out.println ("Address is: " + address);
		    System.out.println ("Color is: " + color);
		}
		else
		{
		    System.out.println ("Sorry, " + name + " not in book");
		}
	    }
	    else if (command.equals ("p"))
	    {
		book.printOut ();
	    }
	    else if (command.equals ("q"))
	    {
		break;
	    }
	    else
	    {
		System.out.println ("Illegal command. Must be one of e,d,c,l,p, or q");
	    }
	}

	book.save (); // Save any changes.
    } // main method
} /* AddressBookTest class */
