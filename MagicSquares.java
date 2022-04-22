/**
 * The MagicSquares program implements an application that
 * calls a function which uses recursion to determine all
 * of the possible magic squares when the magic nuber is 15.
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
     * Empty constructor for the program.
     *
     */
    MagicSquares() { }

    /**
     * Generates magic squares.
     *
     * @param square passed in
     * @param currentSquare passed in
     * @param index passed in
     */
    public static void genSquare(final int[] square, final int[] currentSquare,
        final int index) {
        /* referenced code from
        math.colostate.edu/~betten/courses/M152/LECTURE/lecture9.html
        */
        for (int counter = 0; counter < square.length; counter++) {

            // checks if position in array has been filled
            if (currentSquare[counter] == 0) {
                currentSquare[counter] = 1;
                square[index] = counter + 1;

                if (index < square.length - 1) {
                    // calls function with incremented index position
                    genSquare(square, currentSquare, index + 1);
                } else {
                    // checks if array is a magic square
                    if (isMagic(square)) {
                        printMagicSquare(square);
                    }
                }
                // resets position to be empty
                currentSquare[counter] = 0;
            }
        }
    }

    /**
     * This function returns true or false for whether
     * or not array is a magic square.
     *
     * @param preSquare passed in
     * @return if all possible combinations equal 15
     */
    public static boolean isMagic(final int[] preSquare) {
        // initializing variables that determine sum for combinations
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        // copies results back to genSquare function
        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
              && col1 == MAGICNUM && col2 == MAGICNUM
              && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
     * Prints inputted array in a magic square format.
     *
     * @param outputSquare passed in
     */
    public static void printMagicSquare(final int[] outputSquare) {
        // declaring variables
        final String border = "\n*****";
        final String space = " ";

        System.out.println(border);

        // loops through each index in each array to format
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + space);
            } else {
                System.out.print(outputSquare[count] + space);
            }
        }
        System.out.println(border);
    }

    /**
     * Main entry into program.
     *
     * @param args nothing passed in
     */
    public static void main(final String[] args) {
        // initializing arrays
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE,
            SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};

        System.out.println();
        System.out.println("All Possible Magic Squares (3x3):");

        // function call to generate magic sqare
        genSquare(magicSquare, extraArray, 0);
    }
}
