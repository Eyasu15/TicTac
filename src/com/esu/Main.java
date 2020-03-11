package com.esu;

public class Main {

    public static void main(String[] args) {
        var ob = new Board();
        System.out.println("Welcome to TicTacToe!");
        while(!ob.isBoardFull()){
            if(!ob.isWinner('O')){
                ob.player1();
                ob.printBoard();

            } else {
                System.out.println("Sorry O has won");
                break;
            }
            if(!ob.isWinner('X')){
                ob.compMove();
                ob.printBoard();
            }else{
                System.out.println("You won! Great Job!");
                break; }

        }

    }
}
