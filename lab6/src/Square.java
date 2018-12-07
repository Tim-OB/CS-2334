/**
 * Lab 6
 * 
 * Class representing a Square.
 * 
 * @author Stephen, Tim O'Brien
 * @version 2018-20-03
 */ 
public class Square extends Rectangle
{
    /**
     * Constructor. Takes in the sidelength of the square. Remember that a square is a type of
     * rectangle. Thus, a rectangle that is a square has width and height both equal
     * to the sidelength.
     * 
     * @param id The created shape's name id.
     * @param sidelength The length of all sides of the square.
     */
	public Square(String id, double sidelength)
	{
		// TODO: implement this.
	    //Call in values from Rectangle.
	    super(id, sidelength, sidelength);   
	}
	
	/**
	 * Implementation of the abstract method getShapeType() for squares.
	 * 
	 * @return The string "Square"
	 */
	@Override
	public String getShapeType()
	{
	 // TODO: implement this.
	    return "Square";
	}
}
