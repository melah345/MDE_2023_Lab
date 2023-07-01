package edu.mde.lab2;

import java.text.NumberFormat;

public class Sech implements Function{
    private final Function fx;

    public Sech(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return 1. / Math.cosh(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Tanh(fx),new Sech(fx)), fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sech(" + fx.toPrettyString(nf) + ")";
    }

    public static Sech of(Function sech){
        return new Sech(sech);
    }
}
