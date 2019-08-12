import java.util.ArrayList;
import java.util.Random;

public class cardCharchter implements Cards {
    boolean isMurder =false;

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

    String name;

    cardCharchter (){
        // get a name from the list of names and then remove it so that charchter can't be selected again
        Random rand = new Random();
        int whichCharchter = rand.nextInt(nameOfCharchters.size());

        name = (String)nameOfCharchters.get(whichCharchter);
        nameOfCharchters.remove(whichCharchter);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void isUsedInMurder() { isMurder = true; }

    @Override
    public void printInfo() {
        System.out.println("name: " + name);
        if (isMurder  == true) System.out.println("this is the murder");
    }

    @Override
    public int getAllLeftCard() {
        return nameOfCharchters.size();
    }
}
