package com.esu;

public class MiniMax {
 char[][] board;
 int player;

 int miniMax(char[][] board, int player){
     this.board = board;
     var bar = new Board();
     if(bar.checkWinner()== 0) return 0;
     else if(bar.checkWinner()== 1) return 10;
     else if(bar.checkWinner()== -1) return -10;

     int[] moves;
     for (int i=0; i < bar.availableMoves(); i++){
         int[] move = {pos[0], pos[1]}

     }
 }
}

