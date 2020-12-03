package blatt06;

import java.util.*;
/**
 * Pruefen eines 9x9 Sudokus
 *
 * @author paperbenni@gmail.com,<br>
 * 		   paperbenni.github.io
 */

public class MySudoku {

  private final int BLOCK_SIZE = 3;
  private final int ROW_SIZE = BLOCK_SIZE * BLOCK_SIZE;

  private int[][] spielFeld =
      /* |---------|---------|---------| */
      {{5, 3, 0, 0, 7, 0, 0, 0, 0},
       {6, 0, 0, 1, 9, 5, 0, 0, 0},
       {0, 9, 8, 0, 0, 0, 0, 6, 0},
       /* |---------|---------|---------| */
       {8, 0, 0, 0, 6, 0, 0, 0, 3},
       {4, 0, 0, 8, 0, 3, 0, 0, 1},
       {7, 0, 0, 0, 2, 0, 0, 0, 6},
       /* |---------|---------|---------| */
       {0, 6, 0, 0, 0, 0, 2, 8, 0},
       {0, 0, 0, 4, 1, 9, 0, 0, 5},
       {0, 0, 0, 0, 8, 0, 0, 7, 9}};

  public static void main(String[] args) {
    MySudoku testSudoku = new MySudoku();
    testSudoku.checkSudoku();
  }

  public void checkSudoku() {

    int value;
    int counter;
    boolean success = false;
    int blockx, blocky;

    while (!success) {
      success = true;
      // iterate over all fields to find all numbers
      // that this field cannot contain. if there only is
      // one possible number, fill in the field
      // sudoku has to be solvable

      for (int x = 0; x < ROW_SIZE; x++) {
        for (int y = 0; y < ROW_SIZE; y++) {
          value = spielFeld[y][x];
          System.out.println("hello x: " + x + " y: " + y +
                             " inhalt: " + value);
          if (value != 0)
            continue;

          success = false;
          counter = 0;
          BitSet checklist = new BitSet(10);
          // check row
          for (int check : spielFeld[y]) {
            checklist.set(check, 1);
          }
          // check column
          for (int i = 0; i < ROW_SIZE; i++) {
            checklist.set(spielFeld[i][x], 1);
          }

          // check block that checked field is in
          blockx = x / BLOCK_SIZE * BLOCK_SIZE;
          blocky = y / BLOCK_SIZE * BLOCK_SIZE;
          for (int bx = blockx; bx < blockx + BLOCK_SIZE; bx++) {
            for (int by = blocky; by < blocky + BLOCK_SIZE; by++) {
                checklist.set(spielFeld[by][bx]);
            }
          }
        }

      }
    }
  }
}
