package sortassignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger ;

/**
 * Source : http://rosettacode.org/wiki/Pi
 * Modified a bit to suit data generation to a file.
 */
public class PI {
    final BigInteger TWO = BigInteger.valueOf(2) ;
    final BigInteger THREE = BigInteger.valueOf(3) ;
    final BigInteger FOUR = BigInteger.valueOf(4) ;
    final BigInteger SEVEN = BigInteger.valueOf(7) ;

    BigInteger q = BigInteger.ONE ;
    BigInteger r = BigInteger.ZERO ;
    BigInteger t = BigInteger.ONE ;
    BigInteger k = BigInteger.ONE ;
    BigInteger n = BigInteger.valueOf(3) ;
    BigInteger l = BigInteger.valueOf(3) ;

    public void calcPiDigits(String fileName, int weight) throws IOException {
        BigInteger nn, nr;
        PrintWriter printWriter = new PrintWriter(fileName, "UTF-8");

        for (int i=0; i < weight; i++) {
            for (int j=0; j < weight; j++) {
                if (FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1) {
                    printWriter.println(n);
                    nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t))) ;
                    n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n)) ;
                    q = q.multiply(BigInteger.TEN) ;
                    r = nr ;
                }
                else{
                    nr = TWO.multiply(q).add(r).multiply(l) ;
                    nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l)) ;
                    q = q.multiply(k) ;
                    t = t.multiply(l) ;
                    l = l.add(TWO) ;
                    k = k.add(BigInteger.ONE) ;
                    n = nn ;
                    r = nr ;
                }

            }

        }
        printWriter.close();
    }
}