package exceptions;

/**
 * The class ImpossibleSwapException is an exception that happens when someone try to swap zero.
 */
public class SwapZeroException extends Exception {
    /**
     * create an instance of SwapZeroException
     * @param message
     */
    public SwapZeroException(String message) {
        super(message);
    }
}
