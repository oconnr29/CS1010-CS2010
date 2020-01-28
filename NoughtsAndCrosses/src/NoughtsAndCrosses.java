/* SELF ASSESSMENT 
   1. clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment:I used the correct method definition.
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment:I used loops to set each position to the BLANK character.
   2. printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:I used the correct method definition.
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment:I looped through the array and it prints out the board in a way that it looks like a board.
   3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:I had the correct function definition and returned the correct item.
Did I check if a specified location was BLANK?
Mark out of 5:5
Comment:I checked if a specified location was BLANK.
   4. makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:I had the correct function definition.
Did I set the currentPlayerPiece in the specified location?
Mark out of 5:5
Comment: I set the currentPlayerPiece in the specified location.
   5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment: I had the correct function definition and returned the correct item.
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment:I looped through the board to check if there are any BLANK characters.
   6. winner
Did I have the correct function definition and returned the winning character?
Mark out of 5:5
Comment:I had the correct function definition and returned the winning character.
Did I identify all possible horizontal, vertical and diagonal winners?
Mark out of 15:15
Comment:I identified all possible horizontal, vertical and diagonal winners.
   7.main
Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:I created a board of size 3 by 3 and used the clearBoard method to set all the positions to the BLANK character.
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments:I looped asking the user for a location until wither the board was full or there was a winner.
Did I call all of the methods above?
Mark out of 5:5
Comments:I called all of the methods above.
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments:I handled all incorrect locations provided by the user.
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments: I switched the current player piece from cross to nought and vice versa after every valid move.
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:3
Comments:I displayed the winning player piece or a draw at the end of the game.
   8. Overall
Is my code indented correctly?
Mark out of 3:3
Comments:My code is indented correctly.
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:My variable names and Constants make sense.
Do my variable names, method names and class name follow the Java coding standard.
Mark out of 2:2
Comments:My variable names, method names and class name follow the Java coding standard.
      Total Mark out of 100 (Add all the previous marks): 100
*/

import java.util.Scanner;

public class NoughtsAndCrosses {
	public static final int NUMBER_OF_ROWS = 3;
	public static final int NUMBER_OF_COLUMNS = 3;
	public static final char BLANK_SPACE = ' ';
	public static final char NO_WINNER = ' ';

