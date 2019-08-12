import java.util.ArrayList;
import java.util.Random;

public class RoomHold {

    char rooomType;
    char doorType;
    String roomName;
    ArrayList<Positions> roomPosition = new ArrayList<>();
    ArrayList<Positions> doorPosition = new ArrayList<>();

    RoomHold(String name, char typeR, char typeD, ArrayList<char[]> map){
        rooomType =typeR;
        doorType = typeD;
        roomName = name;

        getRoomPos(map);
    }

    private void getRoomPos (ArrayList<char[]> map){
        Positions pos;

        for (int i = 0; i < map.size(); i++){
            for (int u = 0; u < map.get(i).length; u++){
                // finds all  room info and add to there arrays
                if (rooomType == map.get(i)[u]){
                    pos = new Positions(u, i);
                    roomPosition.add(pos);
                }
                if (doorType == map.get(i)[u]){
                    pos = new Positions(u, i);
                    doorPosition.add(pos);
                }
            }
        }
    }

    //randomly select a place in the room to put the player in when
    Positions getRandomPosInRoom(){
        int placement;
        Random random = new Random();
        placement = random.nextInt(roomPosition.size());
        return roomPosition.get(placement);
    }


    public char getRooomType() { return rooomType;}
}
