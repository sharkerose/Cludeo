import java.util.ArrayList;

public class Weapons {

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
    // which weapoon is the murder weappon
    static int currentWeappon = 0;
    static int murderWeappon = (int)Math.random() * 6  +1;

    String name;
    boolean isMurderWeappon = false;
    Weapons(){
        // get a name from the list of names and then remove it so that charchter can't be selected again
        int whichCharchter = (int)Math.random() * nameOfWeapons.size() +1;
        name = (String)nameOfWeapons.get(whichCharchter);
        nameOfWeapons.remove(whichCharchter);

        currentWeappon ++;

        if (currentWeappon == murderWeappon) isMurderWeappon = true;
    }

    public String getBoardName(){
        return name.substring(0, 2).toUpperCase();
    }
}
