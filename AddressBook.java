// The "AddressBook" class.
//
// Implements an address book using a linked list.
// Author
// Date

import java.io.*;

public class AddressBook
{
    protected AddressBookLinkEntry first;
    protected String fileName;

    public AddressBook (String fileName)
    {
	first = null;
	this.fileName = fileName;
    } // AddressBook constructor


    // Return index of name in contents array. If name not present,
    // return -1. This method is used internally and is not exported.
    protected AddressBookLinkEntry find (String name)
    {
	AddressBookLinkEntry where = first;
	while ((where != null) && (!name.equals (where.getName ())))
	{
	    where = where.getLink ();
	}
	return where;
    } // find method


    // Change the address and color for this name. The name must already be in the book.
    public void change (String name, String address)
    {
	AddressBookLinkEntry entry = find (name);
	if (entry == null)
	{
	    System.out.println (name + " is not in the address book.");
	}
	else
	{
	    entry.setAddress (address);
	}
    } // change method
    
    
    // Change the address and color for this name. The name must already be in the book.
    public void change2 (String name, String color)
    {
	AddressBookLinkEntry entry = find (name);
	if (entry == null)
	{
	    System.out.println (name + " is not in the address book.");
	}
	else
	{
	    entry.setAddress (color);
	}
    } // change method
    
    



    // Delete the name with its address. The name must already be in the book.
    public void delete (String name)
    {
	// pre: find (name) != null
	if (name.equals (first.getName ()))
	{
	    first = first.getLink ();
	}
	else
	{
	    AddressBookLinkEntry where, prev;
	    prev = first;
	    where = first.getLink ();
	    while (where != null)
	    {
		if (name.equals (where.getName ()))
		{
		    prev.setLink (where.getLink ());
		    break;
		}
		else
		{
		    prev = where;
		    where = where.getLink ();
		}
	    }
	}
    } // delete method





    // Create a new entry in the address book.
    public boolean enter (String name, String address, String color)
    {
	// pre: find (name) = -1. Name must not be in book.
	AddressBookLinkEntry entry;

	entry = new AddressBookLinkEntry (name, address, color, first);
	if (entry != null)
	{
	    first = entry;
	    return true;
	}

	// There is no space to add an entry. Return false.
	return false;
    } // enter method





    // Look up the address of a name. If the name is not found in the book,
    // then lookUp returns null. Otherwise it returns the address.
    public String lookUp (String name)
    {
	AddressBookLinkEntry entry = find (name);
	if (entry == null)
	{
	    return null;
	}
	else
	{
	    return entry.getAddress ();

	}
    } // lookUp method


    // Look up the color of a name. If the name is not found in the book,
    // then lookUp returns null. Otherwise it returns the color.
    public String lookUp2 (String name)
    {
	AddressBookLinkEntry entry = find (name);
	if (entry == null)
	{
	    return null;
	}
	else
	{
	    return entry.getColor ();
	}
    } // lookUp method





    // Prints all the names and addresses in the book.
    public void printOut ()
    {
	if (first != null)
	{
	    AddressBookLinkEntry where = first;
	    while (where != null)
	    {
		print (where.getName (), 15);
		System.out.println (" " + where.getAddress ());
		System.out.println (" " + where.getColor ());
		where = where.getLink ();
	    }
	}
	else
	{
	    System.out.println ("There are no entries in the address book.");
	}
    } // printOut method




    // Prints a string left justified in a field of a given size.
    protected void print (String s, int fieldSize)
    {
	if (s.length () >= fieldSize)
	{
	    System.out.print (s);
	}
	else
	{
	    StringBuffer padding = new StringBuffer ();

	    for (int count = 0 ; count < fieldSize - s.length () ; count++)
	    {
		padding.append (' ');
	    }
	    System.out.print (s + padding);
	}
    } // print method


    // Save the addressbook to fileName.
    public void save ()
    {
	PrintWriter out;

	try
	{
	    out = new PrintWriter (new FileWriter (fileName));
	}
	catch (IOException e)
	{
	    System.out.println ("Unable to open " + fileName + " for writing.");
	    System.out.println ("File not saved.");
	    return;
	}

	AddressBookLinkEntry where = first;
	while (where != null)
	{
	    out.println (where.getName ());
	    out.println (where.getAddress ());
	    out.println (where.getColor ());
	    where = where.getLink ();
	}

	out.close ();
    } // save method



    // Load the addressbook from fileName.
    public void load ()
    {
	BufferedReader in;
	String name, address, color;

	try
	{
	    in = new BufferedReader (new FileReader (fileName));
	}
	catch (FileNotFoundException e)
	{
	    System.out.println (fileName + " not found.");
	    return;
	}

	try
	{
	    name = in.readLine ();
	    while (name != null)
	    {
		address = in.readLine ();

		color = in.readLine ();

		if (!enter (name, address, color))
		{
		    System.out.println ("Sorry, address book file too large.");
		    break;
		}

		name = in.readLine ();
	    }
	}
	catch (IOException e)
	{
	    System.out.println ("An I/O error occurred while reading " + fileName);
	}


	try
	{
	    in.close ();
	}
	catch (IOException e)
	{
	    System.out.println ("An I/O error occurred while closing " + fileName);
	}
    } // load method
} /* AddressBook class */


