package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Cosh implements Function{
    private final Function fx;

    public Cosh(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.cosh(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Sinh(fx),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "cosh(" + fx.toPrettyString(nf) + ")";
    }

    public static Cosh of(Function fx){
        return new Cosh(fx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cosh cosh = (Cosh) o;
        return Objects.equals(fx, cosh.fx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fx);
    }
}
