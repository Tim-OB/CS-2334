/**
 * Lab 6
 * 
 * Abstract Class representing a Triangle.
 * 
 * @author Tim O'Brien
 * @version 2018-10-03
 */
public abstract class Triangle extends Polygon
{

    /**
     * Constructor for Triangle class super values from Polygon
     * 
     * @param id id of the shape
     * @param s1 side 1
     * @param s2 side 2
     * @param s3 side 3
     */
    public Triangle(String id, double s1, double s2, double s3)
    {
        super(id);
        // Add the sides from the constructor into the arrayList
        sideLengths.add(s1);
        sideLengths.add(s2);
        sideLengths.add(s3);
    }

}
