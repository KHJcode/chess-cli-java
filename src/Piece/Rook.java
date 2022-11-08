package Piece;

public class Rook {

    public Pawn(boolean white){
        super('P', white);
    }
    //각 말들의 표기법을 엌케할지 정해야 코드 좀더 수정 가능
    public Boolean IsRook(int row,int col,char team,int dir,int len)
    {//폰의 이동이 유효한지
        //1 2 3 4  동 서 남북
        if(team == 'W')
        {

            if (dir == 1) {
                if(isRange(row,col+len-1)==true) {
                    if (board[row ][col+len-1] > 0) {
                        Catch_Piece(row , col+len-1);
                        return true;

                    } else {
                        return true;
                    }
                }

                else return false;
            }
            else if(dir ==2)
            {
                if(isRange(row,col-len+1)==true) {
                    if (board[row][col - len+1] == 0)
                        return true;
                    else {
                        Catch_Piece(row , col -len + 1);
                        return true;
                    }
                }
                else
                    return false;
            }
            else if(dir==3){
                if(isRange(row+len-1,col)==true) {
                    if(board[row+len-1][col]==0)
                        return true;
                    else {
                        Catch_Piece(row+len-1,col);
                        return true;
                    }
                }
                else return false;
            }
            else {
                if(isRange(row-len+1,col)==true) {
                    if(board[row-len+1][col]==0)
                        return true;
                    else {
                        Catch_Piece(row-len+1,col);
                        return true;
                    }
                }
                else return false;
            }
        }
        else {
            if (dir == 1) {
                if (isRange(row, col + len - 1) == true) {
                    if (board[row][col + len - 1] > 0) {
                        Catch_Piece(row, col + len - 1);
                        return true;

                    } else {
                        return true;
                    }
                } else return false;
            } else if (dir == 2) {
                if (isRange(row, col - len + 1) == true) {
                    if (board[row][col - len + 1] == 0)
                        return true;
                    else {
                        Catch_Piece(row, col - len + 1);
                        return true;
                    }
                } else
                    return false;
            } else if (dir == 3) {
                if (isRange(row + len - 1, col) == true) {
                    if (board[row + len - 1][col] == 0)
                        return true;
                    else {
                        Catch_Piece(row + len - 1, col);
                        return true;
                    }
                } else return false;
            } else {
                if (isRange(row - len + 1, col) == true) {
                    if (board[row - len + 1][col] == 0)
                        return true;
                    else {
                        Catch_Piece(row - len + 1, col);
                        return true;
                    }
                } else return false;
            }
        }
    }

