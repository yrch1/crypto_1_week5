package es.avernostudios.crypto01;

import java.math.BigInteger;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App 
{

    public static BigInteger dlog(BigInteger p, BigInteger g, BigInteger h){
        BigInteger result = BigInteger.ZERO;

        int b = 1048576;
        BigInteger gPowB = g.pow(b);

        BigInteger x0=BigInteger.ZERO,x1=BigInteger.ZERO;

        Vector<BigInteger> leftSide = new Vector<BigInteger>();
        for(int i=0;i < b;i++){
            leftSide.add(calculateLeftSide(g,h,i));
        }

        for(int i=0;i < b;i++){
            BigInteger rightSide = calculateRightSide(gPowB, i);
            if(leftSide.contains(rightSide)){
                x0=BigInteger.valueOf(i);
                x1=BigInteger.valueOf(leftSide.indexOf(rightSide));
            }
        }


        result = x0.multiply(BigInteger.valueOf(b)).add(x1);


        return result;
    }


    private static BigInteger calculateLeftSide(BigInteger g, BigInteger h, int x){
        return h.divide(g.pow(x));
    }

    private static BigInteger calculateRightSide(BigInteger gPowB, int x){
        return gPowB.pow(x);
    }
}
