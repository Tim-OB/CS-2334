/**
 * A class representing a simple calculator. The calculator takes in an input
 * string and interprets it as a command. The calculator evaluates the command
 * and returns a result.
 * 
 * @author CS2334, modified by Stephen Thung, Tim O'Brien
 * @version 2018-09-22
 */

public class Calculator
{
    /**
     * This constructor has been added to trick the code coverage measure into doing
     * the right thing
     */
    public Calculator()
    {
        // Constructor does nothing
    }

    /**
     * Takes an input command of two string tokens and simulates a calcaultor
     * command. The token length should never be something either than 2. If it is,
     * there is an issue in execute(). The input expects the two tokens formatted in
     * a String array in the form of [command, number]. Valid commands are
     * "increment" and "decrement". Each command takes an int value as a parameter.
     * e.g. "increment 5" passed in as an array ["increment", "5"] returns a result
     * of 6 "decrement 6" passed in as an array ["decrement", "6"] returns a result
     * of 5
     * 
     * If the input is invalid, exceptions will be thrown with the following
     * precedence: (0) NumberFormatException The input number is not an int: look at
     * Integer.parseInt. This exception is thrown automatically if the string that
     * you try and parse is not an int value) (1) CalculatorException("Illegal
     * Command", 1) The input command is neither increment or decrement. You must
     * throw this exception explicitly. The line will look similar to "throw new
     * CalculatorException(<<message>>, <<type>>);"
     * 
     * @param tokens The input string to the program tokenized (split up). Should be
     *               a String array of two elements: [command, number].
     * @return The result of the calculator operation ("increment number" or
     *         "decrement number")
     * @throws NumberFormatException Thrown if the second token is not convertible
     *                               from String to int.
     * @throws CalculatorException   Thrown if the first token is not a valid
     *                               command ("increment" or "decrement")
     */
    protected static int calculateTwoTokens(String[] tokens) throws NumberFormatException, CalculatorException
    {
        int a = Integer.parseInt(tokens[1]); // Throws NumberFormatException if the second token is not an int value.
        String command = tokens[0];
        // TODO: execute the correct command, throw exception if invalid command. See
        // javadoc above.

        if (command.equalsIgnoreCase("increment"))
        {
            a++;
        } else if (command.equalsIgnoreCase("decrement"))
        {
            a--;
        } else
        {
            throw new CalculatorException("Illegal Command", 1);
        }

        return a;

    }

    /**
     * Takes an input command of three string tokens and performs the appropriate
     * calculator command. The token length should never be something either than 3.
     * If it is, there is an issue in execute(). The input expects the three tokens
     * formatted in a String array in the form of [command, num1, num2]. Valid
     * commands are (numbers must be int values): "add num1 num2" => return num1 +
     * num2 "subtract num1 num2" => return num1 - num2 "divide num1 num2" => return
     * num1 / num2
     * 
     * If the input is invalid, exceptions will be thrown with the following
     * precedence: (0) NumberFormatException Either input number is not an int: look
     * at Integer.parseInt. This exception is thrown automatically if the string
     * that you try and parse is not an int value) (1) CalculatorException("Illegal
     * Command", 1) The input command is neither increment or decrement. You must
     * throw this exception explicitly. The line will look similar to "throw new
     * CalculatorException(<<message>>, <<type>>);" (2) ArithmeticException The
     * command is "divide" and both numbers are int; the second number is 0. If you
     * attempt to perform num1 / num2, this exception will automatically be
     * performed. You should not need to explicitly throw this exception.
     * 
     * @param tokens The input string to the program tokenized (split up). Should be
     *               a String array of three elements: [command, num1, num2].
     * @return The result of the calculator operation ("add num1 num2", "subtract
     *         num1 num2", or "divide num1 num2")
     * @throws ArithmeticException   A division by zero has occured.
     * @throws NumberFormatException Thrown if the second or third token is not
     *                               convertible from String to int.
     * @throws CalculatorException   Thrown if the first token is not a valid
     *                               command ("add", "subtract", or "divide")
     */
    protected static int calculateThreeTokens(String[] tokens)
            throws ArithmeticException, NumberFormatException, CalculatorException
    {
        // TODO: execute the correct command, throw exception if invalid command or
        // number is not convertible to
        // and int. See javadoc above.
        int a = Integer.parseInt(tokens[1]);
        int b = Integer.parseInt(tokens[2]);
        int c = 0;

        String command = tokens[0];

        if (command.equalsIgnoreCase("divide"))
        {
            c = a / b;
        } else if (command.equalsIgnoreCase("add"))
        {
            c = a + b;
        } else if (command.equalsIgnoreCase("subtract"))
        {
            c = a - b;
        } else
        {
            throw new CalculatorException("Illegal Command", 1);
        }

       

        return c;
    }

