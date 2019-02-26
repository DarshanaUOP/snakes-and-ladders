package example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

import static example.Main.diceInterface;
import static example.Main.main;

/**
 * Created by acer on 30-Mar-18.
 */
public class HomePage extends JFrame {
    private JPanel pnBack;
    private JLabel imgLbl,lbNumOfPlayers,lblGr1,lblGr2,lblGr3,lblGr4,lblGr5,lblCompany;
    private JTextField txGr1,txGr2,txGr3,txGr4,txGr5;
    private JSpinner spinner;
    private JButton btnPlay;
    GridBagConstraints ge=new GridBagConstraints();


    public int numOfPlayers;


    public HomePage(int maxNumOfPlayers){

        pnBack=new JPanel(new GridBagLayout());
        add(pnBack);

        imgLbl=new JLabel();
        imgLbl.setIcon(new ImageIcon(getClass().getResource("snl_logo_header.png")));
        ge.gridx=0;
        ge.gridy=0;
        ge.gridwidth=3;
        ge.gridheight=1;
        pnBack.add(imgLbl,ge);

        lbNumOfPlayers=new JLabel("Number of Players");
        lbNumOfPlayers.setFont(new Font(null,Font.PLAIN,25));
        ge.gridx=0;
        ge.gridy=1;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lbNumOfPlayers,ge);

