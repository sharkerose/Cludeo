import java.util.ArrayList;
import java.util.Random;

public class cardRoom implements Cards {


    boolean isMurderRoom = false;
    // all possiable charchter names
    static ArrayList nameOfRoom = new ArrayList<String>(){
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

    String name;


    cardRoom(){
        // get a name from the list of names and then remove it so that charchter can't be selected again
        Random rand = new Random();
        int whichCharchter = rand.nextInt(nameOfRoom.size());
        name = (String)nameOfRoom.get(whichCharchter);
        nameOfRoom.remove(whichCharchter);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void isUsedInMurder() { isMurderRoom = true; }

    @Override
    public void printInfo() {
        System.out.println("name: " + name);
        if (isMurderRoom == true) System.out.println("this is the murder room");
    }

    @Override
    public int getAllLeftCard() {
        return nameOfRoom.size();
    }
}
