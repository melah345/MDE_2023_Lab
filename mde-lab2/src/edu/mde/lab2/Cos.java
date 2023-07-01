package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Cos implements Function {
    private final Function fx;

    public Cos(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.cos(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(Const.NEGATIVE_ONE, new Sin(fx)), fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "cos(" + fx.toPrettyString(nf) + ")";
    }

    public static Cos of(Function fx){
        return new Cos(fx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cos cos = (Cos) o;
        return Objects.equals(fx, cos.fx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fx);
    }
}
