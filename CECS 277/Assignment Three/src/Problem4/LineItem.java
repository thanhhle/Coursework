// Remove format
// Add getters for quantity and theProduct
package Problem4;
/**
   Describes a quantity of an article to purchase.
*/
public class LineItem
{  
   private int quantity;
   private Product theProduct;

   /**
      Constructs an item from the product and quantity.
      @param aProduct the product
      @param aQuantity the item quantity
   */
   public LineItem(Product aProduct, int aQuantity)
   {  
      theProduct = aProduct;
      quantity = aQuantity;
   }
   
   /**
      Gets the item quantity
      @return the item quantity
    */
   public int getQuantity() 
   {
	   return quantity;
   }

   /**
      Get the product
      @return the product
    */
   public Product getTheProduct() 
   {
	   return theProduct;
   }

   /**
      Computes the total cost of this line item.
      @return the total price
   */
   public double getTotalPrice()
   {  
      return theProduct.getPrice() * quantity;
   }
}
