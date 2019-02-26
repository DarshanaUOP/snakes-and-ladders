package example;

import javax.swing.*;
import java.awt.*;

/**
 * Created by acer on 28-Jan-18.
 */
public class DiceInterface extends JPanel{
    int num=0;
    int height=100,gap=5,startY=Draw.sizeOfSqr;
    public void Update(int number){
        num=number;
        //System.out.println(num);
    }
    public void paint(Graphics g) {

        //System.out.println("***");

        super.paint(g);
        this.setBackground(Color.BLACK);

        Graphics2D g2 = (Graphics2D) g;

        //g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //g2.rotate(Math.toRadians(270));

        g2.setColor(Color.CYAN);
        g2.setFont(new Font(null,Font.BOLD,120));
        g2.drawString(String.valueOf(num),2*gap+height,startY+2*gap+3*height);


        g2.drawRect(gap,startY+gap,height,height);
        if (num==1||num==2||num==3||num==4||num==5||num==6){
            g2.fillRect(gap,startY+gap,height,height);
        }

        g2.drawRect(2*gap+height,startY+gap,height,height);
        if (num==2||num==3||num==4||num==5||num==6){
            g2.fillRect(2*gap+height,startY+gap,height,height);
        }

        g2.drawRect(3*gap+2*height,startY+gap,height,height);
        if (num==3||num==4||num==5||num==6){
            g2.fillRect(3*gap+2*height,startY+gap,height,height);
        }

        g2.drawRect(gap,startY+2*gap+height,height,height);
        if (num==4||num==5||num==6){
            g2.fillRect(gap,startY+2*gap+height,height,height);
        }

        g2.drawRect(2*gap+height,startY+2*gap+height,height,height);
        if (num==5||num==6){
            g2.fillRect(2*gap+height,startY+2*gap+height,height,height);
        }

        g2.drawRect(3*gap+2*height,startY+2*gap+height,height,height);
        if (num==6){
            g2.fillRect(3*gap+2*height,startY+2*gap+height,height,height);
        }

    }
}
