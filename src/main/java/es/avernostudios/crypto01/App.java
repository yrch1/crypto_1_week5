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

        BigInteger x0=BigInteger.ZERO,x1=BigInteger.ZERO, hashAccumulator = BigInteger.ONE;

        Vector<BigInteger> leftSide = new Vector<BigInteger>();

        leftSide.add(h.multiply(hashAccumulator.modInverse(p)).mod(p));
        for(int i=1;i < b;i++){

            hashAccumulator = g.multiply(hashAccumulator).mod(p);

            BigInteger val = h.multiply(hashAccumulator.modInverse(p)).mod(p);
            leftSide.add(val);
        }

        BigInteger GB = g.modPow(BigInteger.valueOf(b), p);

        BigInteger rightSide = BigInteger.ONE;
        for(int i=0;i < b;i++){

            if (i%100==0){
                System.out.println(".");
            }
            if(i != 0) {
                rightSide = rightSide.multiply(GB).mod(p);
            }


            if(leftSide.contains(rightSide)){
                x0=BigInteger.valueOf(i);
                x1=BigInteger.valueOf(leftSide.indexOf(rightSide));
                break;
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
