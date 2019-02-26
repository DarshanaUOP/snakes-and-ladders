package example;

import static java.lang.StrictMath.round;

/**
 * Created by acer on 18-Nov-17.
 */
class NumberProcess {
    public static int  getNumber(int i,int j){

        /**
         * This method is able to find the number of relative square of given "i" and "j"
         */

        int number;

        if (j%2 == 0){                          //when j is even
            number = 100 - 10*j + i;
        }else{                                  //when j is odd
            number = (10 - j)*10 + (11 -i);
        }
        return number;
    }

    public static int[] getIJ(int num){

        int[] IJ = new int[2];
        int i;
        /**
         * Inverse operation of the method getNumber();
                 */
        int j = 10-round((num - 1) / 10);

    if (j%2 == 0){                           //When j is even
            i = num - 100 + 10*j;
        }else {                             //When j is odd
            i = 11 + 10*(10 - j) - num;
        }

        IJ[0] = i;
        IJ[1] = j;

        return IJ;
    }

}
