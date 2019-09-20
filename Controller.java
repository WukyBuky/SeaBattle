import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    SeaSpace seaSpace;
    SeaBattleGui seaBattleGui;

    Controller(){
        seaSpace=new SeaSpace();
        seaSpace.randomPlace();
        seaBattleGui = new SeaBattleGui(this);
    }


    public static void main(String[] args) {
    Controller controller = new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        //clickedButton.getName();
        Point p = new Point (clickedButton.getX()/clickedButton.getWidth(),
                clickedButton.getY()/clickedButton.getHeight());
        BangResult bangResult = seaSpace.bang(p) ;
            switch (bangResult){
                case MISSED:
                    clickedButton.setText("O");
                    break;
                case WOUNDED:
                    clickedButton.setText("X");
                    break;
                case KILLED:
                    clickedButton.setText("X");
                    if (seaSpace.isOver()){
                        seaBattleGui.finish();
                    } break;
            } clickedButton.setEnabled(false);
    }
}
