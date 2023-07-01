package edu.mde.lab2.test;

import edu.mde.lab2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.NumberFormat;

public class LinearTest {
    @Test
    public void testLinearX_ToPrettyString(){
        final Function fx = Linear.X;
        final String EXPECTED_STRING = "x";
        final NumberFormat nf = NumberFormat.getInstance();

        Assertions.assertEquals(fx.toPrettyString(nf), EXPECTED_STRING);
    }
}
