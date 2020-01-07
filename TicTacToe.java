package com.game1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static ArrayList<Integer> playerPositions=new  ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions=new  ArrayList<Integer>();


	public static void main(String[] args) 
	{
		char[][] gameBoard = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
			    {' ','|',' ','|',' '},
			    {'-','+','-','+','-'},
			    {' ','|',' ','|',' '}};
		printGameBoard(gameBoard);
	
		while(true) {
			Scanner sc =new Scanner(System.in);
		System.out.println(" Enter your placment(1-9):");
		int playerpos=sc.nextInt();
		while(playerPositions.contains(playerpos) || cpuPositions.contains(playerPositions)) {
			System.out.println("position taken!b enter correct postions");
			playerpos=sc.nextInt();
		}
		
		placepiece(gameBoard,playerpos,"player");
		Random rand=new Random();
		int cpuPos=rand.nextInt(9) +1;
		while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
		
			cpuPos=rand.nextInt(9) +1;
			
		}
		placepiece(gameBoard,cpuPos,"cpu");
		
		
		printGameBoard(gameBoard);
		String result=checkWinner();
		System.out.println(result);
		}
		
		
	}
	public static void printGameBoard(char [][] gameBoard) {
		for(char[] row: gameBoard) {
			for(char c: row) {
				System.out.print(c);
			}
			System.out.println();
		}
		
	}
	public static void placepiece(char [][] gameBoard, int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='x';
			playerPositions.add(pos);
		}else if(user.equals("cpu")) {
			symbol='o';
			cpuPositions.add(pos);
		}
		
		
		switch(pos ) {
	     case 1:
	    	 gameBoard[0][0]=symbol;
	    	 break;
	     case 2:
	    	 gameBoard[0][2]=symbol;
	    	 break;
	     case 3:
	    	 gameBoard[0][4]=symbol;
	    	 break;
	     case 4:
	    	 gameBoard[2][0]=symbol;
	    	 break;
	     case 5:
	    	 gameBoard[2][2]=symbol;
	    	 break;
	     case 6:
	    	 gameBoard[2][4]=symbol;
	    	 break;
	     case 7:
	    	 gameBoard[4][0]=symbol;
	    	 break;
	     case 8:
	    	 gameBoard[4][0]=symbol;
	    	 break;
	     case 9:
	    	 gameBoard[4][0]=symbol;
	    	 break;
	    	 
	}
	}
	public static String checkWinner() {
		List topRow=  (List) Arrays.asList(1,2,3);
		List midRow= (List) Arrays.asList(4,5,6);
		List botRow= (List) Arrays.asList(7,8,9);
		List leftCol= (List) Arrays.asList(1,4,7);
		List midCol= (List) Arrays.asList(2,5,8);
		List rightCol = (List) Arrays.asList(3,6,9);
		List cross1= (List) Arrays.asList(1,5,9);
		List cross2 = (List) Arrays.asList(7,5,3);
		
		
		ArrayList<List> winning =new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(rightCol);
		winning.add(midCol);
		winning.add(cross1);
		winning.add(cross2);
		
		for(List l:  winning ) {
			if(playerPositions.contains(l)){
				return "Congratulations you win!";
			}
			else if(cpuPositions.contains(l)) {
				return "cpu wins!";
			}else if(playerPositions.size() + cpuPositions.size()==9) {
				return "cat";
				
			}
			
		}
		
		
		
		
		
		return "";
	}
				


}
