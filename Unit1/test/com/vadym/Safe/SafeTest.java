package com.vadym.Safe;

import com.vadym.Safe.Safe;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by vvkovtun on 01/12/2015.
 */
public class SafeTest {


    @Test
    public void testSerchKeyLevel2() throws Exception {
        int[][] m = {{0,0,1,1},
                     {0,0,1,1},
                     {0,0,0,0},
                     {0,0,1,1}
        };
        Safe safe;
        safe = new Safe();
        m=safe.arrayCopy(safe.findKey(m));
        assertEquals("(2[2,3][2,2])",safe.minWay);
    }


    @Test
    public void testSerchKeyLevel7() throws Exception {
        int[][] m = {{1,0,0,0},
                     {0,0,0,0},
                     {0,0,0,0},
                     {0,0,0,0}
        };
        Safe safe;
        safe = new Safe();
        m=safe.arrayCopy(safe.findKey(m));
        assertEquals("(7[3,0][2,0][1,0][0,3][0,2][0,1][0,0])",safe.minWay);
    }

    @Test
    public void testSerchKeyLeve1() throws Exception {
        int[][] m = {{0,0,0,1},
                     {0,0,0,1},
                     {0,0,0,1},
                     {1,1,1,1}
                  };
        Safe safe;
        safe = new Safe();
        m=safe.arrayCopy(safe.findKey(m));
        assertEquals("(1[3,3])",safe.minWay);
    }

    @Test
    public void testSerchKeyLevel4() throws Exception {

        int[][] m = {{1,1,1,0},
                     {1,1,1,0},
                     {1,1,1,0},
                     {1,1,1,0}
                    };
        Safe safe;
        safe = new Safe();
        m=safe.arrayCopy(safe.findKey(m));
        System.out.println(safe.minWay);
        assertEquals("(4[3,3][2,3][1,3][0,3])",safe.minWay);
    }

    @Test
    public void testSerchKeyGame() throws Exception {
        int[][] m = new int[4][4];
        m[0][0]=0;m[0][1]=1;m[0][2]=0;m[0][3]=1;
        m[1][0]=1;m[1][1]=0;m[1][2]=0;m[1][3]=0;
        m[2][0]=1;m[2][1]=0;m[2][2]=0;m[2][3]=1;
        m[3][0]=1;m[3][1]=0;m[3][2]=1;m[3][3]=0;
        Safe safe;
        safe = new Safe();
        m=safe.arrayCopy(safe.findKey(m));
        System.out.println(safe.minWay);
        assertEquals("(9[3,1][2,3][2,2][2,1][1,3][1,0][0,3][0,2][0,0])",safe.minWay);
    }
}