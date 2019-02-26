package example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 * Created by acer on 17-Nov-17.
 */
class Draw extends JPanel {

    String[]names = new String[5];
    int[] positions = new int[5];       //positions is the array that contains THE POSITIONS OF THE PLAYERS;
    Color[] playerColor = new Color[5]; //playerColor is the array that contains THE COLORS OF THE PLAYERS
                                        //5 is maximum number of players;
    int[][] snakes=new int[2][4];            //snakes array
    int[][] ladders=new int[2][4];           //ladders array
    static int[][] miniGames = new int[][]{{22,23,24,55,57,58,59,85,86,87},{0,0,0,0,0,0,0,0,0,0}};      //miniGames array
    static int[] playersGameDone=new int[]{0,0,0,0,0};          //check for players game status;

    static int sizeOfSqr=80;   //height and width of a square;
    int places=0;
    int numOfPlayers;
    int xPlayer;
    int a[];

    int colorStable=0;
    Random random=new Random();

    private JButton playButton;
    private JLabel lblWhoPlay;
    DiceInterface diceInterface=new DiceInterface();

    AudioPlayer audioPlayer=new AudioPlayer();

     public void update(int numOfPlyer,String[] playerNames){
         numOfPlayers = numOfPlyer;
         names = playerNames;
    }

