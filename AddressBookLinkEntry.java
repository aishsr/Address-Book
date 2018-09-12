// The "AddressBookLinkEntry" class.
// // Author
// Date
public class AddressBookLinkEntry
{
    protected String name;
    protected String address;
    protected String color;
    protected AddressBookLinkEntry link;

    public AddressBookLinkEntry (String name, String address, String color, AddressBookLinkEntry link)
    {
	this.name = name;
	this.address = address;
	this.color = color;
	this.link = link;
    } // AddressBookEntry constructor

    public String getName ()
    {
	return name;
    } // getName method

    public String getAddress ()
    {
	return address;
    } // getAddress method
    
    public String getColor ()
    {
	return color;
    } // getColor method

    
    
    
    public AddressBookLinkEntry getLink ()
    {
	return link;
    } // getLink method

    public void setAddress (String newAddress)
    {
	address = newAddress;
    } // setAddress method
    
    public void setColor (String newColor)
    {
	color = newColor;
    }//setColor method

    public void setLink (AddressBookLinkEntry newLink)
    {
	link = newLink;
    } // setLink method
} /* AddressBookLinkEntry class */
