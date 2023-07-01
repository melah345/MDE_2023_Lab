package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Multiplication implements Function {


    private final Function first;
    private final Function second;

    public Multiplication(Function first, Function second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public double calculate(double x) {
        return first.calculate(x) * second.calculate(x);
    }

    @Override
    public Function derivative() {
        return Sum.of(new Multiplication(first.derivative(), second), new Multiplication(first, second.derivative()));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return "(" + first.toPrettyString(nf) + " * " + second.toPrettyString(nf) + ")";
    }

    public static Multiplication of(Function first, Function second) {
        return new Multiplication(first, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiplication that = (Multiplication) o;
        return Objects.equals(first, that.first) && Objects.equals(second, that.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