    /**
     * Execute the expression encoded in a sequence of tokens.
     * 
     * For each number of tokens that the program receives, it may behave in
     * different ways. That is, for each number of tokens, the program expects a
     * certain format of input. When the input does not match its expectations, the
     * program should throw an exception. Follow the below cases to determine when
     * you should throw an exception. The cases outline all possibilities for inputs
     * - all the ways an input can be formatted both correctly and incorrectly, and
     * how to choose what to do as a result (operate normally or throw and
     * exception).
     * 
     * 0 tokens: throw a CalculatorException(message="Illegal Token Length", type=0)
     * 1 token: token[0] = "quit": return Integer.MIN_VALUE (i.e. the program should
     * quit) token[0] = anything else: throw a CalculatorException(message="Illegal
     * Command", type=1) 2 tokens: return the result of calculateTwoTokens(tokens) 3
     * tokens: return the result of calculateThreeTokens(tokens) 4+ tokens: throw a
     * CalculatorException(message="Illegal Token Length", type=0)
     * 
     * @param tokens The input string to the calculator split into tokens and passed
     *               as a String array.
     * @throws ArithmeticException   A division by zero has occured.
     * @throws NumberFormatException Thrown if the second [or third] token is not
     *                               convertible from String to int.
     * @throws CalculatorException   Thrown if the first token is not a valid
     *                               command ("quit", "increment", "decrement"
     *                               "add", "subtract", "divide")
     */
    protected static int execute(String[] tokens) throws NumberFormatException, CalculatorException
    {
        // Condition on the number of tokens (number of strings in user input separated
        // by spaces)

        switch (tokens.length)
        {
            // TODO: complete this. See javadoc above.
            case 0:
                throw new CalculatorException("Illegal Token Length", 0);

            case 1:
                if (tokens[0].equals("quit"))
                {
                    return Integer.MIN_VALUE;
                } else
                {
                    throw new CalculatorException("Illegal Command", 1);
                }

            case 2:
                return calculateTwoTokens(tokens);

            case 3:
                return calculateThreeTokens(tokens);

            default:
                throw new CalculatorException("Illegal Token Length", 0);

        }

    }

    /**
     * Parse and tokenize (split up) the input string as an expression. Call into
     * execute() with the tokenized string to get the result of executing the
     * command. Valid commands are: "quit" - the program should quit "increment" -
     * an int should be incremented by 1 "decrement" - an int should be decremented
     * by 1 "add" - two numbers should be added "subtract" - a number should be
     * subtracted from another "divide" - a number should be divided by another
     * 
     * @param input A String possibly containing a calculator command. Tokens of the
     *              command are separated by space. e.g. A valid command would be
     *              "add 50 20". This will be split up (Tokenized) as an array of
     *              three Strings: ["add", "50", "20"].
     * @return The following values are returned under the given conditions: (1)
     *         "quit" - if the program should end (2) "The result is: %d", where %d
     *         is replaced with the returned value of execute(tokens) - the command
     *         is executed correctly and is not "quit". (3) "Attempted to divide by
     *         0. Please try again." - an ArithmeticException has been caught. (4)
     *         "Input number cannot be parsed to an int. Please try again." - a
     *         NumberFormat has been caught. (5) "Calculator Exception of type %d,
     *         message is: %s", where %d and %s are the type and message of a
     *         CalculatorException, respectively - a CalculatorException has been
     *         caught.
     */
    public static String parseAndExecute(String input)
    {
        // Pull out the tokens
        String[] tokens = input.split(" ");
        String out = "";

        try
        {
            // TODO: use execute() to attempt to evaluate the sequence of tokens
            // Quit if the command was "quit". Else, return a string for successful command
            // completion. See javadoc.

            int ex = execute(tokens);

            if (ex == Integer.MIN_VALUE)
            {
                out = String.format("%s", "quit");
            } else
            {
                out = String.format("The result is: %d", ex);
            }

        }
        // TODO: catch exceptions. Return appropriate values. See javadoc above.
        catch (CalculatorException e)
        {

            System.out.format("Calculator Exception of type %d, message is: %s", e.getType(), e.getMessage());
        } catch (NumberFormatException e)
        {
            System.out.println("Input number cannot be parsed to an int. Please try again.");
        } catch (ArithmeticException e)
        {
            System.out.println("Attempted to divide by 0. Please try again.");
        }

        return out;
    }
}
