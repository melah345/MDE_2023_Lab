package edu.mde.lab2.test;

import edu.mde.lab2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConstTest {
    @Test
    public void testConst_ZERO(){
        final Function ZERO_TEST = Const.ZERO;
        final Function EXPECTED_ZERO = Const.of(0);

        Assertions.assertEquals(ZERO_TEST, EXPECTED_ZERO);
    }

    @Test
    public void testConst_Calculate(){
        final double expected_value = 12;
        final Function CALCULATE_TEST = Const.of(expected_value);
        final double EXPECTED_CALCULATE = expected_value;

        Assertions.assertEquals(CALCULATE_TEST.calculate(0), EXPECTED_CALCULATE);
    }

    @Test
    public void testConst_Derivative(){
        final Function DERIVATIVE_TEST = Const.of(12);
        final Function EXPECTED_DERIVATIVE = Const.ZERO;

        Assertions.assertEquals(DERIVATIVE_TEST.derivative(), EXPECTED_DERIVATIVE);
    }
}
