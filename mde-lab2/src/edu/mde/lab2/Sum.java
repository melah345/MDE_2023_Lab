package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Sum extends Composite {
    public Sum() {
        super();
    }

    public Sum(Function... terms) {
        super(terms);
    }

    public Sum(ArrayList<Function> terms) {
        super(terms);
    }

    public double calculate(double x) {
        double result = 0.0;
        for (Function function : terms()) {
            result += function.calculate(x);
        }
        return result;
    }

    public Function derivative() {
        final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size());
        for (Function function : terms()) {
            derivativeTerms.add(function.derivative());
        }
        return new Sum(derivativeTerms);
    }

    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("+");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString()).replace("+-", "-");
    }

    public static Sum of(Function... terms) {
        return new Sum(terms);
    }
}