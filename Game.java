public class Game extends ABSutilitys {

    Game(){
        Board b = new Board();
        b.printBoard();
        askTotalPlayer();

        // note this is just so that the scanner turns off safely
        closeTheScanner();
    }

    // check to see if the user has actually entered a number and not just some random letters
    private int CheckIfInt(String check){
        int returnStatement = 0;
        // occurs if the user put in a valid input
        try {
            returnStatement = Integer.valueOf(check);
        }
        // occurs if the  user input non integer input
        catch (NumberFormatException nfe){
            CheckIfInt(getInput("that is not a valid input please renter a whole number"));
        }
        return returnStatement;
    }


    //store the total number of player
    public int askTotalPlayer (){
        int totalPlayers = CheckIfInt(getInput("please choose how many player (no more then 6)"));

        // just incase the user choose more then 6 player
        if (totalPlayers > 6 ){
            while (totalPlayers > 6){
                totalPlayers = CheckIfInt(getInput("please choose less then or exactly 6 players"));
            }
        }

        PlayerCharchter name = new PlayerCharchter();
        return  totalPlayers;
    }

    public void setUpBoard(){

    }
}
