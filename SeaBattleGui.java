import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SeaBattleGui {

    private final Size SEA_RESOLUITION = new Size(10, 10);
    JPanel gamePanel = new JPanel();
    JPanel cells = new JPanel();
    JFrame frame = new JFrame("Sea Battle");
    Font font = new Font("", Font.BOLD,10);

    SeaBattleGui(ActionListener parent) {
//        try {
//            UIManager.setLookAndFeel(new SmartLookAndFeel());
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        BorderLayout borderLayout = new BorderLayout();
        gamePanel.setLayout(borderLayout);
        cells.setLayout(new GridLayout(SEA_RESOLUITION.height+1, SEA_RESOLUITION.width+1));
        cells.setFont(font);
        gamePanel.add("Center", cells);


        for (int x = 0; x <= SEA_RESOLUITION.width; x++) {
            if (x > 0) {
                int intName = (Character.valueOf('A') + (x - 1));
                char charName = (char) (intName);
                JButton xButton = new JButton();
                xButton.setText(Character.toString(charName));
                cells.add(xButton);
                xButton.setEnabled(false);}
            else {
                JButton zButton = new JButton();
                cells.add(zButton);
                zButton.setEnabled(false);}

                for (int y = 1; y <= SEA_RESOLUITION.height; y++) {
                    JButton tmpButton = new JButton(" ");
                    if (x == 0) {
                        tmpButton.setText("" + y);
                        tmpButton.setFont(font);
                        cells.add(tmpButton);
                        tmpButton.setEnabled(false);

                    } else {
                        cells.add(tmpButton);
                        tmpButton.setFont(font);
                        tmpButton.addActionListener(parent);
                    }
                }

            }

            frame.setSize(550, 550);
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            frame.setContentPane(gamePanel);
            frame.setFocusable(false);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }


    public void finish(){
        int optionPane = JOptionPane.showConfirmDialog(null,
                "Start new game?", "Game over", JOptionPane.YES_NO_OPTION);
        if(optionPane==0){
            Controller newcontroller=new Controller();
            frame.dispose();
        }
        else
        frame.dispose();
        }
    }



