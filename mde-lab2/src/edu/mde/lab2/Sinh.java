package edu.mde.lab2;

import java.text.NumberFormat;

public class Sinh implements Function{
    private final Function fx;

    public Sinh(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.sinh(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Cosh(fx),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sinh(" + fx.toPrettyString(nf) + ")";
    }

    public static Sinh of(Function fx){
        return new Sinh(fx);
    }
}
