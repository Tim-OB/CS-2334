/**
 * Lab 6
 * 
 * Class representing an Equilateral Triangle.
 * 
 * @author  Tim O'Brien
 * @version 2018-10-03
 */
public class EquilateralTriangle extends Triangle
{
    // Double to hold the side length
    private double sideLength;

    /**
     * Constructor for E.T. passes in super values from Triangle.
     * 
     * @param id         id of the shape
     * @param sideLength length of a side
     */
    public EquilateralTriangle(String id, double sideLength)
    {
        super(id, sideLength, sideLength, sideLength);
        this.sideLength = sideLength;
    }

    /**
     * @return the area of an equilateral triangle
     */
    public double getArea()
    {
        return (sideLength * sideLength) * ((Math.sqrt(3)) / 4);
    }

    /**
     * @return the shape type
     */
    public String getShapeType()
    {
        return "EquilateralTriangle";
    }
}