        spinner=new JSpinner();
        spinner.setValue(1);
        spinner.setFont(new Font(null,Font.BOLD,25));
        ge.gridx=1;
        ge.gridy=1;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(spinner,ge);

        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int a=(Integer) spinner.getValue();
                //System.out.println(a);
                if (a==0 || a>maxNumOfPlayers){
                    spinner.setValue(1);
                }
                numOfPlayers=a;
                //System.out.println("Number of players "  + numOfPlayers);
                enalbeDisable(a);
            }
        });

        Font lableFont=new Font(null,Font.PLAIN,25);

        lblGr1=new JLabel("Player 1");
        lblGr1.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=2;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblGr1,ge);

        lblGr2=new JLabel("Player 2");
        lblGr2.setVisible(false);
        lblGr2.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=3;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblGr2,ge);

        lblGr3=new JLabel("Player 3");
        lblGr3.setVisible(false);
        lblGr3.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=4;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblGr3,ge);

        lblGr4=new JLabel("Player 4");
        lblGr4.setVisible(false);
        lblGr4.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=5;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblGr4,ge);

        lblGr5=new JLabel("Player 5");
        lblGr5.setVisible(false);
        lblGr5.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=6;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblGr5,ge);

        txGr1=new JTextField("Player 1");
        txGr1.setFont(lableFont);
        ge.gridx=2;
        ge.gridy=2;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;

        txGr1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txGr1.selectAll();
            }
        });
        pnBack.add(txGr1,ge);

        txGr2=new JTextField("Player 2");
        txGr2.setVisible(false);
        txGr2.setFont(lableFont);
        ge.gridx=2;
        ge.gridy=3;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        txGr2.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txGr2.selectAll();
            }
        });
        pnBack.add(txGr2,ge);

        txGr3=new JTextField("Player 3");
        txGr3.setVisible(false);
        txGr3.setFont(lableFont);
        ge.gridx=2;
        ge.gridy=4;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        txGr3.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txGr3.selectAll();
            }
        });
        pnBack.add(txGr3,ge);

        txGr4=new JTextField("Player 4");
        txGr4.setVisible(false);
        txGr4.setFont(lableFont);
        ge.gridx=2;
        ge.gridy=5;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        txGr4.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txGr4.selectAll();
            }
        });
        pnBack.add(txGr4,ge);

        txGr5=new JTextField("Player 5");
        txGr5.setVisible(false);
        txGr5.setFont(lableFont);
        ge.gridx=2;
        ge.gridy=6;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        txGr5.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                txGr5.selectAll();
            }
        });
        pnBack.add(txGr5,ge);

        btnPlay = new JButton("Play");
        btnPlay.setFont(lableFont);
        ge.gridx=0;
        ge.gridy=7;
        ge.gridwidth=1;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(btnPlay,ge);

        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                numOfPlayers=Integer.valueOf((Integer) spinner.getValue());

                String[] nameArray = new String[Main.maxNumOfPlayers];

                 nameArray[0] = txGr1.getText();
                 nameArray[1] = txGr2.getText();
                 nameArray[2] = txGr3.getText();
                 nameArray[3] = txGr4.getText();
                 nameArray[4] = txGr5.getText();

                JFrame f=new JFrame("Snake and Ladders - Electro Night 2k18 - Department of Electrical and Electronic Engineering - UOP");
                f.setLayout(new GridBagLayout());
                f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                f.setResizable(true);

                Draw draw = new Draw();
                ge.gridx=0;
                ge.gridy=0;
                ge.gridheight=1;
                ge.gridwidth=4;
                ge.weightx=4;
                ge.weighty=1;
                ge.fill=GridBagConstraints.BOTH;
                draw.update(numOfPlayers,nameArray);

                f.add(draw,ge);
                ge.gridx=5;
                ge.gridy=0;
                ge.gridheight=1;
                ge.gridwidth=1;
                ge.weightx=1;
                ge.weighty=1;
                ge.fill=GridBagConstraints.BOTH;

                diceInterface.setVisible(true);
                diceInterface.setBackground(Color.white);
                f.add(diceInterface,ge);


                f.setVisible(true);
                f.setSize(1600,1000);
            }
        });

        lblCompany = new JLabel("© Darshana Ariyaratna | darshana.uop@gmail.com | +94774901245");
        lblCompany.setVisible(true);
        lblCompany.setBackground(new Color(200,200,0));
        lblCompany.setFont(new Font(null,Font.BOLD,16));
        ge.gridx=0;
        ge.gridy=8;
        ge.gridwidth=3;
        ge.gridheight=1;
        ge.fill=GridBagConstraints.HORIZONTAL;
        pnBack.add(lblCompany,ge);

    }

    public void enalbeDisable(int num){
        switch (num){
            case 1:
                lblGr1.setVisible(true);
                lblGr2.setVisible(false);
                lblGr3.setVisible(false);
                lblGr4.setVisible(false);
                lblGr5.setVisible(false);

                txGr1.setVisible(true);
                txGr2.setVisible(false);
                txGr3.setVisible(false);
                txGr4.setVisible(false);
                txGr5.setVisible(false);

                break;
            case 2:
                lblGr1.setVisible(true);
                lblGr2.setVisible(true);
                lblGr3.setVisible(false);
                lblGr4.setVisible(false);
                lblGr5.setVisible(false);

                txGr1.setVisible(true);
                txGr2.setVisible(true);
                txGr3.setVisible(false);
                txGr4.setVisible(false);
                txGr5.setVisible(false);
                break;
            case 3:

                lblGr1.setVisible(true);
                lblGr2.setVisible(true);
                lblGr3.setVisible(true);
                lblGr4.setVisible(false);
                lblGr5.setVisible(false);

                txGr1.setVisible(true);
                txGr2.setVisible(true);
                txGr3.setVisible(true);
                txGr4.setVisible(false);
                txGr5.setVisible(false);
                break;
            case 4:
                lblGr1.setVisible(true);
                lblGr2.setVisible(true);
                lblGr3.setVisible(true);
                lblGr4.setVisible(true);
                lblGr5.setVisible(false);
                txGr1.setVisible(true);
                txGr2.setVisible(true);
                txGr3.setVisible(true);
                txGr4.setVisible(true);
                txGr5.setVisible(false);

                break;
            case 5:
                lblGr1.setVisible(true);
                lblGr2.setVisible(true);
                lblGr3.setVisible(true);
                lblGr4.setVisible(true);
                lblGr5.setVisible(true);
                txGr1.setVisible(true);
                txGr2.setVisible(true);
                txGr3.setVisible(true);
                txGr4.setVisible(true);
                txGr5.setVisible(true);

                break;
            default:
                break;
        }

    }
}
