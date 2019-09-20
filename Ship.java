
import java.awt.*;

public class Ship {


    Point start;
    ShipDirection direction;
    private int length;
    byte state;
    int count=0;

    public Ship(Point start, ShipDirection direction, int length) {
        this.start = start;
        this.direction = direction;
        this.length = length;
        byte bit = 1;
        for (int deck = 0; deck < length; deck++, bit <<= 1) {
            //int bit=1<<deck;
            state |= bit;
        }
    }


    public boolean isAlive() {
        return state != 0;
    }

    private boolean isYourPoint(Point p)  {
        if (p.x != start.x && p.y != start.y) {
            return false;
        }
        if (direction == ShipDirection.DOWN && p.x == start.x) {
            return p.y >= start.y && p.y < start.y + length;

        }
        if (direction == ShipDirection.RIGHT && p.y == start.y) {
            return p.x >= start.x && p.x < start.x + length;
        }
        return false;

    }

    public boolean bang(Point p) {
        boolean isMyPoint=isYourPoint(p);
            if(isMyPoint){
            state>>=1;}
            return isMyPoint;
    }


    enum ShipDirection {
        RIGHT, DOWN
    }

}

