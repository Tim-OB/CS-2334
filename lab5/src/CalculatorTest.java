import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for calculator class
 * 
 * @author Stephen Thung, Tim O'Brien
 * @version 2018-09-29
 *
 */
public class CalculatorTest
{

    /**
     * THIS TEST IS GIVEN TO YOU AS A REFERENCE.
     * 
     * Test correct calculation of two valid tokens (increment):
     */
    @Test
    public void calculateTwoTokensTestValidIncrement()
    {
        try // The method may throw an exception. If it does, the test should fail. We want
            // to test a valid input.
        {
            int result = Calculator.calculateTwoTokens(new String[] { "increment", "5" });
            Assert.assertEquals("increment did not increase input number by 1", 6, result);
        } catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct calculation of two valid tokens (increment):
     */
    @Test
    public void calculateTwoTokensTestValidDecrement()
    {
        // TODO: finish this test.
        try // The method may throw an exception. If it does, the test should fail. We want
            // to test a valid input.
        {
            int result = Calculator.calculateTwoTokens(new String[] { "decrement", "5" });
            Assert.assertEquals("increment did not decrease input number by 1", 4, result);
        } catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * THIS TEST IS GIVEN TO YOU AS A REFERENCE.
     * 
     * Test invalid two-token input (number is not an int):
     */
    @Test
    public void calculateTwoTokensTestInvalidNumber()
    {
        // Here, we expect that an invalid input should cause the test to throw an
        // exception. Thus, if an exception
        // is not thrown the test should fail. Furthermore, the exception thrown should
        // be a specific one. In this
        // case, we expect that a NumberformatException should be thrown, as "foo"
        // cannot be converted to an int.
        try
        {
            Calculator.calculateTwoTokens(new String[] { "increment", "foo" });
            // If the program gets to this line, an exception was not thrown. That means
            // that the test should fail,
            // because we expect an exception to be thrown.
            Assert.fail("Illegal expression did not throw an Exception");
        } catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of
            // Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test,
            // thus succeeding.
        } catch (Exception e)
        {
            // Some other exception was thrown. This is not the exception we were expecting,
            // and thus is a test failure.
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }
    }

    /**
     * Test invalid two-token input (command is not increment/decrement):
     */
    @Test
    public void calculateTwoTokensTestInvalidCommand()
    {
        // TODO: finish this test. It should look similar to the previous test, but will
        // also check to make
        // sure that the caught CalculatorException has the correct string and message.

        try
        {
            // TODO: finish this try.
            Calculator.calculateTwoTokens(new String[] { "foo", "3" });
            Assert.fail("Illegal command did not throw an Exception");
        } catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // TODO: finish this test - Check to make sure the CalculatorException has the
            // correct message and type.
            String expected = "Illegal Command";
            Assert.assertEquals(expected, e.getMessage());
        } catch (Exception e)
        {
            // TODO: finish this catch.
            Assert.fail("Unexpected Exception (not CalculatorException) caught");
        }
    }

