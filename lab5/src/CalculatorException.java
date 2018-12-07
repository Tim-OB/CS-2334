/**
 * Exception class for representing exceptions that can occur within a
 * Calculator. Calculator exceptions have a message and a type (int).
 * 
 * @author Stephen, Tim O'Brien
 * @version 2018-09-23
 */
public class CalculatorException extends Exception
{
    /**
     * Added to disable warnings.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The type of Calculator Exception. Valid types have the corresponding
     * messages: 0: "Illegal Token Length" 1: "Illegal Command"
     */
    private int type;

    /**
     * Sets the message and type. Uses super constructor to set the message.
     * 
     * @param message The message of the Calculator Exception. Should be "Illegal
     *                Token Length" or "Illegal Command", as corresponding to the
     *                type. Passed to superclass Exception.
     * @param type    The type of Calculator Exception. Should be 0 or 1.
     */
    public CalculatorException(String message, int type)
    {
        // TODO: implement this.
        super(message);
        this.type = type;
    }

    /**
     * Gets the type.
     * 
     * @return The CalculatorException type.
     */
    public int getType()
    {
        // TODO: implement this.
        return type;
    }
}