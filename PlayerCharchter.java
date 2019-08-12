import java.util.ArrayList;

public class PlayerCharchter extends  ABSutilitys{

    String playersCharchterName;
    char playerToken;
    char roomToken;
    private ArrayList<Cards> hand = new ArrayList<>();
    Positions currentPos;
    boolean inRoom = false;
    boolean forcfullyMoved = false;
    String nameOfRoomCurrentlyIn = null;
    static  int allPlayer;
    int playerNumber;

    // all possiable charchter names
    static ArrayList nameOfCharchters = new ArrayList<String>(){
        {
            add("Miss Scarlett");
            add ("Colonel Mustard");
            add("Mrs. White");
            add("Mr. Green");
            add("Mrs. Peacock");
            add ("Professor Plum");

        }
    };

    static ArrayList<Character> charchterPieces = new ArrayList<Character>(){
        {
            add('R');// red piece (Miss Scarlett)
            add('Y');// yellow piece (Colonel Mustard)
            add('W');// white piece (Mrs. White)
            add('G');// green piece (Mr. Green)
            add('B');// blue piece (Mrs. Peacock)
            add('P');// purple piece (Professor Plum)
        }
    };

    private String checkIfValid(String name){
        for (int i = 0; i < nameOfCharchters.size(); i++){
            if (name.equals(nameOfCharchters.get(i))) {
                return name;
            }
        }
        return checkIfValid(getInput("you did not enter a valid name"));
    }

    PlayerCharchter(){
        String hold;
        int indexOFCharchter;

        System.out.println("Avaliable Charchters ");
        for (int i = 0; i < nameOfCharchters.size(); i++){
            System.out.println(nameOfCharchters.get(i));
        }

        allPlayer++;
        playerNumber = allPlayer;
        hold = checkIfValid(getInput("please choose one of the avaliable charchters"));
        indexOFCharchter = nameOfCharchters.indexOf(hold);

        playerToken = charchterPieces.get(indexOFCharchter);
        charchterPieces.remove(indexOFCharchter);

        nameOfCharchters.remove(hold);
        playersCharchterName = hold;
    }

    // add to the players hand
    public void addToHand(Cards c){
        hand.add(c);
    }

    public ArrayList<Cards> getHand() { return hand;}

    public void setCurrentPos(Positions p){currentPos = p;}

    // used tp determine if the player is in a specific room
    public void setInRoom(char room){

        if (room == ' '){
            nameOfRoomCurrentlyIn = null;
            inRoom = false;
        }
        else {
            inRoom = true;
            roomToken = room;
            if (room == 'a') nameOfRoomCurrentlyIn = "study";
            else if (room == 'l') nameOfRoomCurrentlyIn = "Libary";
            else if (room == 'r') nameOfRoomCurrentlyIn = "billiard room";
            else if (room == 'h') nameOfRoomCurrentlyIn = "Hall";
            else if (room == 'f') nameOfRoomCurrentlyIn = "Lounge";
            else if (room == 'd') nameOfRoomCurrentlyIn = "Dinning Hall";
            else if (room == 'c') nameOfRoomCurrentlyIn = "Conservatory";
            else if (room == 'k') nameOfRoomCurrentlyIn = "Kitchen";
            else if (room == 'b') nameOfRoomCurrentlyIn = "Ball Room";
        }

    }

    public Positions getCurrentPos(){ return currentPos; }

    // print methoid for testing purposes
    public void printHand(){
        for (int i = 0; i < hand.size(); i++){
            hand.get(i).printInfo();
        }
    }

    public void printInfo(){
        System.out.println("name: "+playersCharchterName);
        System.out.println("pieces: "+playerToken);
        System.out.println("posX:" +currentPos.getX() +" posY:"+currentPos.getY());
        System.out.println("is in "+nameOfRoomCurrentlyIn);
    }


}