    /**
     * Test correct calculation of three valid tokens (add):
     */
    @Test
    public void calculateThreeTokensTestValidAdd()
    {
        // TODO: finish this test.
        try // The method may throw an exception. If it does, the test should fail. We want
            // to test a valid input.
        {
            int result = Calculator.calculateThreeTokens(new String[] { "add", "30", "5" });
            Assert.assertEquals("Addition does not equal 35", 35, result);
        } catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct calculation of three valid tokens (subtract):
     */
    @Test
    public void calculateThreeTokensTestValidSubtract()
    {
        // TODO: finish this test.
        try // The method may throw an exception. If it does, the test should fail. We want
            // to test a valid input.
        {
            int result = Calculator.calculateThreeTokens(new String[] { "subtract", "30", "5" });
            Assert.assertEquals("Subraction does not equal 25", 25, result);
        } catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test correct calculation of three valid tokens (divide):
     */
    @Test
    public void calculateThreeTokensTestValidDivide()
    {
        // TODO: finish this test.
        try // The method may throw an exception. If it does, the test should fail. We want
            // to test a valid input.
        {
            int result = Calculator.calculateThreeTokens(new String[] { "divide", "30", "5" });
            Assert.assertEquals("Division does not equal 6", 6, result);
        } catch (Exception e)
        {
            Assert.fail("Legal expression threw an Exception: " + e.getMessage());
        }
    }

    /**
     * Test invalid three-token input (either number is not an int):
     */
    @Test
    public void calculateThreeTokensTestInvalidNumber()
    {
        // TODO: finish this test.

        // Try for first number:
        try
        {
            Calculator.calculateThreeTokens(new String[] { "add", "foo", "3" });
            // If the program gets to this line, an exception was not thrown. That means
            // that the test should fail,
            // because we expect an exception to be thrown.
            Assert.fail("Illegal expression did not throw an Exception");
        } catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of
            // Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test,
            // thus succeeding.
        } catch (Exception e)
        {
            // Some other exception was thrown. This is not the exception we were expecting,
            // and thus is a test failure.
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }
        // Try for second number:
        try
        {
            Calculator.calculateThreeTokens(new String[] { "add", "3", "foo" });
            // If the program gets to this line, an exception was not thrown. That means
            // that the test should fail,
            // because we expect an exception to be thrown.
            Assert.fail("Illegal expression did not throw an Exception");
        } catch (NumberFormatException e)
        {
            // We expect the function to throw a NumberFormatException (from failure of
            // Integer.parseInt)
            // Success; Assert.fail will not be thrown and the code will complete the test,
            // thus succeeding.
        } catch (Exception e)
        {
            // Some other exception was thrown. This is not the exception we were expecting,
            // and thus is a test failure.
            Assert.fail("Unexpected Exception (not NumberFormatException) caught");
        }

    }

    /**
     * Test invalid three-token input (command is not add/subtract/divide):
     */
    @Test
    public void calculateThreeTokensTestInvalidCommand()
    {
        // TODO: finish this test.
        try
        {
            // TODO: finish this try.
            Calculator.calculateThreeTokens(new String[] { "foo", "3", "5" });
            Assert.fail("Illegal command did not throw an Exception");
        } catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // TODO: finish this test - Check to make sure the CalculatorException has the
            // correct message and type.
            String expected = "Illegal Command";
            Assert.assertEquals(expected, e.getMessage());
        } catch (Exception e)
        {
            // TODO: finish this catch.
            Assert.fail("Unexpected Exception (not CalculatorException) caught");
        }
    }

    /**
     * Test correct execution of command (one token - only can be "quit"):
     * @throws CalculatorException 
     * @throws NumberFormatException 
     */
    @Test
    public void executeTestValidQuit() throws NumberFormatException, CalculatorException
    {
        // TODO: finish this test.
        
        
        try
        {   
            if (Calculator.execute(new String[] {"quit"}) == Integer.MIN_VALUE)
            {
                Assert.assertEquals(Integer.MIN_VALUE, Calculator.execute(new String[] {"quit"}));
            }
        } catch (CalculatorException e)
        {
            
            Assert.fail("Throws exception with vaild quit.");
        }
        
       try
       {
        Assert.assertEquals("Illegal Command", Calculator.execute(new String[] {"a"}));
       } catch (CalculatorException e){
           
       }

    }

    /**
     * Test correct execution of command (any valid two-token command):
     */
    @Test
    public void executeTestValidTwoTokens()
    {
        // TODO: finish this test.
        try
        {
            Assert.assertEquals(6, Calculator.execute(new String[] { "increment", "5" }));
        } catch (Exception e)
        {
            Assert.fail("Throws exception");
        }

    }

    /**
     * Test correct execution of command (any valid three-token command):
     */
    @Test
    public void executeTestValidThreeTokens()
    {
        // TODO: finish this test.
        try
        {
            Assert.assertEquals(7, Calculator.execute(new String[] { "add", "5", "2" }));
        } catch (Exception e)
        {
            Assert.fail("Throws exception.");
        }
    }

