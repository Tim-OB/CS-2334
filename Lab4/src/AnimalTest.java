import org.junit.Test;
import org.junit.Assert;

/**
 * Testing class for Product object
 * 
 * @author Stephen Thung
 * @version 2018-09-10
 */
public class AnimalTest 
{

    /**
     * Test the empty Product constructor and the getters
     */
    @Test
    public void emptyConstructorTest()
    {
        //Use the default constructor
        Animal animal = new Animal();

        //The name should be null, and the price and weight zero
        Assert.assertEquals("unknown", animal.getSpecies());
        Assert.assertEquals("noname", animal.getName());
        Assert.assertEquals(0, animal.getAge());
        Assert.assertEquals(0, animal.getWeight(), 0.01);

    }

    /**
     * Test full constructor and the getters
     */
    @Test
    public void fullConstructorTest() 
    {
        // Use full constructor
        Animal animal = new Animal("Tiger", "Tony", 200.1, 20);

        /*
         * The name should match its initial parameter,
         * and the weight and price should equal their 
         * initial values
         */
        Assert.assertEquals("Tiger", animal.getSpecies());
        Assert.assertEquals("Tony", animal.getName());
        Assert.assertEquals(20, animal.getAge());
        Assert.assertEquals(200.1, animal.getWeight(), 0.01);
    }

    /**
     * Test the String representation of an Product
     */
    @Test
    public void animalToStringTest()
    {
        Animal animal = new Animal("Tiger", "Tony", 200.11, 20);

        String actual = animal.toString().replaceAll("\\s", "");
        String expected = "Tony, a Tiger. 200.1 pounds, 20 years old\n".replaceAll("\\s", "");
        Assert.assertEquals(expected, actual);
    }
}

