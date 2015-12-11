package com.vadym.Convertor;

import com.vadym.Convertor.NumberConvertor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vvkovtun on 27/11/2015.
 */
public class NumberConvertorTest {


    @Test
    public void testToInt() throws Exception {

        assertEquals(1, NumberConvertor.toInt("1"));
        assertEquals(-1, NumberConvertor.toInt("-1"));
        assertEquals(0, NumberConvertor.toInt("0"));
        assertEquals(2147483647, NumberConvertor.toInt("2147483647"));
        assertEquals(-2147483648, NumberConvertor.toInt("-2147483648"));

    }

    @Test
    public void testToStringInt() throws Exception {

        assertEquals("1", NumberConvertor.toString(1));
        assertEquals("-1", NumberConvertor.toString(-1));
        assertEquals("0", NumberConvertor.toString(0));
        assertEquals("2147483647", NumberConvertor.toString(2147483647));
        assertEquals("-2147483648", NumberConvertor.toString(-2147483648));

    }

    @Test
    public void testToStringDouble() throws Exception {
        assertEquals(1, NumberConvertor.toDouble("1"),0.00001);
        assertEquals(-1, NumberConvertor.toDouble("-1"),0.00001);
        assertEquals(0, NumberConvertor.toDouble("0"),0.00001);
        assertEquals(2147483647, NumberConvertor.toDouble("2147483647"),0.00001);
        assertEquals(-2147483648, NumberConvertor.toDouble("-2147483648"),0.00001);
        assertEquals(1.1, NumberConvertor.toDouble("1.1"),0.00001);
        assertEquals(91234567890.912345, NumberConvertor.toDouble("91234567890.912345"),0.0000001);
    }

    @Test
    public void testToDouble() throws Exception {


    }
}