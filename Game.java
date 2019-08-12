import java.util.ArrayList;

public class Game extends ABSutilitys {

    int totalPlayers;
    int playerChoose;
    ArrayList<PlayerCharchter> allPlayers = new ArrayList<>();
    ArrayList<Cards> muder = new ArrayList<>();
    ArrayList<String> allGuesses = new ArrayList<>();

    //the win lose stuff
    ArrayList<String> winner = new ArrayList<>();
    ArrayList<String> loser = new ArrayList<>();

    // note all cards is
    ArrayList<Cards> allCards = new ArrayList<>();
    Board B = new Board();
    boolean isGameOver = true;

    ArrayList nameOfCharchters = new ArrayList<String>() {
        {
            add("Miss Scarlett");
            add("Colonel Mustard");
            add("Mrs. White");
            add("Mr. Green");
            add("Mrs. Peacock");
            add("Professor Plum");

        }
    };

    ArrayList nameOfWeapons = new ArrayList<String>(){
        {
            add("Candlestick");
            add ("Dagger");
            add("Lead Pipe");
            add("Revolver");
            add("Rope");
            add ("Spanner");

        }
    };


    ArrayList nameOfRoom = new ArrayList<String>(){
        {
            add("Ball Room");
            add ("Kitchen");
            add("Conservatory");
            add("Dinning Hall");
            add("Lounge");
            add ("Hall");
            add("study");
            add("Libary");
            add("billiard room");

        }
    };






    Game(){
        Dice dice = new Dice();
        // get total players
        totalPlayers = askTotalPlayer();

        // let players pick there charchters
        for (int i = 0; i < totalPlayers; i++){
            PlayerCharchter c = new PlayerCharchter();
           allPlayers.add(c);
        }

        generateMurder();
        generateAllCards();
        dealCards();

        for (int i = 0; i < totalPlayers; i++){
            allPlayers.get(i).setCurrentPos(B.find(allPlayers.get(i).playerToken));
        }


        while (isGameOver){
            for (int i = 0; i < allPlayers.size(); i++){
                System.out.println("it is "+allPlayers.get(i).playersCharchterName + "      Tokken:"+allPlayers.get(i).playerToken );

                if (allPlayers.get(i).inRoom == false) playerChoose = actions(getInput("please choose 1 (for dice movement) or 2 (to make a accusation)"), allPlayers.get(i).inRoom, allPlayers.get(i).forcfullyMoved);
                else if (allPlayers.get(i).inRoom && allPlayers.get(i).forcfullyMoved ) playerChoose = actions(getInput("2 (to make a accusation) ,3 (leaveRoom)"), allPlayers.get(i).inRoom, allPlayers.get(i).forcfullyMoved);

                else playerChoose = actions(getInput("please choose 1 (for dice movement) , 2 (to make a accusation) ,3 (leaveRoom),4 (make another guess)"), allPlayers.get(i).inRoom, allPlayers.get(i).forcfullyMoved);

                if (playerChoose == 1){
                    movemnt(dice.rollDice(), i);
                    if (allPlayers.get(i).inRoom)guess(i);
                }
                else if (playerChoose == 2)accuse(allPlayers.get(i));
                else if (playerChoose ==3){
                    B.leaveRoom(allPlayers.get(i));
                    movemnt(dice.rollDice(), i);
                    if (allPlayers.get(i).forcfullyMoved) allPlayers.get(i).forcfullyMoved = false;
                }
                else if (playerChoose == 4)guess(i);

                if (allPlayers.size() == 1){
                    if (winner.size() == 0) {
                        winner.add(allPlayers.get(0).playersCharchterName);
                    }
                    else loser.add(allPlayers.get(0).playersCharchterName);

                    isGameOver = false;
                    break;
                }
            }
        }

        // end of game

        System.out.println("the murder scenario is");
        printMurder();
        if (winner.size() >1 ) System.out.println("the Winners are");
        else System.out.println("the winner is");
        for (int i = 0; i < winner.size(); i++) System.out.println("the player of "+winner.get(i));

        if (loser.size() >1 ) System.out.println("the Loser are");
        else System.out.println("the loser is");
        for (int i = 0; i < loser.size(); i++) System.out.println("the player of "+loser.get(i));

        System.out.println("thank you for playing");

        // note this is just so that the scanner turns off safely
        closeTheScanner();
    }






    private int actions(String str, boolean additonalActions, boolean wasForced){
        if (str.equals("1") && wasForced == false) return 1;
        else if (str.equals("2")) return 2;

        if (additonalActions){
            if (str.equals("3")) return 3;
            else if (str.equals("4") && wasForced == false) return 4;
        }

        if (additonalActions == true) return actions(getInput("please choose 1 (for dice movement) , 2 (to make a accusation) ,3 (leave Room) or 4 (make a guess)"), additonalActions, wasForced);
        else if (additonalActions == true && wasForced == true)return actions(getInput("please choose 1 (for dice movement) , 2 (to make a accusation) ,3 (leave Room)"),additonalActions, wasForced);
        else return actions(getInput("please choose 1 (for dice movement) or 2 (to make a accusation)"), additonalActions, wasForced);
    }

    private void guess(int currentPlayer){
        String holdName;
        int hold = checkHands(allPlayers.get(currentPlayer).nameOfRoomCurrentlyIn);
        String name = allPlayers.get(currentPlayer).nameOfRoomCurrentlyIn;
        // determine if any player had the room
        if (hold == -1) allGuesses.add("no player has "+ name);
        else allGuesses.add("player:" + hold +" has "+ name);

        // determine if any player has the charchter
        holdName = playerChoose(nameOfCharchters);
        for (int i = 0; i < allPlayers.size(); i ++){
            if (allPlayers.get(i).playersCharchterName.equals(holdName)){
                allPlayers.set(i, B.teleport(allPlayers.get(i), allPlayers.get(currentPlayer).roomToken));
            }
        }
        // determine if any player has the weapoon
        playerChoose(nameOfWeapons);

        // print info
        for (int i =0; i < allGuesses.size(); i++)System.out.println(allGuesses.get(i));
        allGuesses.clear();

    }


