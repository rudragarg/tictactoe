package tictactoe;

import java.util.Arrays;
import java.util.Scanner;  

public class game {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Do you want to play TicTacToe");
		
		String input =  sc.next();
		char[][] gameBoard = new char[3][3];
		
		if (input.toLowerCase().equals("yes")){
			
		
		
		
		
		setUp(gameBoard);
	
		
	}
		
		else if (input.toLowerCase().equals("no")){
			
			System.out.println("Ok have a great day");
		}
		
		else 
			System.out.println("please give a yes or no response");
		
	}
	
	
	
	public static void setUp(char board[][]) {
	
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        System.out.print("_" + " ");
		    }
		    System.out.println();
		    System.out.println();
	}
		
		setPlayers(board);
	
		
			
		}

	
	
	
	public static void setPlayers(char board[][]){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Player One, would you like to be X or O?");
		
		
		
		char playerOneLetter;
		char playerTwoLetter;
		boolean playerOneTurn;
		
		int row;
		int col;
		
		while (true){
		
			String input =  sc.next();
			
			if (input.toUpperCase().equals("X")){
			
			playerOneLetter = 'X';
			playerTwoLetter = 'O';
			
			playerOneTurn = true;
			
			
			
			break;
			
			
		}
		
		else if (input.toUpperCase().equals("O")){
			
			playerOneLetter = 'O';
			playerTwoLetter = 'X';
			
			playerOneTurn = true;
			break;
			
		}
		
		else 
			System.out.println("choose X or O.");
		
		}
		
		makeMove(playerOneLetter, playerTwoLetter, board, playerOneTurn);
		
	}
	
	public static void makeMove(char playerOneLetter, char playerTwoLetter, char[][] board, boolean playerOneTurn){
		
		String input;
		
		Scanner sc = new Scanner(System.in);
		
		if (playerOneTurn){
		
		System.out.println("What row would you like to place an " + playerOneLetter);
		
		input = sc.next();
		int row = Integer.parseInt(input) - 1;
		//System.out.println(row);
		
	
		System.out.println("What column would you like to place an " + playerOneLetter);
		
		input = sc.next();
		int col = Integer.parseInt(input) - 1;
		
		if (board[row][col] == 'X' || board[row][col] == 'O'){
			
			System.out.println("Please choose a free space");
			makeMove(playerOneLetter, playerTwoLetter, board, playerOneTurn);
		}
		
		//System.out.println(col);
		
		
		//makeMove(row,col, playerOneLetter, playerTwoLetter, board, playerOneTurn);
		
		else {
		board[row][col] = playerOneLetter;
		
		playerOneTurn = false;
		
		displayBoard(board, playerOneLetter, playerTwoLetter, playerOneTurn);
		
		}
		
		}
		
		if (!playerOneTurn){
			
			System.out.println("What row would you like to place an " + playerTwoLetter);
			
			input = sc.next();
			int row = Integer.parseInt(input) - 1;
			//System.out.println(row);
			
		
			System.out.println("What column would you like to place an " + playerTwoLetter);
			
			input = sc.next();
			int col = Integer.parseInt(input) - 1;
			//System.out.println(col);
			
			
			//makeMove(row,col, playerOneLetter, playerTwoLetter, board, playerOneTurn);
			
			if (board[row][col] == 'X' || board[row][col] == 'O'){
				
				System.out.println("Please choose a free space");
				makeMove(playerOneLetter, playerTwoLetter, board, playerOneTurn);
			}
			
			else{
			board[row][col] = playerTwoLetter;
			
			playerOneTurn = true;
			
			displayBoard(board, playerOneLetter, playerTwoLetter, playerOneTurn);
			
			makeMove(playerOneLetter, playerTwoLetter, board, playerOneTurn);}
			
			}
		
		
		
	}
	
	public static void displayBoard(char[][] board, char One, char Two, boolean OneTurn){
	
		Scanner sc = new Scanner(System.in);
		String input;
		
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        System.out.print(board[i][j] + " ");
		    }
		    System.out.println();
		    System.out.println();
	}
		
		if (checkWin(board) == true){
			
			if (OneTurn){
			System.out.println("Player 2 (" + Two + ") is the winner");
			
			System.out.println("Do you want to play again?");
			
			input = sc.next();
			if (input.toUpperCase().equals("YES")){
				
				char[][] gameBoard = new char[3][3];
				setUp(gameBoard);
				
			}
			
			else
				
			System.exit(0);
			
			}
			
			else{
				System.out.println("Player 1 (" + One + ") is the winner");
				
				System.out.println("Do you want to play again?");
				
				input = sc.next();
				
				if (input.toUpperCase().equals("YES")){
					
					char[][] gameBoard = new char[3][3];
					setUp(gameBoard);
					
				}
				
				else
					
				System.exit(0);
			}
				
		}
		
		
	
	
	
}
	
	public static boolean checkWin(char[][] board){
	
		char winningChar;
		boolean winner = false;
		
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        
		    	if (board[i][j] == 'X' || board[i][j] == 'O'){
		    	winningChar = board[i][j];
		    	
		    	if(j < 1){
		    		
		    		if (board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2]){
		    			
		    			winner = true;
		    			
		    		}
		    	}
		    	}
		    }
		    }
		
		for (int j = 0; j < board.length; j++) {
		    for (int i = 0; i < board[j].length; i++) {
		        
		  
		    	if (board[i][j] == 'X' || board[i][j] == 'O'){
			    	winningChar = board[i][j];
		    	
		    	if(i < 1){
		    		
		    		if (board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j]){
		    			
		    			winner = true;
		    			
		    		}
		    	}
		    	}
		    	}
		    }
		
		
		if (board [0][2] == 'X' || board [0][2] == 'O'){
			
			if (board [0][2] == board [1][1] && board [1][1] == board[2][0]){
				
				winner = true;
				
			}
		}
		
		if (board [0][0] == 'X' || board [0][0] == 'O'){
			
			if (board [0][0] == board [1][1] && board [1][1] == board[2][2]){
				
				winner = true;
				
			}
		}
		
		return winner;
		
	}
}


