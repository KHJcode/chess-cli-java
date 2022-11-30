package v1;

import v1.piece.team.Black;
import v1.piece.team.PieceTeam;
import v1.piece.team.White;

import java.util.ArrayList;
import java.util.Arrays;

public class Common {
    public static int BLACK_ID = 1;
    public static int WHITE_ID = 2;

    public static ArrayList<PieceTeam> pieceTeams = new ArrayList<>(Arrays.asList(new Black(), new White()));
}