    private String playerChoose(ArrayList<String> search){
        String hold;
        int whichPlayerHas;

        for (int i = 0; i < search.size(); i++){
            System.out.println(search.get(i));
        }
        hold = checkIfOnList(getInput("who would you like to accuse"),search);
        whichPlayerHas = checkHands(hold);

        if (whichPlayerHas == -1) allGuesses .add("no player has "+ hold);
        else allGuesses.add("player:" +whichPlayerHas +" has "+ hold);

        return hold;
    }

    private String checkIfOnList(String str, ArrayList<String> toCheck){
        if (toCheck.contains(str)) return str;
        else return checkIfOnList(getInput("please enter one of the object on the list"), toCheck);
    }

    private int checkHands(String lookingFor){
        for (int i = 0; i < allPlayers.size(); i++ ){
            for(int u = 0; u < allPlayers.get(i).getHand().size(); u++){
                if (lookingFor.equals(allPlayers.get(i).getHand().get(u).getName())) return i+1;
            }
        }
        return -1;
    }



    private void accuse (PlayerCharchter player){
        String wepon, murder, room;
        boolean found = false;

        for (int i = 0; i < nameOfCharchters.size(); i++){
            System.out.println(nameOfCharchters.get(i));
        }
        murder = checkIfOnList(getInput("please choose a muder"), nameOfCharchters);

        for (int i = 0; i < nameOfRoom.size(); i++){
            System.out.println(nameOfRoom.get(i));


        }
        room = checkIfOnList(getInput("please choose a room"), nameOfRoom);

        for (int i = 0; i < nameOfWeapons.size(); i++){
            System.out.println(nameOfWeapons.get(i));
        }
        wepon = checkIfOnList(getInput("please choose a weapon"), nameOfWeapons);

        if (muder.get(0).getName().equals(room)){
            if (muder.get(1).getName().equals(murder)){
                if (muder.get(2).getName().equals(wepon)){
                    found = true;
                }
            }
        }
        if (found) winner.add(player.playersCharchterName);
        else loser.add(player.playersCharchterName);

        allPlayers.remove(player);

    }


    // determines the murder, the murder weapoon and the location
    private void generateMurder (){
        cardRoom R =new cardRoom();
        cardCharchter C = new cardCharchter();
        cardWeapons W = new cardWeapons();
        muder.add(R);
        muder.add(C);
        muder.add(W);

        for (int i = 0; i < muder.size(); i++){
            muder.get(i).isUsedInMurder();
            //muder.get(i).printInfo();// note this is used for checking if the murder weapoons are all created correctly
        }

    }

    private void dealCards(){
        int currentPlayer = 0;

        for (int i = 0; i < allCards.size(); i++){
            allPlayers.get(currentPlayer).addToHand(allCards.get(i));

            if (currentPlayer == totalPlayers-1) currentPlayer = 0;
            else currentPlayer++;
        }
    }

    private void movemnt (int diceRoll, int currentPlayer){

        for (int i = 0 ; i < diceRoll; i++){
            B.printBoard();
            String hold = getInput("please use W(move up), S(move down), A(move right), D(move left) ");
            allPlayers.set(currentPlayer, B.updatePosition(allPlayers.get(currentPlayer), hold));
            if(allPlayers.get(currentPlayer).inRoom)break;


        }
    }

    private void generateAllCards (){

        int loopTotal;

        cardRoom R =new cardRoom();
        cardCharchter C = new cardCharchter();
        cardWeapons W = new cardWeapons();

        // adds all Rooms
        loopTotal = R.getAllLeftCard();
        allCards.add(R);

        while (loopTotal != 0){
            R = new cardRoom();
            allCards.add(R);
            loopTotal = R.getAllLeftCard();
        }
        // adds all Charchters
        loopTotal = C.getAllLeftCard();
        allCards.add(C);

        while (loopTotal != 0){
            C = new cardCharchter();
            allCards.add(C);
            loopTotal = C.getAllLeftCard();
        }

        //adds all Weapons
        loopTotal = W.getAllLeftCard();
        allCards.add(W);

        while (loopTotal != 0){
            W = new cardWeapons();
            allCards.add(W);
            loopTotal = W.getAllLeftCard();
        }

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
        int totalPlayers = CheckIfInt(getInput("please choose how many player (no more then 6 and no less then 3)"));

        // just incase the user choose more then 6 player
        if (totalPlayers > 6  || totalPlayers < 3){
            while (totalPlayers > 6 || totalPlayers < 3){
                totalPlayers = CheckIfInt(getInput("please choose between 3-6 players"));
            }
        }

        return  totalPlayers;
    }


    // for error checking
    private void printHands(){
        for (int i = 0; i < allPlayers.size(); i++){
            System.out.println("Player "+ (i+1));
            System.out.println("-------------");
            allPlayers.get(i).printHand();
            System.out.println("-------------");
        }
    }

    private void printPlayerInfo(){
        for (int i = 0; i < allPlayers.size(); i++){
            allPlayers.get(i).printInfo();
        }
    }

    private void printMurder(){
        System.out.println("-------------");
        for (int i = 0; i < muder.size(); i++){
            System.out.println(muder.get(i).getName());
        }
        System.out.println("-------------");
    }
}
