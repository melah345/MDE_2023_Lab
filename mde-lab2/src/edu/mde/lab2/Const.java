package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Objects;

public class Const extends Number implements Function {
    public static final Const ZERO = new Const(0);
    public static final Const ONE = new Const(1);
    public static final Const NEGATIVE_ONE = new Const(-1);

    private final double value;

    public Const(double value) {
        this.value = value;
    }

    public double calculate(double x) {
        return value;
    }

    public Function derivative() {
        return ZERO;
    }

    public String toPrettyString(NumberFormat nf) {
        return nf.format(value);
    }

    public int intValue() {
        return (int) value;
    }

    public long longValue() {
        return (long) value;
    }

    public float floatValue() {
        return (float) value;
    }

    public double doubleValue() {
        return value;
    }

    public static Const of(double value) {
        return new Const(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Const aConst = (Const) o;
        return Double.compare(aConst.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
