//Thanh Le, 015809792, Assignment Two
/**
 * 
 * @author Thanh Le
 * 
 * Cylinder - Cylinder in the (x, y) plane
 *
 */
public class Cylinder 
{
	/**
	 * Create a cylinder with the indicated parameters
	 * @param top the top of the cylinder
	 * @param bottom the bottom of the cylinder
	 * @param height the height of the cylinder
	 */
	public Cylinder(Circle top, Circle bottom, int height)
	{
		mTop = top;
		mBottom = bottom;
		mHeight = height;
	}
	
	/**
	 * Create a Cylinder whose bottom is given and whose top is the bottom moved up the z-axis by the distance height
	 * @param bottom the bottom of the cylinder
	 * @param height the height of the cylinder
	 */
	public Cylinder(Circle bottom, int height)
	{	
		this(new Circle(bottom), bottom, height);
	}
	
	
	/**
	 * Returns the top of the cylinder
	 * @return the top of the cylinder
	 */
	public Circle getTop()
	{
		return mTop;
	}
	
	/**
	 * Returns the bottom of the cylinder
	 * @return the bottom of the cylinder
	 */
	public Circle getBottom()
	{
		return mBottom;
	}
	
	/**
	 * Returns the height of the cylinder
	 * @return the height of the cylinder
	 */
	public int getHeight()
	{
		return mHeight;
	}
	
	/**
	 * Move the cylinder by movings its top and bottom the indicated distances
	 * @param deltaX the distance to move in the X direction
	 * @param deltaY the distance to move in the Y direction
	 */
	public void move(int deltaX, int deltaY)
	{
		mTop.move(deltaX, deltaY);
		mBottom.move(deltaX, deltaY);
	}
	
	/**
	 * Returns the distance between the 2 cylinders' tops
	 * @param cy1 the cylinder to return to the distance to
	 * @return the distance between the 2 cylinders' tops
	 */
	public double getDistance(Cylinder cy1)
	{
		return mTop.getDistance(cy1.getTop());
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Cylinder)) return false;
		
		Cylinder cy2 = (Cylinder)obj;
		return mTop.equals(cy2.getTop()) && mBottom.equals(cy2.getBottom()) && mHeight == cy2.getHeight();
	}
	
	public String toString()
	{
		return "Cylinder: Top: " + mTop + ", Bottom: " + mBottom + ", Height: " + mHeight;
	}
	
	
	private Circle mTop;
	private Circle mBottom;
	private int mHeight;
}
