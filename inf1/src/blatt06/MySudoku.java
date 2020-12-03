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
          // System.out.println("checking x: " + x + " y: " + y +
          //                    " inhalt: " + value);
          if (value != 0)
            continue;

          success = false;
          BitSet checklist = new BitSet(10000);
          // check row
          for (int check : spielFeld[y]) {
            checklist.set(check, check == 0 ? false : true);
          }
          // check column
          for (int i = 0; i < ROW_SIZE; i++) {
            checklist.set(spielFeld[i][x], spielFeld[i][x] == 0 ? false : true);
          }

          // check block that checked field is in
          blockx = x / BLOCK_SIZE * BLOCK_SIZE;
          blocky = y / BLOCK_SIZE * BLOCK_SIZE;
          for (int bx = blockx; bx < blockx + BLOCK_SIZE; bx++) {
            for (int by = blocky; by < blocky + BLOCK_SIZE; by++) {
              checklist.set(spielFeld[by][bx],
                            spielFeld[by][bx] == 0 ? false : true);
            }
          }
          int count = 0;
          for (int i = checklist.nextSetBit(0); i >= 0;
               i = checklist.nextSetBit(i + 1)) {
            count++;
          }

          // System.out.println("check" + checklist.toString());
          if (count == 8) {
            for (int i = 1; i <= 9; i++) {
              if (!checklist.get(i)) {
                System.out.println("this needs number x: " + x + " y: " + y +
                                   " i: " + i);
                spielFeld[y][x] = i;
              }
            }
          }
          // System.out.println("count" + count);
        }
      }
      // success = true;
    }

    for (int[] feld : spielFeld) {
      System.out.println("lel" + Arrays.toString(feld));
    }
  }
}
