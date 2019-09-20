import com.sun.glass.ui.Size;

import javax.management.InvalidApplicationException;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeaSpace {
    private static final int MAX_DECKS_COUNT = 4;
    private final Size SEA_RESOLUITION = new Size(10, 10);
    private ArrayList<Ship> ships = new ArrayList<>(); // проверить пустой или нет вначале, и проерять, не пустой ли в ходе игры


    public BangResult bang(Point p)  {
        for (Ship ship : ships) {
            if (ship.bang(p)) {
                return ship.isAlive() ? BangResult.WOUNDED : BangResult.KILLED;
                //выкинуть окно "Ранен/Убит/Geme over". Окно "Убит" вызывает isOver(); JOptionPane
            }
        }
        return BangResult.MISSED;
    }

    public void randomPlace() {
        placeShip(1, MAX_DECKS_COUNT);
    }

    private void placeShip(int shipCount, int decks){
        if(shipCount==0){
            decks-=1;
            if(decks!=0){
                placeShip(MAX_DECKS_COUNT+1-decks, decks);
            }
        } else {
            createNewShip(decks);
            placeShip(shipCount-1, decks);
        }
    }

    private void createNewShip(int decks){
        int x=(int) Math.random()*SEA_RESOLUITION.width;
        int y=(int) Math.random()*SEA_RESOLUITION.height;
        Ship.ShipDirection direction = Math.random() < .5 ? Ship.ShipDirection.RIGHT : Ship.ShipDirection.DOWN;

       Ship newShip=new Ship(new Point(x,y), direction,decks);

        if((x+decks<=SEA_RESOLUITION.width)&&(direction== Ship.ShipDirection.RIGHT)){

        }
    }

    public boolean isOver() {
        boolean over = false;
        for (Ship ship : ships) {
            if (ship.isAlive()) {
                return false;
            }
        }
    return true;
    }
}
