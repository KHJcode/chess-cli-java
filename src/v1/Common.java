package v1;

import v1.piece.team.Black;
import v1.piece.team.PieceTeam;
import v1.piece.team.White;

import java.util.ArrayList;
import java.util.Arrays;

public class Common {
    public static int BLACK_ID = 0;
    public static int WHITE_ID = 1;
    public static int WIDTH = 7;
    public static int HEIGHT = 7;

    public static ArrayList<PieceTeam> pieceTeams = new ArrayList<>(Arrays.asList(new Black(), new White()));

    public static int getOtherTeamId(int teamId) {
        return teamId == BLACK_ID ? WHITE_ID : BLACK_ID;
    }

    public static int jul(int n) {
        return n < 0 ? n * -1 : n;
    }
}
