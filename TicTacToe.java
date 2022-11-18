package com.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

	static ArrayList<Integer> player1Position = new ArrayList<Integer>();
	static ArrayList<Integer> player2Position = new ArrayList<Integer>();

	public static void displayGameBoard(char[][] tictactoeBoard) {
		for (char[] row : tictactoeBoard) {
			for (char element : row) {
				System.out.print(element);
			}
			System.out.println();
		}
	}

	public static void placeSymbol(char[][] tictactoeBoard, int position, String player) {

		char symbol = ' ';

		if (player.equals("player1")) {
			symbol = 'X';
			player1Position.add(position);
		} else if (player.equals("player2")) {
			symbol = 'O';
			player2Position.add(position);
		}

		switch (position) {
		case 1:
			tictactoeBoard[0][0] = symbol;
			break;
		case 2:
			tictactoeBoard[0][2] = symbol;
			break;
		case 3:
			tictactoeBoard[0][4] = symbol;
			break;
		case 4:
			tictactoeBoard[2][0] = symbol;
			break;
		case 5:
			tictactoeBoard[2][2] = symbol;
			break;
		case 6:
			tictactoeBoard[2][4] = symbol;
			break;
		case 7:
			tictactoeBoard[4][0] = symbol;
			break;
		case 8:
			tictactoeBoard[4][2] = symbol;
			break;
		case 9:
			tictactoeBoard[4][4] = symbol;
			break;
		}
		displayGameBoard(tictactoeBoard);
	}

	public static String winConditionCheck() {

		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List bottomRow = Arrays.asList(7, 8, 9);
		List firstColumn = Arrays.asList(1, 4, 7);
		List secondColumn = Arrays.asList(2, 5, 8);
		List thirdColumn = Arrays.asList(3, 6, 9);
		List diagonalOne = Arrays.asList(1, 5, 9);
		List diagonalTwo = Arrays.asList(3, 5, 7);

		List<List> winCondition = new ArrayList<List>();
		winCondition.add(topRow);
		winCondition.add(midRow);
		winCondition.add(bottomRow);
		winCondition.add(firstColumn);
		winCondition.add(secondColumn);
		winCondition.add(thirdColumn);
		winCondition.add(diagonalOne);
		winCondition.add(diagonalTwo);

		for (List winList : winCondition) {
			if (player1Position.containsAll(winList)) {
				return "Congratulations PLAYER 1 is the WINNER";
			} else if (player2Position.containsAll(winList)) {
				return "Congratulations PLAYER 2 is the WINNER";
			} else if (player1Position.size() + player2Position.size() == 9) {
				return "It's a TIE";
			}
		}
		return "";
	}

	public static void main(String[] args) {
		char[][] tictactoeBoard = { { ' ', '|', ' ', '|', ' ' }, { '-', '*', '-', '*', '-' },
				{ ' ', '|', ' ', '|', ' ' }, { '-', '*', '-', '*', '-' }, { ' ', '|', ' ', '|', ' ' } };

		displayGameBoard(tictactoeBoard);

		while (true) {
			Scanner scan = new Scanner(System.in);

			System.out.println("Player1 enter the position(1-9) at which you want to place your symbol - ");
			int player1Pos = scan.nextInt();

			while (player1Position.contains(player1Pos) || player2Position.contains(player1Pos)) {
				System.out.println("Position is already full, please enter valid position.");
				player1Pos = scan.nextInt();
			}

			placeSymbol(tictactoeBoard, player1Pos, "player1");
			String result = winConditionCheck();
			if(result.length()>0){
				System.out.println(result);
				break;
			}

			System.out.println("Player2 enter the position(1-9) at which you want to place your symbol - ");
			int player2Pos = scan.nextInt();

			while (player1Position.contains(player2Pos) || player2Position.contains(player2Pos)) {
				System.out.println("Position is already full, please enter valid position.");
				player2Pos = scan.nextInt();
			}

			placeSymbol(tictactoeBoard, player2Pos, "player2");

			result = winConditionCheck();
			if(result.length()>0){
				System.out.println(result);
				break;
			}
	

		}

	}
}
