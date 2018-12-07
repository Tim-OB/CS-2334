import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Lab 6
 * 
 * Test class for Lab 6
 * 
 * @author Stephen, Tim O'Brien
 * @version 2018-10-03
 */
public class ShapeTest
{
    /**
     * Tests for the square class.
     */
    @Test
    public void SquareTest()
    {
        // TODO: implement this.
        Shape sq = new Square("Sq1", 4.0);
        assertEquals("Circle area incorrect.", 4.0 * 4, sq.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 16, sq.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "Square", sq.getShapeType());
        assertEquals("Shape ID incorrect.", "Sq1", sq.getId());
    }

    /**
     * Tests for the rectangle class.
     */
    @Test
    public void RectangleTest()
    {
        // TODO: implement this.
        Shape rec = new Rectangle("Rec1", 4.0, 1.0);
        assertEquals("Circle area incorrect.", 4.0 * 1.0, rec.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 10, rec.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "Rectangle", rec.getShapeType());
        assertEquals("Shape ID incorrect.", "Rec1", rec.getId());
    }

    /**
     * Tests for the triangle class.
     */
    @Test
    public void TriangleTest()
    {
        // TODO: implement this.
        Shape tri1 = new EquilateralTriangle("Tri1", 5.0);
        assertEquals("Circle area incorrect.", 25.0 * (Math.sqrt(3)/4), tri1.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 5*3, tri1.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "EquilateralTriangle", tri1.getShapeType());
        assertEquals("Shape ID incorrect.", "Tri1", tri1.getId());
    }

    /**
     * THIS TEST IS GIVEN FOR YOU. IT WILL WORK ONCE YOU HAVE DECLARE THE ABSTRACT
     * SHAPE METHODS.
     * 
     * Tests for the circle class. Also test that IDs are done correctly.
     */
    @Test
    public void CircleTest()
    {
        Shape circ = new Circle("Circle1", 3.0);
        assertEquals("Circle area incorrect.", Math.PI * 3.0 * 3.0, circ.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 3.0, circ.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "Circle", circ.getShapeType());
        assertEquals("Shape ID incorrect.", "Circle1", circ.getId());

        Shape circs = new Circle("Circle2", 4.5);
        assertEquals("Circle area incorrect.", Math.PI * 4.5 * 4.5, circs.getArea(), 0.0001);
        assertEquals("Circle perimeter incorrect.", 2 * Math.PI * 4.5, circs.getPerimeter(), 0.0001);
        assertEquals("Circle type incorrect.", "Circle", circs.getShapeType());
        assertEquals("Shape ID incorrect.", "Circle2", circs.getId());
    }

    /**
     * Tests for the Shape Comparator class.
     */
    @Test
    public void CompareTest()
    {
        // TODO: implement this.
        ShapeComparator sc = new ShapeComparator();

        //Create shapes for testing
        Shape rec = new Rectangle("Rec1", 4.0, 1.0);
        Shape rec2 = new Rectangle("Rec2", 4.0, 1.0);
        Shape rec3 = new Rectangle("Rec3", 3.0, 1.0);
        Shape sameArea = new Rectangle("sA", 3.0, 6.0);
        Shape sameArea2 = new Rectangle("sA2", 9.0, 2.0);
        Shape sq = new Square("sq1", 3.0);
        Shape sq2 = new Square("sq2", 3.0);
        
        //Store the returned values from compare
        int comp = sc.compare(rec, rec2);
        int comp2 = sc.compare(rec, rec3);
        int comp3 = sc.compare(rec3, rec);
        int comp4 = sc.compare(sameArea, sameArea2);
        int comp5 = sc.compare(sameArea2, sameArea);

        //Check that they output the correct values
        assertEquals(comp, 0);
        assertEquals(comp2, -1);
        assertEquals(comp3, 1);
        assertEquals(comp4, 1);
        assertEquals(comp5, -1);
        assertEquals(sc.equals(sq, sq2), true);
        assertEquals(sc.equals(sq, rec), false);
        

    }

    /**
     * Tests for Shape's toString().
     */
    @Test
    public void ShapeToStringTest()
    {
        // TODO: implement this.
        Shape rec = new Rectangle("Rec1", 4.0, 1.0);
        String expected = rec.toString();
        String actual = String.format("Rectangle:\t ID = Rec1\t area = 4.000\t perimeter = 10.000");

        assertEquals(expected, actual);
    }

    /**
     * Tests the natural ordering of shapes (compareTo in shape)
     */
    @Test
    public void NaturalCompareTest()
    {
        // TODO: implement this.

        //Setup shapes to see if they are equal
        Shape rec = new Rectangle("Rec1", 4.0, 1.0);
        Shape rec2 = new Rectangle("Rec2", 4.0, 1.0);

        int comp = rec.compareTo(rec2);

        assertEquals(comp, 0);

        //Compare shapes to see if shape 2's perimeter is greater
        Shape rec3 = new Rectangle("Rec1", 4.0, 1.0);
        Shape rec4 = new Rectangle("Rec2", 4.0, 2.0);

        int comp2 = rec3.compareTo(rec4);

        assertEquals(comp2, -1);

        // Setup shapes to compare if the perimeter is not equal and shape 1 is less
        // than shape 2
        Shape rec5 = new Rectangle("Rec1", 4.0, 2.0);
        Shape rec6 = new Rectangle("Rec2", 4.0, 1.0);

        int comp3 = rec5.compareTo(rec6);

        assertEquals(comp3, 1);

        // Setup shapes to compare if the perimeter is the same
        Shape sq1 = new Square("Sq1", 4.0);
        Shape sq2 = new Square("Sq2", 4.0);

        int comp4 = sq1.compareTo(sq2);

        assertEquals(comp4, 0);

        // Setup shapes to compare if the perimeter is not equal and shape 1 is less
        // than shape 2
        Shape sq3 = new Square("Sq1", 4.0);
        Shape sq4 = new Square("Sq2", 5.0);

        int comp5 = sq3.compareTo(sq4);

        assertEquals(comp5, -1);

        // Setup shapes to compare if the perimeter is equal, but the area isn't
        Shape sq5 = new Square("Sq1", 2);
        Shape rec7 = new Rectangle("Rec1", 3, 1);

        int comp6 = sq5.compareTo(rec7);
        int comp7 = rec7.compareTo(sq5);

        assertEquals(comp6, 1);
        assertEquals(comp7, -1);

    }
}
