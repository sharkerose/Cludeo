import java.util.Scanner;

public abstract class ABSutilitys {

    Scanner reader;

    public String getInput(String baseText){

        String returnValue;

        System.out.println(baseText);
        reader = new Scanner(System.in);

        returnValue = reader.nextLine();

        return returnValue;
    }

    public void closeTheScanner(){
        reader.close();
    }
}
