public class Positions {
    int x;
    int y;

    // this is used just to keep track of the players positions

    Positions(int X, int Y){
        x = X;
        y = Y;
    }

    public void update(int px, int py){
        x = x + px;
        y = y +py;
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
