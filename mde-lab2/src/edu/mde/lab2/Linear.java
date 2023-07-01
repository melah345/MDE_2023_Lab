package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Linear implements Function {
    public static final Linear X = new Linear(1.0) {
        public String toPrettyString(NumberFormat nf) {
            return "x";
        }
    };
    private final double coefficient;

    public Linear(double coefficient) {
        this.coefficient = coefficient;
    }

    public double calculate(double x) {
        return x * coefficient;
    }

    public Function derivative() {
        return new Const(coefficient);
    }

    public String toPrettyString(NumberFormat nf) {
        return String.format("%s*x", nf.format(coefficient));
    }

    public static Linear of(double coefficient) {
        return new Linear(coefficient);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linear linear = (Linear) o;
        return Double.compare(linear.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient);
    }
}
