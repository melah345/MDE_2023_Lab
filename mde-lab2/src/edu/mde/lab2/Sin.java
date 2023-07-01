package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Sin implements Function{
    private final Function fx;

    public Sin(Function fx) {
        this.fx = fx;
    }

    @Override
    public double calculate(double x) {
        return Math.sin(fx.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Cos(fx),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "sin(" + fx.toPrettyString(nf) + ")";
    }

    public static Sin of(Function fx){
        return new Sin(fx);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sin sin = (Sin) o;
        return Objects.equals(fx, sin.fx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fx);
    }
}
