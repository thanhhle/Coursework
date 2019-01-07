//Thanh Le, 015809792, Assignment Two
/**
 * 
 * @author Thanh Le
 * 
 * Circle - Circles in the (x, y) plane
 *
 */
public class Circle 
{
	/**
	 * Create a new circle that is a copy of the given circle
	 * @param c the circle to duplicate
	 */
	public Circle(Circle c)
	{
		this(new Point(c.getCenter()), c.getRadius());
	}
	
	/**
	 * Create a Circle with center at (x,y) and given radius
	 * @param x X-coordinate of center
	 * @param y Y-coordinate of center
	 * @param radius Radius of circle
	 */
	public Circle(int x, int y, int radius)
	{
		this(new Point(x, y), radius);
	}
	
	/**
	 * Create a Circle with the given center and radius
	 * @param center the circle's center
	 * @param radius the circle's radius
	 */
	public Circle(Point center, int radius)
	{
		mCenter = center;
		mRadius = radius;
	}
	
	
	/**
	 * Returns the center of the circle
	 * @return the circle's center
	 */
	public Point getCenter()
	{
		return mCenter;
	}
	
	/**
	 * Returns the circle's radius
	 * @return the circle's radius
	 */
	public int getRadius()
	{
		return mRadius;
	}
	
	/**
	 * Move the Circle by moving its center
	 * @param deltaX the X distance to move
	 * @param deltaY the Y distance to move
	 */
	public void move(int deltaX, int deltaY)
	{
		mCenter.move(deltaX, deltaY);
	}
	
	/**
	 * Return the distance between the 2 circles' centers
	 * @param c2 the circle to get the distance to
	 * @return the distance between the 2 circles' centers
	 */
	public double getDistance(Circle c2)
	{
		return mCenter.getDistance(c2.getCenter());	
	}
	
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Circle)) return false;
		
		Circle c2 = (Circle)obj;
		return mCenter.equals(c2.getCenter()) && mRadius == c2.getRadius();
	}
	
	public String toString()
	{
		return "Center: " + mCenter + ", Radius: " + mRadius;
	}
	
	
	private int mRadius;
	private Point mCenter;
}
