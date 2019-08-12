import java.util.ArrayList;

public class Board extends ABSutilitys {
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

    ArrayList<Character> rooms = new ArrayList<Character>(){
        {
            add('a');// study (from the picture thought the upsidedown y was a A)
            add('l');// libary
            add('r');// billard room
            add('d');// dinning room
            add('h');// hall
            add('f');// frontroom(lounge name changed just to avoid two L)
            add('c');// conservatory
            add('b');// ball room
            add('k');// kitchen
        }
    };

    ArrayList<Character> doorsForRooms = new ArrayList<Character>(){
        {
            add('A');// study (from the picture thought the upsidedown y was a A)
            add('L');// libary
            add('R');// billard room
            add('D');// dinning room
            add('H');// hall
            add('F');// frontroom(lounge name changed just to avoid two L)
            add('C');// conservatory
            add('T');// ball room ("note t used for thearter as alternative name for ballroom to stop interference)
            add('K');// kitchen
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

    String basicBoard = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
                        "+|#||#||#||#||#||#||#||#||#||W||#||#||#||#||G||#||#||#||#||#||#||#||#||#||#|+\n" +
                        "+|#||k||k||k||k||#||#||_||_||_||#||b||b||#||_||_||_||#||#||c||c||c||c||c||#|+\n" +
                        "+|#||k||k||k||k||#||_||_||#||#||#||b||b||#||#||#||_||_||#||c||c||c||c||c||#|+\n" +
                        "+|#||k||k||k||k||#||_||_||#||b||b||b||b||b||b||#||_||_||#||c||c||c||c||c||#|+\n" +
                        "+|#||k||k||k||k||#||_||_||#||b||b||b||b||b||b||#||_||_||#||C||c||c||c||c||#|+\n" +
                        "+|#||k||k||k||k||#||_||_||T||b||b||b||b||b||b||T||_||_||_||_||#||#||#||#||#|+\n" +
                        "+|#||#||#||#||K||#||_||_||#||b||b||b||b||b||b||#||_||_||_||_||_||_||_||_||B|+\n" +
                        "+|_||_||_||_||_||_||_||_||#||T||#||#||#||#||T||#||_||_||_||_||_||_||_||#||#|+\n" +
                        "+|#||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||#||#||#||#||#||#||#|+\n" +
                        "+|#||#||#||#||#||_||_||_||_||_||_||_||_||_||_||_||_||_||R||r||r||r||r||r||#|+\n" +
                        "+|#||d||d||d||#||#||#||#||_||_||#||#||#||#||#||_||_||_||#||r||r||r||r||r||#|+\n" +
                        "+|#||d||d||d||d||d||d||#||_||_||#||#||#||#||#||_||_||_||#||r||r||r||r||r||#|+\n" +
                        "+|#||d||d||d||d||d||d||D||_||_||#||#||#||#||#||_||_||_||#||r||r||r||r||r||#|+\n" +
                        "+|#||d||d||d||d||d||d||#||_||_||#||#||#||#||#||_||_||_||#||#||#||#||r||#||#|+\n" +
                        "+|#||d||d||d||d||d||d||#||_||_||#||#||#||#||#||_||_||_||_||_||_||_||_||_||#|+\n" +
                        "+|#||#||#||#||#||D||#||#||_||_||#||#||#||#||#||_||_||_||#||#||#||L||#||#||#|+\n" +
                        "+|#||_||_||_||_||_||_||_||_||_||#||#||#||#||#||_||_||#||#||l||l||l||l||l||#|+\n" +
                        "+|Y||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||_||L||l||l||l||l||l||l||#|+\n" +
                        "+|#||_||_||_||_||_||_||_||_||#||#||H||H||#||#||_||_||#||#||l||l||l||l||l||#|+\n" +
                        "+|#||#||#||#||#||F||#||_||_||#||h||h||h||h||#||_||_||_||#||#||#||#||#||#||#|+\n" +
                        "+|#||f||f||f||f||f||#||_||_||#||h||h||h||h||#||_||_||_||_||_||_||_||_||_||P|+\n" +
                        "+|#||f||f||f||f||f||#||_||_||#||h||h||h||h||H||_||_||_||_||_||_||_||_||_||#|+\n" +
                        "+|#||f||f||f||f||f||#||_||_||#||h||h||h||h||#||_||_||#||A||#||#||#||#||#||#|+\n" +
                        "+|#||f||f||f||f||f||#||_||_||#||h||h||h||h||#||_||_||#||a||a||a||a||a||a||#|+\n" +
                        "+|#||f||f||f||f||#||#||_||_||#||h||h||h||h||#||_||_||#||a||a||a||a||a||a||#|+\n" +
                        "+|#||#||#||#||#||#||#||S||#||#||#||#||#||#||#||#||_||#||#||#||#||#||#||#||#|+\n" +
                        "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";

    ArrayList<char[]> holdMap = new ArrayList<>();
    ArrayList<RoomHold> roomInfo = new ArrayList<>();

    Board(){
        char [] charOfLine;

        String[] line  = basicBoard.split("\\n");
        for (int i= 0; i < line.length; i++){
            charOfLine = line[i].toCharArray();
            holdMap.add(charOfLine);
        }

        // generate the room info
        for (int i = 0; i < doorsForRooms.size(); i++){
            RoomHold R = new RoomHold((String)nameOfRoom.get(i), rooms.get(i), doorsForRooms.get(i), holdMap);
            roomInfo.add(R);
        }

    }

    // used to find the player charchters
    Positions find (char c){
        Positions returnValue = null;

        for (int i = 0; i < holdMap.size(); i++) {
            for (int u = 0; u < holdMap.get(i).length; u++) {
                if (c == holdMap.get(i)[u]){
                    returnValue = new Positions(u, i);
                }
            }
        }

        return returnValue;
    }

    private String checkIFValidInput(String toCheck){
        toCheck = toCheck.toUpperCase();

        if (toCheck.equals("W") || toCheck.equals("A") || toCheck.equals("S")|| toCheck.equals("D")){
            return toCheck;
        }
        else return checkIFValidInput(getInput("please enter either W, A, S or D"));

    }

    private boolean checkIfValidMove(Positions pos, int pY, int pX){
        if ((pos.x +pX) >= holdMap.get(pos.y).length) return false;

        if (holdMap.get(pos.y+pY)[pos.x+pX] == '#'
                || holdMap.get(pos.y+pY)[pos.x+pX] == '+' ||
                charchterPieces.contains(holdMap.get(pos.y+pY)[pos.x+pX])
                || rooms.contains(holdMap.get(pos.y+pY)[pos.x+pX])) return false;
        else return true;

    }

    // used for standard movement
    PlayerCharchter updatePosition( PlayerCharchter player, String input){

        Positions p = player.currentPos;
        String checked = checkIFValidInput(input);
        boolean keepLooping = true;
        boolean standardMovement = true;
        int X = 0, Y = 0;
        Positions newPos = null;

        while (keepLooping == true){
            if (checked.equals("W"))Y = -1;
            else if (checked.equals("S"))Y = 1;

            else if (checked.equals("A"))X = - 3;
            else if (checked.equals("D"))X = 3;

            if (checkIfValidMove(p, Y, X) == false){
                checked = checkIFValidInput(getInput("please enter a valid move using W,A,S,D"));
                X = 0;
                Y = 0;
            }
            else keepLooping = false;
        }

        for (int i = 0; i < roomInfo.size(); i++){
           for (int u= 0; u < roomInfo.get(i).doorPosition.size(); u++){
               if ((p.y+Y) == roomInfo.get(i).doorPosition.get(u).getY() && (p.x+X) == roomInfo.get(i).doorPosition.get(u).getX()){
                   standardMovement = false;
                   newPos = roomInfo.get(i).getRandomPosInRoom();

                   holdMap.get(newPos.y)[newPos.x] =  holdMap.get(p.y)[p.x];
                   holdMap.get(p.y)[p.x] = '_';

                   player.setInRoom(roomInfo.get(i).getRooomType());
                   printBoard();

               }
           }
        }

        if (standardMovement == true){
            holdMap.get(p.y+Y)[p.x+X] =  holdMap.get(p.y)[p.x];
            holdMap.get(p.y)[p.x] = '_';
            newPos = new Positions(p.x +X, p.y+Y);
        }
        player.setCurrentPos(newPos);

        return player;
    }

    public RoomHold searchRoomInfo (String name){
        for (int i = 0; i < roomInfo.size(); i++){
            if (roomInfo.get(i).roomName.equals(name)) return roomInfo.get(i);
        }
        return null;
    }

    // used to let the player leave
    public PlayerCharchter leaveRoom( PlayerCharchter pc){
        int currentPosInArray = 0;
        int whichDoor = 0;
        boolean checkIfMoveCanBeMade = true;
        char holdPlayer;
        ArrayList<Integer> holdDoor = new ArrayList<>();

        for (int i = 0; i < roomInfo.size(); i++){
            if(roomInfo.get(i).rooomType == pc.roomToken) currentPosInArray = i;
        }

        while(checkIfMoveCanBeMade){
            if (roomInfo.get(currentPosInArray).doorPosition.size() >1){
                whichDoor = checkIfValidDoor(roomInfo.get(currentPosInArray).doorPosition.size(),
                        getInput("please choose between 1-"+roomInfo.get(currentPosInArray).doorPosition.size()));
                whichDoor--;
            }
            else whichDoor = 0;

            if (checkAllPos(roomInfo.get(currentPosInArray).doorPosition.get(whichDoor))!= null){
                holdPlayer = holdMap.get(pc.getCurrentPos().getY())[pc.getCurrentPos().getX()];
                holdMap.get(pc.getCurrentPos().getY())[pc.getCurrentPos().getX()] = pc.roomToken;

                pc.setCurrentPos(checkAllPos(checkAllPos(roomInfo.get(currentPosInArray).doorPosition.get(whichDoor))));
                holdMap.get(pc.getCurrentPos().getY())[pc.getCurrentPos().getX()] = holdPlayer;

                pc.setInRoom(' ');
                return pc;
            }
            else {
                System.out.println("the choosen door appears to be blocked");
                if (holdDoor.size() == roomInfo.get(currentPosInArray).doorPosition.size()) checkIfMoveCanBeMade = false;
                else if (!holdDoor.contains(whichDoor)) holdDoor.add(whichDoor);
            }

        }
        System.out.println("the doors are blocked at the current time so your turn has been skiped for this round ");
        return pc;

    }

    private Positions checkAllPos(Positions pos){
        Positions originalPos = new Positions(pos.getX(), pos.getY());

        if (checkIfValidMove(pos, 1,0)) pos.update(0,1);
        else if (checkIfValidMove(pos, -1,0)) pos.update(0,-1);
        else if (checkIfValidMove(pos, 0,3)) pos.update(3,0);
        else if (checkIfValidMove(pos, 0,-3)) pos.update(-3,0);

        if (originalPos.getX() == pos.getX() && originalPos.getY() == pos.getY()) return null;
        else return pos;
    }

    private int checkIfValidDoor(int max, String userInput){
        if (Integer.valueOf(userInput) >0 && Integer.valueOf(userInput) <=max) return Integer.valueOf(userInput);
        else return checkIfValidDoor(max, getInput("please enter a valid number between 1 and "+max));
    }

    //used for moving pieces instantly
    PlayerCharchter teleport(PlayerCharchter player ,  char roomType){
        PlayerCharchter returnValue = player;
        int posInList =0;
        Positions pos;

        for (int i = 0; i < roomInfo.size(); i++){
            if (roomInfo.get(i).rooomType ==roomType){
                posInList = i;
                break;
            }
        }
        pos = roomInfo.get(posInList).getRandomPosInRoom();

        holdMap.get(pos.getY())[pos.getX()]= player.playerToken;

        if (player.inRoom) holdMap.get(player.getCurrentPos().getY())[player.getCurrentPos().getX()] = player.roomToken;
        else holdMap.get(player.getCurrentPos().getY())[player.getCurrentPos().getX()] = '_';


        returnValue.setCurrentPos(pos);
        returnValue.roomToken = roomType;
        returnValue.inRoom = true;
        returnValue.forcfullyMoved = true;

        printBoard();

        return returnValue;
    }



    void printBoard(){
        for (int i = 0; i < holdMap.size(); i++){
            for (int u = 0; u < holdMap.get(i).length; u++){
                System.out.print(holdMap.get(i)[u]);
            }
            System.out.println();
        }
    }


}
