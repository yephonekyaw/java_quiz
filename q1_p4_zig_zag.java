import java.util.Scanner;

/**
 * ZigZag
 */
public class q1_p4_zig_zag {

    // zig zag traversing algorithm
    // I suggest you to trace how this algorithm works with pen & paper
    // some parts can only be visualized with pen & paper
    static int[][] zig_zag(int row, int col) {
        int[][] zig_zag_mat = new int[row][col];
        int x = 0, y = 0, index = 1;

        // always starts with the first index, thus [0][0] is 1
        // then column index changes to the right column
        zig_zag_mat[0][0] = index;
        index++;
        y++;

        // we will run the while loop until x reachs the last row index and y reaches
        // the last col index
        while (x != row - 1 || y != col - 1) {
            // there are two cases to consider and each case has two seperate scenarios
            // first if x is 0 or y is col - 1, the pattern will go downward
            if (x == 0 || y == col - 1) {
                while (y >= 0 && x < row) {
                    zig_zag_mat[x][y] = index;
                    index++;
                    x++;
                    y--;
                }

                // this if case can easily be traced if you use pen & paper
                if (x == row) {
                    y += 2;
                    x = row - 1;
                } else {
                    y = 0;
                }

            } else if (y == 0 || x == row - 1) {
                // second if y is 0 or x is row - 1, the pattern will go upward
                while (x >= 0 && y < col) {
                    zig_zag_mat[x][y] = index;
                    index++;
                    x--;
                    y++;
                }

                // this if case can easily be traced if you use pen & paper
                if (y == col) {
                    x += 2;
                    y = col - 1;
                } else {
                    x = 0;
                }

            }
        }

        // finall insert into the last index
        zig_zag_mat[row - 1][col - 1] = index;

        return zig_zag_mat;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int row = scan.nextInt();
        int col = scan.nextInt();

        // everything will happen in this function call
        int[][] zig_zag_mat = zig_zag(row, col);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(zig_zag_mat[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}