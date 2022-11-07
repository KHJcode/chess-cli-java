package Piece;

public class Bishop {
    public Bishop(boolean white){
        super('B', white);
    }
    public boolean IsBishop(int row,int col,int dir,int len,char team) {
        /*
        1002
        0120
        0340
        0430
         */
       if(team=='W') {
           if (dir == 1) {
               if (board[row - len + 1][col + len - 1] == '우리팀 말') {
                   return false;
               } else if (board[row - len + 1][col + len - 1] == '상대팀 말') {
                   Catch_Piece(row - len + 1, col + len - 1);
               } else
                   return true;
           } else if (dir == 2) {
               if (board[row - len + 1][col - len + 1] == '우리팀 말') {
                   return false;
               } else if (board[row - len + 1][col - len + 1] == '상대팀 말') {
                   Catch_Piece(row - len + 1, col - len + 1);
               } else
                   return true;
           } else if (dir == 3) {
               if (board[row + len - 1][col - len + 1] == '우리팀 말') {
                   return false;
               } else if (board[row + len - 1][col - len + 1] == '상대팀 말') {
                   Catch_Piece(row + len - 1, col - len + 1);
               } else
                   return true;
           } else {
               if (board[row - len + 1][col - len + 1] == '우리팀 말') {
                   return false;
               } else if (board[row - len + 1][col - len + 1] == '상대팀 말') {
                   Catch_Piece(row - len - 1, col - len + 1);
               } else
                   return true;
           }
       }
       }
    }

