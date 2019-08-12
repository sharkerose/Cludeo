import java.util.ArrayList;
import java.util.Random;
/*

all the ascii dice
        +-----+  +-----+  +-----+  +-----+  +-----+  +-----+
        |     |  | 0   |  | 0   |  | 0 0 |  | 0 0 |  | 0 0 |
        |  0  |  |     |  |  0  |  |     |  |  0  |  | 0 0 |
        |     |  |   0 |  |   0 |  | 0 0 |  | 0 0 |  | 0 0 |
        +-----+  +-----+  +-----+  +-----+  +-----+  +-----+
*/

public class Dice {

    private ArrayList diceFaces = new ArrayList<String>(){
        {
            add("+-----+|     ||  0  ||     |+-----+");
            add("+-----+| 0   ||     ||   0 |+-----+");
            add("+-----+| 0   ||  0  ||   0 |+-----+");
            add("+-----+| 0 0 ||     || o o |+-----+");
            add("+-----+| o o ||  o  || o o |+-----+");
            add("+-----+| o o || o o || o o |+-----+");

        }
    };

    int rollDice (){
        Random ran = new Random();
        int rollOne = ran.nextInt(6);
        int rollTwo = ran.nextInt(6);
        int returnTotal = rollOne + rollTwo;

        System.out.println(addedDice((String)diceFaces.get(rollOne), (String)diceFaces.get(rollTwo)));
        return returnTotal;
    }

    // put the dice on the same line (this is purely for astetics)
    private String addedDice (String rollOne , String rollTwo){
        int breakPoints [] ={0,7, 14,21,28,35};
        String diceAdded="";

        for (int i = 0; i < breakPoints.length-1  ; i++){
            diceAdded  = rollOne.substring(breakPoints[i], breakPoints[i+1]) + "   "+ rollTwo.substring(breakPoints[i], breakPoints[i+1]) +"\n"+diceAdded;
        }
        return diceAdded;

    }
}