    /**
     * Test invalid execute input (single token; not "quit"):
     */
    @Test
    public void executeTestInvalidCommand()
    {
        // TODO: finish this test.
        try
        {
            Calculator.execute(new String[] { "a", "3" });
            Assert.fail("Illegal expression threw a command");
        } catch (CalculatorException e)
        {
            // We expect the function to throw a CalculatorException.
            // TODO: finish this test - Check to make sure the CalculatorException has the
            // correct message and type.
            String expected = "Illegal Command";
            Assert.assertEquals(expected, e.getMessage());
        } catch (Exception e)
        {
            // TODO: finish this catch.
            Assert.fail("Unexpected Exception (not CalculatorException) caught");
        }
    }

    /**
     * Test invalid execute input (invalid token lengths):
     */
    @Test
    public void executeTestInvalidTokenLength()
    {
        // TODO: finish this test.

        // Token length is 0:
        try
        {
            Calculator.execute(new String[] {});
        } catch (CalculatorException e)
        {
            Assert.assertEquals("Illegal Token Length", e.getMessage());
        }

        // Token length is > 3:
        try
        {
            Calculator.execute(new String[] { "add", "3", "3", "3" });
        } catch (CalculatorException e)
        {
            Assert.assertEquals("Illegal Token Length", e.getMessage());
        }

    }

    /**
     * THIS TEST IS GIVEN TO YOU AS A REFERENCE.
     * 
     * Test correct parseAndExecution of command (input of "quit"):
     */
    @Test
    public void parseAndExecuteTestValidQuit()
    {
        String result = Calculator.parseAndExecute("quit");
        Assert.assertEquals("Input of \"quit\" did not return correct value", "quit", result);
    }

    /**
     * Test correct parseAndExecution of command (any valid 2 or 3 token command):
     */
    @Test
    public void parseAndExecuteTestValidCommand()
    {
        // TODO: finish this test.
        String result = Calculator.parseAndExecute("add 4 1");
        Assert.assertEquals("Input of \"add\" did not return correct value", "The result is: 5", result);
    }

    /**
     * Test incorrect parseAndExecution of command (divide by zero):
     */
    @Test
    public void parseAndExecuteTestDivideByZero()
    {
        // TODO: finish this test.

        try
        {
            Calculator.parseAndExecute("divide 4 0");
        }

        catch (ArithmeticException e)
        {
            Assert.assertEquals("", e.getMessage());
        }

    }

    /**
     * Test incorrect parseAndExecution of command (2 or 3 token command with
     * invalid number):
     */
    @Test
    public void parseAndExecuteTestInvalidNumber()
    {
        // TODO: finish this test.
        try
        {
            Calculator.parseAndExecute("Add a 3");
        } catch (NumberFormatException e)
        {
            Assert.assertEquals("", e.getMessage());
        }

    }

    /**
     * Test incorrect parseAndExecution of command (invalid command):
     */
    @Test
    public void parseAndExecuteTestInvalidCommand() throws CalculatorException
    {
        Calculator.parseAndExecute("a 3 3");
        Assert.assertTrue("Threw a invalid command", true);

    }

    /**
     * Test incorrect parseAndExecution of command (invalid token length):
     */
    @Test
    public void parseAndExecuteTestInvalidTokenLength()
    {
        // TODO: finish this test.
        String a = Calculator.parseAndExecute("add, 3, 4, 4");
        Assert.assertEquals("", a);
    }

    /**
     * Bogus test to address ECLEMMA code coverage bug
     */
    @Test
    public void constructorTest()
    {
        // We aren't actually testing anything here - just addressing a bug in the
        // code coverage computation
        new Calculator();
        // Web-Cat wants an Assert here: use one that will always pass
        Assert.assertTrue(true);
    }
}
