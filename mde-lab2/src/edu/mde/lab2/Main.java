package edu.mde.lab2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a = -11;
        double b = 0.5;

        final Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть х: ");
        final double x = scanner.nextDouble();

        final Function expressionFirst = Sum.of(
                Cbrt.of(
                        Logn.of(
                                Abs.of(
                                        Tanh.of(
                                                Linear.of(a)
                                        )
                                )
                        )
                ),
                Multiplication.of(
                        Const.NEGATIVE_ONE,
                        Power.of(
                                Cos.of(
                                        Abs.of(
                                                Sum.of(
                                                        Linear.of(b),
                                                        Const.of(a)
                                                )
                                        )
                                ),
                                3
                        )
                )
        );

        final NumberFormat nf_1 = NumberFormat.getInstance();
        System.out.format("f_1(x) = %s", expressionFirst.toPrettyString(nf_1)).println();
        System.out.format("f_1'(x) = %s", expressionFirst.derivative().toPrettyString(nf_1)).println();
        System.out.format("f_1(" + x + ") = %f", expressionFirst.calculate(x)).println();
        System.out.format("f_1'(" + x + ") =%f", expressionFirst.derivative().calculate(x)).println();

        final Function expressionSecond = Multiplication.of(
                Linear.X,
                Power.of(
                        Sinh.of(
                                Abs.of(
                                        Multiplication.of(
                                                Const.of(a),
                                                Cbrt.of(
                                                        Cos.of(
                                                                Linear.of(b)
                                                        )
                                                )
                                        )
                                )
                        ),
                        2
                )
        );

        final NumberFormat nf_2 = NumberFormat.getInstance();
        System.out.format("f_2(x) = %s", expressionSecond.toPrettyString(nf_2)).println();
        System.out.format("f_2'(x) = %s", expressionSecond.derivative().toPrettyString(nf_2)).println();
        System.out.format("f_2(" + x + ") = %f", expressionSecond.calculate(x)).println();
        System.out.format("f_2'(" + x + ") =%f", expressionSecond.derivative().calculate(x)).println();
    }
}