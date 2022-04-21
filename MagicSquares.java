/**
 * The MagicSquares program implements an application that
 * asks the user to choose rock, paper, or scissors, then
 * generates a random selection and tells the user if they
 * have won, lost, or tied.
 *
 * @author  Ina Tolo
 * @version 1.0
 * @since   2022-4-20
 */

class MagicSquares {

    /**
     * The middle left index.
     */
    public static final int THREE = 3;
    /**
     * The center index.
     */
    public static final int FOUR = 4;
    /**
     * The middle right index.
     */
    public static final int FIVE = 5;
    /**
     * The lower left index.
     */
    public static final int SIX = 6;
    /**
     * The lower center index.
     */
    public static final int SEVEN = 7;
    /**
     * The lower right index.
     */
    public static final int EIGHT = 8;
    /**
     * The maximum number for magicNumbers.
     */
    public static final int NINE = 9;
    /**
     * The maximum number for magicNumbers.
     */
    public static final int MAGICNUM = 15;

    /**
     * Constructor.
     */
    private MagicSquares() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
     * Insert function description.
     *
     * @param square passed in
     * @param currentSquare passed in
     * @param index passed in
     */
    public static void genSquare(int[] square, int[] currentSquare,
        int index) {
        // referenced code from https://www.math.colostate.edu/~betten/courses/M152/LECTURE/lecture9.html
        for (int counter = 1; counter < 9; counter++) {
            // System.out.println("test string");
            
            if (currentSquare[counter] == 0) {
                currentSquare[counter] = index;
                square[counter] = 1;
                
                if (index < 9) {
                    genSquare(square, currentSquare, index + 1);
                } else {
                    final boolean magicCheck = isMagic(square);
                    if (magicCheck == true) {
                        printMagicSquare(currentSquare);
                    } else {
                        // index = 0;
                    }
                }
                currentSquare[counter] = 0;
            }
        }
        index = 1;
        genSquare(square, currentSquare, index = 1);
        // generate the magic sqaure
    }

    /**
     * Insert function description.
     *
     * @param preSquare passed in
     */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
     * Insert function description.
     *
     * @param outputSquare passed in
     */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 1);
    }
}
