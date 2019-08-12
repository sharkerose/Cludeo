import java.util.ArrayList;

public class PlayerCharchter {

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

    String name;

    PlayerCharchter(){
        // get a name from the list of names and then remove it so that charchter can't be selected again
        int whichCharchter = (int)Math.random() * nameOfCharchters.size() +1;
        name = (String)nameOfCharchters.get(whichCharchter);
        nameOfCharchters.remove(whichCharchter);
    }


    // testing methoids
    public void printName() {
       System.out.println(name);
    }

}
