package Piece;

public class sudo Pawn {

    public Pawn(boolean white){
        super('P', white);
    }

    public Boolean IsPawn(int row,int col,char team,int dir){//폰의 이동이 유효한지
        //1 : +1 +1  2 : +1 +0  3 : +1,-1
        if(team == 'W')
        {
            if(dir==2){
                if(board[row-1][col]==0)
                    return true;
                else {
                    return false;
                }
            }
            else if(dir ==1)
            {
                if(board[row-1][col+1]==0)
                    return false;
                else {
                    Catch_Piece(row-1,col+1);
                    return false;
                }
            }
            else {
                if(board[row-1][col-1]==0)
                    return false;
                else {
                    Catch_Piece(row-1,col-1);
                    return false;
                }
            }
        }
        else
        {
            if(dir==2){
                if(board[row+1][col]==0)
                    return true;
                else {
                    return false;
                }
            }
            else if(dir ==1)
            {
                if(board[row+1][col+1]==0)
                    return false;
                else {
                    Catch_Piece(row+1,col+1);
                    return false;
                }
            }
            else {
                if(board[row+1][col-1]==0)
                    return false;
                else {
                    Catch_Piece(row+1,col-1);
                    return false;
                }
            }
        }
    }

}