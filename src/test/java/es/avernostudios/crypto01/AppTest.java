package es.avernostudios.crypto01;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * Created by yrch on 19/09/15.
 */
public class AppTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testDlog() throws Exception {

        BigInteger p = new BigInteger("134078079299425970995740249982058461274793658205923933" +
                "77723561443721764030073546976801874298166903427690031" +
                "858186486050853753882811946569946433649006084171");

        BigInteger g = new BigInteger("11717829880366207009516117596335367088558084999998952205" +
                "59997945906392949973658374667057217647146031292859482967" +
                "5428279466566527115212748467589894601965568");

        BigInteger h = new BigInteger("323947510405045044356526437872806578864909752095244" +
                "952783479245297198197614329255807385693795855318053" +
                "2878928001494706097394108577585732452307673444020333");


        Assert.assertEquals((new BigInteger("375374217830")),App.dlog(p, g, h));
    }
}