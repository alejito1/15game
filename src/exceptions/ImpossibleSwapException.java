package exceptions;

/**
 * The class ImpossibleSwapException is an exception that happens when a swap is impossible.
 */
public class ImpossibleSwapException extends Exception {
    private int xSwapPos;
    private int ySwapPos;
    /**
     * create an instance of ImpossibleSwapException.
     * @param message
     */
    public ImpossibleSwapException(String message, int xSwapPos, int ySwapPos) {
        super(message);
        this.xSwapPos = xSwapPos;
        this.ySwapPos = ySwapPos;
    }

    /**
     * get the movement x position
     * @return movement x position
     */
    public int getXSwapPos() {
        return xSwapPos;
    }
    /**
     * get the movement y position
     * @return movement y position
     */
    public int getYSwapPos() {
        return ySwapPos;
    }
}
