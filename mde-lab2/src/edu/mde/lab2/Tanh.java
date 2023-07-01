package edu.mde.lab2;

import java.text.NumberFormat;

public class Tanh implements Function{
    private final Function fx;

    public Tanh(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.tanh(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Power(new Sech(fx),2),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "tanh(" + fx.toPrettyString(nf) + ")";
    }

    public static Tanh of(Function fx){
        return new Tanh(fx);
    }
}
