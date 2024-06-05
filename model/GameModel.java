package view;

import exceptions.ImpossibleSwapException;
import exceptions.OutOfRangeException;
import exceptions.SwapZeroException;

import java.util.Random;

/**
 * GameModel is responsible for manage the game data.
 */
public class GameModel {
    private int[][] board = new int[4][4];
    private Random random;

    private int zeroXPos;
    private int zeroYPos;

    /**
     * Initialize The Game Model
     */
    public GameModel(){
        board = new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        random = new Random();
        zeroXPos = 3;
        zeroYPos = 3;
    }

    /**
     * Return the board value
     * @return board
     */
    public int[][] getBoard(){
        return board;
    }

    /**
     * Change the board
     * @param board an 4 * 4 int matrix
     */
    public void setBoard(int[][] board){
        this.board = board;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    zeroXPos = j;
                    zeroYPos = i;
                }
            }
        }
    }

    /**
     * return zero x value
     * @return zero x value
     */
    public int getZeroXPos() {
        return zeroXPos;
    }
    /**
     * return zero y value
     * @return zero y value
     */
    public int getZeroYPos() {
        return zeroYPos;
    }

    /**
     * Shuffle the board
     */
    public void shuffle(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //shuffle nums
        for(int i = 0; i < nums.length; i++){
            int rand = random.nextInt(nums.length);
            int temp = nums[rand];
            nums[rand] = nums[i];
            nums[i] = temp;
        }
        //add the numbers to the board
        int k = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(k == 15) continue;
                board[i][j] = nums[k];
                k++;
            }
        }
        //add 0 to board
        board[3][3] = 0;
        zeroXPos = 3;
        zeroYPos = 3;
    }

    /**
     * Swap a number next to zero with zero's position
     * @param numToSwap number between 1 and 15 next to zero
     * @throws ImpossibleSwapException if the number isn't next to zero.
     * @throws SwapZeroException if the number is zero.
     * @throws OutOfRangeException if the number isn't between 1 and 15.
     */
    public void swapWith0(int numToSwap) throws ImpossibleSwapException, SwapZeroException, OutOfRangeException {
        //check impossibles swaps
        if(numToSwap == 0){
            throw new SwapZeroException("Attempt to try to move 0.");
        }
        if(numToSwap <= 0 || numToSwap > 15){
            throw new OutOfRangeException("Number " + numToSwap + " don't exist in the game");
        }
        int x = 0;
        int y = 0;
        //get number position
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == numToSwap){
                    x = j;
                    y = i;
                }
            }
        }

        if(x + 1 == zeroXPos && y == zeroYPos){
            swap0(x, y);
        } else if (x - 1 == zeroXPos && y == zeroYPos) {
            swap0(x, y);
        } else if (y + 1 == zeroYPos && x == zeroXPos) {
            swap0(x, y);;
        } else if (y - 1 == zeroYPos && x == zeroXPos) {
            swap0(x, y);
        } else {

            throw new ImpossibleSwapException("board["+x+"]["+y+"] isn't is next to zero", x, y);
        }
    }

    /**
     * swap a number of the matrix with 0
     * @param x number x position
     * @param y number y position
     */
    private void swap0(int x, int y){
        board[zeroYPos][zeroXPos] = board[y][x];
        board[y][x] = 0;
        zeroXPos = x;
        zeroYPos = y;
    }
}
