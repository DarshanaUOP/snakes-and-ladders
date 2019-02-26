package example;

import javax.swing.*;
import java.awt.*;

/**
 * Created by acer on 19-Nov-17.
 */
public class Controll  {

    public static void refresh(int x,String y[]){
        Draw d = new Draw();
        d.update(x,y);
        //d.repaint();
    }

}
