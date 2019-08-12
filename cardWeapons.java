import java.util.ArrayList;
import java.util.Random;

public class cardWeapons implements  Cards{

    boolean isMurderWeappon = false;
    // all possiable charchter names
    static ArrayList nameOfWeapons = new ArrayList<String>(){
        {
            add("Candlestick");
            add ("Dagger");
            add("Lead Pipe");
            add("Revolver");
            add("Rope");
            add ("Spanner");

        }
    };

    String name;

    cardWeapons(){
        // get a name from the list of names and then remove it so that charchter can't be selected again\
        Random rand = new Random();
        int whichCharchter = rand.nextInt(nameOfWeapons.size());
        name = (String)nameOfWeapons.get(whichCharchter);
        nameOfWeapons.remove(whichCharchter);

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void isUsedInMurder() { isMurderWeappon = true; }

    @Override
    public void printInfo() {
        System.out.println("name: " + name);
        if (isMurderWeappon == true) System.out.println("this is the murder weapon");
    }

    @Override
    public int getAllLeftCard() {
        return nameOfWeapons.size();
    }
}
