package com.esu;

import java.text.NumberFormat;
import java.util.Scanner;


public class Board {
    Scanner in = new Scanner(System.in);
    boolean run;
    int bestScore = (int)(Float.NEGATIVE_INFINITY);

    char[][] board= new char[][]{
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};


    void printBoard(){
        for (char[] car: board ){
            System.out.println(car);
            }
        }


    public void player1(){
        run = true;
        while(run) {
            System.out.print("Please select position (1-9): ");
            int n = in.nextInt();
            if (n > 9 || n < 1) System.out.print("Please type a number within range (1-9): ");
            int[] pos = boardPosition(n);
            if (board[pos[0]][pos[1]] == ' ') {
                board[pos[0]][pos[1]] = 'X';
                run = false;
            } else System.out.print("Sorry that position is taken");
        }
    }

    public void compMove(){
        while (!run){
            int n = (int)(Math.random()*9);
            int[] pos = boardPosition(n);
            if(board[pos[0]][pos[1]] == ' '){
                board[pos[0]][pos[1]] = 'O';
                run = true;
            }
        }
    }
//    public void compMove() {
//        bestScore = (int)Float.NEGATIVE_INFINITY;
//        int[] bestMove= new int[2];
//        while (!run){
//            for(int i = 1; i < 10; i++) {
//                int[] pos = boardPosition(i);
//                if (board[pos[0]][pos[1]] == ' ') {
//                    board[pos[0]][pos[1]] = 'O';
//                    int score = minimax(board, 0, true);
//                    board[pos[0]][pos[1]] = ' ';
//                    if (score > bestScore) {
//                        bestScore = score;
//                        bestMove = pos;
//
//                    }
//                }
//            }
//            board[bestMove[0]][bestMove[1]] = 'O';
//            run = true;
//        }
//    }
//    public int minimax(char[][] board, int depth, boolean isMaximizing){
//        int score;
//        if (checkWinner() != 0){
//            score = checkWinner();
//        }
//        if (isMaximizing){
//            bestScore = (int)(Float.NEGATIVE_INFINITY);
//            for(int i=1; i< 10; i++){
//                int[] n = boardPosition(i);
//                if(board[n[0]][n[1]]== ' '){
//                    board[n[0]][n[1]] = 'O';
//                    score = minimax(board, depth+1, false);
//                    board[n[0]][n[1]] = ' ';
//                    bestScore = Math.max(score, bestScore);
//                }
//            }
//            return bestScore;
//        }else{
//            bestScore = (int)(Float.POSITIVE_INFINITY);
//            for(int i=1; i< 10; i++){
//                int[] n = boardPosition(i);
//                if(board[n[0]][n[1]]== ' '){
//                    board[n[0]][n[1]] = 'X';
//                    score = minimax(board, depth+1, true);
//                    board[n[0]][n[1]] = ' ';
//                    bestScore =  Math.min(score, bestScore);
//                }
//            }
//            return bestScore;
//        }
//    }

    public int checkWinner(){
        if(isWinner('O')) return 1;
        else if(isWinner('X')) return -1;
        else return 0;
    }

    public int[] boardPosition(int n){
        int[] position = new int[2];
        switch (n){
            case 1:
                position = new int[]{0,0};
                break;
            case 2:
                position = new int[]{0,2};
                break;
            case 3:
                position = new int[]{0,4};
                break;
            case 4:
                position = new int[]{2,0};
                break;
            case 5:
                position = new int[]{2,2};
                break;
            case 6:
                position = new int[]{2,4};
                break;
            case 7:
                position = new int[]{4,0};
                break;
            case 8:
                position = new int[]{4,2};
                break;
            case 9:
                position = new int[]{4,4};
                break;
            default:
                break;
        }
    return position;
    }
    public boolean isBoardFull(){
        boolean itIs = true;
        for(int i=1; i< 10; i++){
            int[] pos = boardPosition(i);
            if(board[pos[0]] [pos[1]] == ' ') {
                itIs = false;
                break;
            }
        }
        return itIs;
    }
    public boolean isWinner(char letter){
        return (board[0][0]==letter && board[0][2]== letter && board[0][4]==letter
        ||board[2][0]==letter && board[2][2]== letter && board[2][4]==letter
        ||board[4][0]==letter && board[4][2]== letter && board[4][4]==letter
        ||board[0][0]==letter && board[2][0]== letter && board[4][0]==letter
        ||board[0][2]==letter && board[2][2]== letter && board[4][2]==letter
        ||board[0][4]==letter && board[2][4]== letter && board[4][4]==letter
        ||board[0][0]==letter && board[2][2]== letter && board[4][4]==letter
        ||board[0][4]==letter && board[2][2]== letter && board[4][0]==letter);
    }

    public int availableMoves(){
        int count = 0;
        for(int i=1; i< 10;i++ ) {
            int[] pos = boardPosition(i);
            if(board[pos[0]][pos[1]]==' ') count++;
        }
        return count;
    }


//    public int miniMax(char[][] board, int depth, boolean isMaximizing) {
//        if(checkWinner() == -2)
//        }
//        return 1;
//
//    }
}

