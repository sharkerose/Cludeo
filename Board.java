import java.util.ArrayList;

public class Board {

    String board[][] = new String[24][25];
    ArrayList<Weapons> allWeapons = new ArrayList<>();
    Board(){
        // note i did added a extra two row and collum this is just so i can create a border
        for (int i = 0; i < 24; i++){
            for (int u = 0 ;u < 25; u++){

                 board[i][u]="|_|";

            }
        }
    }

    // testing methoid
    public void printBoard(){
        for (int i = 0 ; i < board.length; i++){
            for (int u= 0; u <board[i].length; u++){
                System.out.print(board[i][u]);
            }
            System.out.println("");
        }
    }

}
