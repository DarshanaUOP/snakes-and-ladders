package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;

/**
 * Created by acer on 17-Nov-17.
 */
public class Main {

    static DiceInterface diceInterface=new DiceInterface();
    //int numOfPlayers;
    public static int  maxNumOfPlayers=5; //DO NOT CHANGE;
    public static void main(String[] args) {

        int numOfPlayers;

        HomePage homePage=new HomePage(maxNumOfPlayers);
        homePage.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        homePage.setSize(800,800);
        homePage.setTitle("Snakes and Ladders");
        homePage.setVisible(true);
        homePage.setEnabled(true);

        /**
         *
         *
         GridBagConstraints g=new GridBagConstraints();
         //Controll controll =new Controll();
         do {
         String noPlayers = JOptionPane.showInputDialog("How many Players?", 1);
         numOfPlayers = Integer.valueOf(noPlayers);

         if (numOfPlayers>maxNumOfPlayers){
         JOptionPane.showMessageDialog(null,"Maximum Number of players :"+maxNumOfPlayers,"Invalid Input",JOptionPane.ERROR_MESSAGE);
         }

         }while (numOfPlayers>maxNumOfPlayers);

         String[] nameArray = new String[numOfPlayers];

         for (int i = 0; i<numOfPlayers; i++){
         nameArray[i] = JOptionPane.showInputDialog("Player "+(i+1)+" Name?","Group "+(i+1));
         }
         JFrame f=new JFrame("Snake and Ladders - Electro Night 2k18 - Department of Electrical and Electronic Engineering - UOP");
         f.setLayout(new GridBagLayout());
         f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         f.setResizable(true);

         Draw draw = new Draw();
         g.gridx=0;
         g.gridy=0;
         g.gridheight=1;
         g.gridwidth=4;
         g.weightx=4;
         g.weighty=1;
         g.fill=GridBagConstraints.BOTH;
         draw.update(numOfPlayers,nameArray);

         f.add(draw,g);
         g.gridx=5;
         g.gridy=0;
         g.gridheight=1;
         g.gridwidth=1;
         g.weightx=1;
         g.weighty=1;
         g.fill=GridBagConstraints.BOTH;

         diceInterface.setVisible(true);
         diceInterface.setBackground(Color.white);
         f.add(diceInterface,g);


         //f.setVisible(true);
         //f.setSize(1500,760);
         *
         */







        //f.setLayout(new GridLayout(5,3));
        //f.add(controll);



    }
}
