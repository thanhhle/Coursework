// Remove format method
// Add the getters for name, street, city, state, and zip
package Problem4;
/**
   Describes a mailing address.
*/
public class Address
{  
   private String name;
   private String street;
   private String city;
   private String state;
   private String zip;

   /**
      Constructs a mailing address. 
      @param aName the recipient name
      @param aStreet the street
      @param aCity the city
      @param aState the two-letter state code
      @param aZip the ZIP postal code
   */
   public Address(String aName, String aStreet,
         String aCity, String aState, String aZip)
   {  
      name = aName;
      street = aStreet;
      city = aCity;
      state = aState;
      zip = aZip;
   }
   
   /**
      Gets the recipient name
      @return the recipient name
    */
   public String getName() 
   {
	   return name;
   }

   /**
      Gets the street
      @return the street
    */
   public String getStreet() 
   {
	   return street;
   }

   /**
      Gets the city
      @return the city
    */
   public String getCity() 
   {
	   return city;
   }

   /**
      Gets the two-letter state code
      @return the two-letter state code
    */
   public String getState() 
   {
	   return state;
   }

   /**
      Gets the ZIP postal code
      @return the ZIP postal code
    */
   public String getZip() 
   {
	   return zip;
   }
}