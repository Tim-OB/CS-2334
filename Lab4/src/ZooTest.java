import org.junit.Assert;
import org.junit.Test;

/**
 * Testing class for the Zoo class
 * 
 * @author Stephen Thung, Tim O'Brien
 * @version 2018-09-13
 */
public class ZooTest
{
    /**
     * Test the empty constructor
     */
    @Test
    public void emptyConstructorTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        Assert.assertEquals(0, zoo.getTotalWeight(), 0.01);
        Assert.assertEquals(0, zoo.getAverageAge());
        Assert.assertEquals(0, zoo.getSize());
    }

    /**
     * Test adding an product to the zoo
     */
    @Test
    public void addAnimalTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        // TODO: Create animals to add to the zoo
        Animal a = new Animal("Cheeah", "Cheser", 350.0, 40);
        Animal b = new Animal("Tigr", "Toy", 200.5, 15);

        // TODO: Add the animals to the Inventory;
        zoo.addAnimal(a);
        zoo.addAnimal(b);

        // TODO: test that the number of animals added (currentIndex) is updated
        // correctly.
        Assert.assertEquals(2, zoo.getSize());

        /*
         * The animals should be in the array and in the order added above.
         */
        Assert.assertEquals(a, zoo.getAnimals()[0]);
        Assert.assertEquals(b, zoo.getAnimals()[1]);
    }

    /**
     * DUE TO HIGHER COMPLEXITY, THIS TEST IS GIVEN TO YOU. YOU SHOULD NOT MODIFY
     * IT.
     * 
     * Test the zoo's ability to expand and meet the need of having adequate space
     * to add more animals when needed.
     */
    @Test
    public void extendArrayAndGetSizeTest()
    {
        // Use the default constructor
        Zoo zoo = new Zoo();

        /*
         * Attempt to force the animal array to expand. Fails when the array doesn't
         * realize it should get bigger and tries to add an product or when it tries to
         * insert an product in a non-existent position in the array,
         */
        try
        {
            for (int i = 0; i < 10; i++)
            {
                zoo.addAnimal(new Animal()); // Add empty Products to array
            }
        } catch (NullPointerException e) // Catch any point the array goes wrong
        {
            Assert.fail("The Product array attempted to access a non-existent " + "position in the product array.");
        }

        // Test the size of the new array
        Assert.assertEquals("Not all animals added as expected.", 10, zoo.getSize());
        Assert.assertEquals("animals array not expanded correctly.", 11, zoo.getAnimals().length);
    }

    /**
     * Tests the total weight calculation.
     */
    @Test
    public void getTotalWeightTest()
    {
        // TODO: set up zoo
        Zoo zoo = new Zoo();

        // TODO: Create at least 3 animals to add to the zoo
        Animal a = new Animal("Squirrel", "Scratch", 5.0, 20);
        Animal b = new Animal("Dog", "Bud", 100.0, 20);
        Animal c = new Animal("Bird", "Polly", 15.0, 20);

        // TODO: add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // TODO: test that sum of animal weights matches function return
        Assert.assertEquals(120.0, zoo.getTotalWeight(), .01);
    }

    /**
     * Tests the average age calculation.
     */
    @Test
    public void getAverageAgeTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();

        // Create at least 3 animals to add to the zoo
        Animal a = new Animal("Squirrel", "Scratch", 5.0, 10);
        Animal b = new Animal("Dog", "Bud", 100.0, 4);
        Animal c = new Animal("Bird", "Polly", 15.0, 7);

        // add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // Check that the average age is equal to the average obtained in the method
        Assert.assertEquals(7, zoo.getAverageAge());
    }

    /**
     * Tests the sum age for animals with a given name calculation.
     */
    @Test
    public void totalAgeWithNameTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();

        // Create at least 3 animals to add to the zoo
        Animal a = new Animal("Squirrel", "Bud", 5.0, 10);
        Animal b = new Animal("Dog", "Bud", 100.0, 4);
        Animal c = new Animal("Bird", "Bud", 15.0, 7);

        // add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // Check that the total age of animals with the same name
        // is equal to the total age obtained in the method
        Assert.assertEquals(21, zoo.totalAgeWithName("Bud"));
    }

    /**
     * Tests the number of animals for a species calculation
     */
    @Test
    public void numberAnimalsOfSpeciesTest()
    {
        // TODO: finish the test. You should use at least 3 animals.
        Zoo zoo = new Zoo();

        // Create at least 3 animals to add to the zoo
        Animal a = new Animal("Squirrel", "Scratch", 5.0, 10);
        Animal b = new Animal("Squirrel", "Bud", 100.0, 4);
        Animal c = new Animal("Bird", "Polly", 15.0, 7);

        // add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // Check that the average age is equal to the average obtained in the method
        Assert.assertEquals(2, zoo.numberAnimalsOfSpecies("Squirrel"));
    }

    /**
     * Test the string representation of the Inventory
     */
    @Test
    public void zooToStringTest()
    {
        // TODO: set up the zoo
        Zoo zoo = new Zoo();

        // TODO: Create animals to add to the zoo
        Animal a = new Animal("Squirrel", "Scratch", 5.0, 10);
        Animal b = new Animal("Squirrel", "Bud", 100.0, 4);
        Animal c = new Animal("Bird", "Polly", 15.0, 7);

        // TODO: Add the animals to the Inventory
        zoo.addAnimal(a);
        zoo.addAnimal(b);
        zoo.addAnimal(c);

        // TODO: Create the expected string
        String expected = "" + zoo.toString();

        // TODO: Test the string output produced by toString
        Assert.assertEquals(expected, zoo.toString());
    }
}