	public static void main(String[] args) {
		char[][] board = new char[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		boolean finished = false;
		do {
			int row = 3;
			int column = 3;
			char currentPlayerPiece = 'X';
			clearBoard(board);
			printBoard(board);
			System.out.print("\nX goes first");
			boolean boardFull = isBoardFull(board);
			char winner = winner(board);
			int count = 0;
			do {
				Scanner input = new Scanner(System.in);
				System.out.print("\nInput co-ordinates of the place you want to move e.g.'1 a':");
				if (input.hasNext("1") || input.hasNext("2") || input.hasNext("3")) {
					String rowUserInput = input.next();
					char rowInput = rowUserInput.charAt(0);
					if (input.hasNext("a") || input.hasNext("b") || input.hasNext("c")) {
						String columnUserInput = input.next();
						char columnInput = columnUserInput.charAt(0);
						if (rowInput == '1') {
							row = 0;
						} else if (rowInput == '2') {
							row = 1;
						} else if (rowInput == '3') {
							row = 2;
						}
						if (columnInput == 'a') {
							column = 0;
						} else if (columnInput == 'b') {
							column = 1;
						} else if (columnInput == 'c') {
							column = 2;
						}
						if (canMakeMove(board, row, column)) {
							if (count % 2 == 0 || count == 0) {
								currentPlayerPiece = 'X';
							} else {
								currentPlayerPiece = 'O';
							}
							makeMove(board, currentPlayerPiece, row, column);
							boardFull = isBoardFull(board);
							winner = winner(board);
							count++;
						} else {
							System.out.print("That space is taken, please move again.");
						}
					} else {
						System.out.print("Invalid input:Input must be a number between 1 and 3 "
								+ "\nfollowed by a space followed by a lowercase letter between a and c.\n");
					}
				} else {
					System.out.print("Invalid input:Input must be a number between 1 and 3 "
							+ "\nfollowed by a space followed by a lowercase letter between a and c.\n");
				}
				printBoard(board);
			} while (!boardFull && winner == NO_WINNER);
			if (winner != NO_WINNER) {
				System.out.print("\n" + winner + " won the game.");
			}
			else {
				System.out.print("\nIt was a draw.");
			}
			Scanner secondInput = new Scanner(System.in);
			for (int index = 0; index < 1;) {
				System.out.print("\nWould you like to play again (yes/no):");
				String playAgain = secondInput.next();
				if (playAgain.equals("yes")) {
					index++;
				} else if (playAgain.equals("no")) {
					finished = true;
					index++;
				} else {
					System.out.print("Invalid input: Valid inputs include'yes' and 'no'.");
				}
			}
		} while (!finished);
		System.out.print("Goodbye.");
	}

	public static void clearBoard(char[][] board) {
		for (int count = 0; count < board.length; count++) {
			for (int index = 0; index < board.length; index++) {
				board[count][index] = BLANK_SPACE;
			}
		}
	}

	public static void printBoard(char[][] board) {
		System.out.print(" a b c\n" + "1" + board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n -----\n" + "2"
				+ board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n -----\n" + "3" + board[2][0] + "|"
				+ board[2][1] + "|" + board[2][2]);

	}

	public static boolean canMakeMove(char[][] board, int row, int column) {
		boolean canMove = false;
		if (row < 3 && column < 3) {

			if (board[row][column] == BLANK_SPACE) {
				canMove = true;
			}
		} else {
			canMove = true;
		}
		return canMove;
	}

	public static void makeMove(char[][] board, char currentPlayerPiece, int row, int column) {
		board[row][column] = currentPlayerPiece;
	}

	public static boolean isBoardFull(char[][] board) {
		boolean boardFull = true;
		for (int count = 0; count < board.length; count++) {
			for (int index = 0; index < board.length; index++) {
				if (board[count][index] == BLANK_SPACE) {
					boardFull = false;
				}
			}
		}
		return boardFull;
	}

	public static char winner(char[][] board) {
		int index = 0;
		int index2 = 0;
		char piece = NO_WINNER;
		for (int row = 0; row < 3; row++) {
			index = 0;
			for (int column = 0; column < 3; column++) {
				if (board[row][column] == 'X') {
					index++;
					if (index == 3) {
						piece = 'X';
					}
				}
			}
		}
		for (int column = 0; column < 3; column++) {
			index = 0;
			for (int row = 0; row < 3; row++) {
				if (board[row][column] == 'X') {
					index++;
					if (index == 3) {
						piece = 'X';
					}
				}
			}
		}
		index = 0;
		index2 = 0;
		for (int count = 0; count < 3; count++) {
			if (board[count][count] == 'X') {
				index++;
				if (index == 3) {
					piece = 'X';
				}
			}
			if (board[count][2 - count] == 'X') {
				index2++;
				if (index2 == 3) {
					piece = 'X';
				}
			}
		}
		for (int row = 0; row < 3; row++) {
			index = 0;
			for (int column = 0; column < 3; column++) {
				if (board[row][column] == 'O') {
					index++;
					if (index == 3) {
						piece = 'O';
					}
				}
			}
		}
		for (int column = 0; column < 3; column++) {
			index = 0;
			for (int row = 0; row < 3; row++) {
				if (board[row][column] == 'O') {
					index++;
					if (index == 3) {
						piece = 'O';
					}
				}
			}
		}
		index = 0;
		index2 = 0;
		for (int count = 0; count < 3; count++) {
			if (board[count][count] == 'O') {
				index++;
				if (index == 3) {
					piece = 'O';
				}
			}
			if (board[count][2 - count] == 'O') {
				index2++;
				if (index2 == 3) {
					piece = 'O';
				}
			}
		}
		return piece;
	}
}