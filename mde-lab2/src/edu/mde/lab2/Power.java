package edu.mde.lab2;

import java.text.NumberFormat;

public class Power implements Function{
    private final Function fx;
    private final double index;

    public Power(Function fx, double index) {
        this.fx = fx;
        this.index = index;
    }

    @Override
    public double calculate(double x) {
        return Math.pow(fx.calculate(x),index);
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Multiplication(new Const(index),new Power(fx,index-1)),fx.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        String indexString = nf != null ? nf.format(index) : Double.toString(index);
        return "(" + fx.toPrettyString(nf) + ")^" + indexString;
    }

    public static Power of(Function fx, double index){
        return new Power(fx,index);
    }
}
