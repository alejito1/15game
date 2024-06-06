package exceptions;

/**
 * The class ImpossibleSwapException is an exception that happens when someone try to swap a number out of the range
 */
public class OutOfRangeException extends Exception{
    /**
     * create an instance of OutOfRangeException
     * @param message
     */
    public OutOfRangeException(String message) {
        super(message);
    }
}
