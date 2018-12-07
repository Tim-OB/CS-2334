
public abstract class AbstractObservation
{
    protected boolean valid;

    /**
     * Abstract observation constructor
     */
    protected AbstractObservation()
    {

        // An abstract method, required in UML, but never used.
    }

    /**
     * Abstract version of isValid
     * 
     * @return valid
     */
    protected boolean isValid()
    {
        return valid;
    }
}
