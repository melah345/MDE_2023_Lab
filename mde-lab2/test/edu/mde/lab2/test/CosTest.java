package edu.mde.lab2.test;

import edu.mde.lab2.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CosTest {
    @Test
    public void testCos_Derivative(){
        final Function fx = Linear.X;
        final Function DERIVATIVE_TEST = Cos.of(fx);
        final Function EXPECTED_DERIVATIVE = Multiplication.of(Multiplication.of(Const.NEGATIVE_ONE, Sin.of(fx)), fx.derivative());

        Assertions.assertEquals(DERIVATIVE_TEST.derivative(), EXPECTED_DERIVATIVE);
    }
}