    static String lable;        //To print the number inside of square;
    int[] placesArray=new int[6];

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.black);

        int num=100;

        snakes= new int[][]{{17, 60, 91, 98}, {2, 37, 69, 77}};
        ladders=new int[][]{{5,30,63,67},{47,54,79,93}};


        /**
         * print snake , ladder arrays

            for (int j=0;j<=3;j++){
                System.out.print(snakes[0][j]+" , "+snakes[1][j]+"\t");
                System.out.print(ladders[0][j]+" , "+ladders[1][j]+"\n");
            }
         */

        int lineSpace=2;    //lineSpace between two squares;
        int x,y,numXY;
        for (int i=1;i<=10;i++) {
            for (int j=1;j<=10;j++) {       //MAKING 10x10 MATRIX;
                numXY = NumberProcess.getNumber(i,j);

                for (int t=0;t<=9;t++){
                    if ((miniGames[0][t])==numXY && (miniGames[1][t])==0 && playersGameDone[xPlayer]==0){
                        g.setColor(Color.RED);
                        break;
                    }else{
                        g.setColor(Color.CYAN);
                    }
                }

                g.fillRect(i*sizeOfSqr,j*sizeOfSqr, sizeOfSqr-lineSpace, sizeOfSqr-lineSpace);          //PRINTING THE CELLS;
                g.setColor(Color.BLACK);
                FontMetrics fm = g.getFontMetrics();
                Rectangle2D r = fm.getStringBounds(String.valueOf(i*10+j),g);

                x = (int)r.getWidth()/2;
                y = (int)r.getHeight()/2;
                g.setFont(new Font(null,Font.BOLD,17));
                g.setColor(Color.BLACK);

                lable = String.valueOf(numXY);
                g.drawString(lable, i*sizeOfSqr-lineSpace+2*x,j*sizeOfSqr-lineSpace+3*y);       //NUMBERING THE CELLS;

                num--;
            }
        }

        g.setColor(Color.BLACK);        //Draw Ladders
        for (int j=0;j<=3;j++) {
            int[] start,end;
            int[] xPoints,yPoints;

            start=NumberProcess.getIJ(ladders[0][j]);
            end=NumberProcess.getIJ(ladders[1][j]);

            int x1=(int) ((start[0]+0.5)*sizeOfSqr);
            int x2=(int) ((end[0]+0.5)*sizeOfSqr);
            int x3=x2-4*lineSpace;
            int x4=x1-4*lineSpace;
            xPoints=new int[]{x1,x2,x3,x4};

            int y1=(int) ((start[1]+0.5)*sizeOfSqr);
            int y2=(int) ((end[1]+0.5)*sizeOfSqr);
            int y3=y2+4*lineSpace;
            int y4=y1+4*lineSpace;
            yPoints=new int[]{y1,y2,y3,y4};

            g.fillPolygon(xPoints,yPoints,4);
        }

        g.setColor(Color.RED);          //Draw snakes
        for (int j=0;j<=3;j++) {
            int[] start,end;
            int[] xPoints,yPoints;

            start=NumberProcess.getIJ(snakes[0][j]);
            end=NumberProcess.getIJ(snakes[1][j]);

            int x1=(int) ((start[0]+0.5)*sizeOfSqr);
            int x2=(int) ((end[0]+0.5)*sizeOfSqr);
            int x3=x2-4*lineSpace;
            int x4=x1-4*lineSpace;
            xPoints=new int[]{x1,x2,x3,x4};

            int y1=(int) ((start[1]+0.5)*sizeOfSqr);
            int y2=(int) ((end[1]+0.5)*sizeOfSqr);
            int y3=y2+4*lineSpace;
            int y4=y1+4*lineSpace;
            yPoints=new int[]{y1,y2,y3,y4};

            g.fillPolygon(xPoints,yPoints,4);
        }

        g.setColor(Color.CYAN);
        g.drawRect(sizeOfSqr*12,sizeOfSqr,sizeOfSqr*7,sizeOfSqr*10);            //border of the score board

        g.setColor(Color.BLUE);
        g.setFont(new Font(null,Font.BOLD,16));

        int lastPossition=0;
        try {
            for (int i = 0; i <= numOfPlayers-1; i++) {

                if (colorStable==0) {
                    playerColor[i] = randColor();           //IT AVOID CHANGING PLAYERS COLORS AT ANY TIME
                }
                g.setColor(playerColor[i]);

                //System.out.println(xPlayer);
                if (positions[i]<100) {
                    String lable=" "+names[i] + " : [ " + positions[i] + " ]: need " + (100 - positions[i]) + " Points && Mini Game " + ((playersGameDone[i])==1 ? "Selected." : "not Selected.");
                    g.drawString(lable, 13 * sizeOfSqr, (2 + i) * sizeOfSqr);                //PRINTING THE NAMES OF PLAYERS;
                }else {
                    g.drawString(" "+names[i] + " : [ " + positions[i] +" ] Finished. "+placesArray[i] +(placesArray[i]==1?"st":(placesArray[i]==2?"nd":(placesArray[i]==3?"rd":"th"))), 13 * sizeOfSqr, (2 + i) * sizeOfSqr);
                }
                g.fillRect((int) (12.5*sizeOfSqr),(3+2*i)*sizeOfSqr/2,sizeOfSqr/2,sizeOfSqr/2);       //DRAW A SMALL SQUARE BEFORE THE NAME OF PLAYER;
                g.setColor(Color.CYAN);
                g.drawRect((int) (12.5*sizeOfSqr),((3+2*xPlayer)*sizeOfSqr/2),(int) (sizeOfSqr*6.5),sizeOfSqr/2+3*lineSpace);
                                //g.fillPolygon([(int) (12.5*sizeOfSqr),(int) (12.5*sizeOfSqr),((int) (12.5*sizeOfSqr)+sizeOfSqr/2)],[(3+2*i)*sizeOfSqr/2,((3+2*i)*sizeOfSqr/2)-sizeOfSqr/2,sizeOfSqr],3);
                                                                                            //" Tn=a+(n-1)d " have used for Draw small squares;
                lastPossition++;
            }

        }catch (Exception e){
            //JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }

        g.setColor(Color.CYAN);
        g.setFont(new Font(null,Font.ITALIC+Font.BOLD,30));
        //g.drawString("Created by Darshana Ariyarathna | +94774901245 | darshana.uop@gmail.com ",2*sizeOfSqr,12*sizeOfSqr);
        g.drawString("ELECTRO NIGHT 2K18 - Department of Elecrtical and Electronic Engineering ",2*sizeOfSqr,12*sizeOfSqr);

        g.setFont(new Font(null,Font.BOLD + Font.TRUETYPE_FONT,25));
        g.drawString("Snakes and Ladders",sizeOfSqr,sizeOfSqr/2);

        if (colorStable==0) {       //WRITE A CODE IF YOU NEED MAKE ONCE TIME ,NOT REPETITIVE;

            playButton = new JButton("Play");
            playButton.setEnabled(true);
            playButton.setBounds(12 * sizeOfSqr, (2 + lastPossition) * sizeOfSqr, 2 * sizeOfSqr, sizeOfSqr / 2);
            add(playButton);

            lblWhoPlay = new JLabel();
            lblWhoPlay.setVisible(true);
            lblWhoPlay.setFont(new Font(null, Font.BOLD, 15));
            lblWhoPlay.setText(names[xPlayer] + "'s turn.");
            //lblWhoPlay.setForeground(playerColor[0]);
            lblWhoPlay.setForeground(Color.WHITE);
            lblWhoPlay.setBounds(15 * sizeOfSqr, (2 + lastPossition) * sizeOfSqr, 2 * sizeOfSqr, sizeOfSqr / 2);
            add(lblWhoPlay);


            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                            int dVal=0;
                            for (int i=0;i<=10;i++){
                                dVal =getDiceValue();
                                Main.diceInterface.Update(dVal);
                                Main.diceInterface.repaint();
                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e1){}
                            }
                            playGame(dVal);
                            Controll.refresh(numOfPlayers, names);
                            repaint();

                        }
                    }).start();

                }
            });
        }

        for (int i=numOfPlayers-1;i>=0;i--){
            //System.out.println("lion , "+positions[i]);
                a = NumberProcess.getIJ(positions[i]);
                g.setColor(playerColor[i]);
                g.fillRect(a[0]*sizeOfSqr,a[1]*sizeOfSqr, sizeOfSqr-lineSpace, sizeOfSqr-lineSpace);
        }

        colorStable++;          //IT AVOID CHANGING PLAYERS COLORS AT ANY TIME

    }

    public Color randColor(){
        int r,g,b;
        r = (int)(Math.random()*256);
        g = (int)(Math.random()*256);
        b = (int)(Math.random()*256);

        return(new Color(r,g,b));
    }


    public int[] playGame(int DiceValue) {

        boolean key=false;
        boolean keyBypass = true;


        int old = positions[xPlayer];
        int dice = 0;

        positions[xPlayer] = positions[xPlayer] + DiceValue;
        /**
         * to set snakes and ladders.
         *
        if (positions[xPlayer]==20){
            positions[xPlayer]=90;
        }
         */

        for (int i=0;i<=3;i++){

            if (positions[xPlayer]==ladders[0][i]){
                this.repaint();
                JOptionPane.showMessageDialog(null,"Take a Detour ",names[xPlayer]+" Found a Ladder",JOptionPane.PLAIN_MESSAGE);
                positions[xPlayer]=ladders[1][i];
            }
        }
        for (int i=0;i<=3;i++){

            if (positions[xPlayer]==snakes[0][i]){
                this.repaint();
                JOptionPane.showMessageDialog(null,"Snack Time",names[xPlayer]+" Snake",JOptionPane.PLAIN_MESSAGE);
                positions[xPlayer]=snakes[1][i];
            }
        }
        for (int t=0;t<=9;t++){
            if ((miniGames[0][t])==positions[xPlayer] && (miniGames[1][t])==0 && playersGameDone[xPlayer]==0){
                miniGames[1][t]++;
                this.repaint();
                JOptionPane.showMessageDialog(null,names[xPlayer]+" It's Mini Game time, choose your Destiny...!!","Mini Game",JOptionPane.PLAIN_MESSAGE);
                //audioPlayer.say("miniGame.wav");
                playersGameDone[xPlayer]++;
                break;
            }else{

            }
        }
        //System.out.println(positions[xPlayer]+"\t"+xPlayer+"\t");

        if (positions[xPlayer] >= 100) {
            positions[xPlayer] = 100;
            places++;
            //System.out.println(xPlayer+" , "+placesArray[xPlayer]+" , "+places);
            placesArray[xPlayer] = places;

            //System.out.println(xPlayer+" , "+placesArray[xPlayer]+" , "+places);

            JOptionPane.showMessageDialog(null, "Congratulations " + names[xPlayer] + " You have completed your JOURNEY..!! "+places+" !!", "End of the JOURNEY..!!", JOptionPane.PLAIN_MESSAGE);

            playButton.setEnabled(true);
            if (places==numOfPlayers-1){
                playButton.setEnabled(false);
            }
            //setEnabled(false);
        }
        /**
            key=Boolean.valueOf(positions[xPlayer]==100);

            if (key){
                while (key){
                    xPlayer++;
                    key=Boolean.valueOf(positions[xPlayer]==100);
                    keyBypass=false;
                }
            }else{
            }
            if (keyBypass) {
                xPlayer++;
            }else {
                keyBypass=true;
            }
            */

            //System.out.println("1]"+xPlayer);
            xPlayer=nextPlayersNumber(xPlayer);
            //System.out.println("2]"+xPlayer);
            lblWhoPlay.setText(names[xPlayer] + "'s turn");
        //}

        return positions;
    }
    public int nextPlayersNumber(int xPlayer){
        int nextNum=0,n=0;
        boolean key=true;

        //System.out.println("*****");
        if (xPlayer +1 ==  numOfPlayers) {
            xPlayer = -1;
        }
        try{
            while (key){
                //System.out.println("111");
                if (positions[xPlayer+1]<100){
                    key=false;
                    xPlayer++;
                    //System.out.println("222");
                    //return nextNum;
                }else {
                    xPlayer++;
                    //System.out.println("333");

                    if (xPlayer + 1 == numOfPlayers) {
                        xPlayer = -1;
                    }
                }
            }
        }catch (Exception e){}
        nextNum=xPlayer;
        //System.out.println(nextNum);
        return nextNum;
    }

    public int getDiceValue(){

        int diceValue = random.nextInt(6)+1;
        return diceValue;
    }


}
