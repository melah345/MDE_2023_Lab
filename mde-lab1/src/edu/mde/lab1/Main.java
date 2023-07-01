package edu.mde.lab1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static double firsFunction(double a, double b, double x) {
        return Math.cbrt(Math.log(Math.abs(Math.tanh(a * x)))) - Math.pow(Math.cos(Math.abs(b * x + a)), 3.);
    }

    public static double secondFunction(double a, double b, double x) {
        return x * Math.pow(Math.sinh(Math.abs(a * Math.cbrt(Math.cos(b * x)))), 2.0);
    }

    private double a = -11;
    private double b = 0.5;
    private double x = 21.1;

    public void scanValues() {
        final Scanner scanner = new Scanner(System.in);
        System.out.print("Уведіть a:");
        this.a = scanner.nextDouble();
        System.out.print("Уведіть b:");
        this.b = scanner.nextDouble();
        System.out.print("Уведіть x:");
        this.x = scanner.nextDouble();
    }

    public void printValues() {
        System.out.format("a = %f", a).println();
        System.out.format("b = %f", b).println();
        System.out.format("x = %f", x).println();
    }

    public void printResults() {
        System.out.format("f1(x) = %f", firsFunction(a, b, x)).println();
        System.out.format("f2(x) = %f", secondFunction(a, b, x)).println();
    }

    private static final SimpleDateFormat
            dateFormat = new SimpleDateFormat("dd-MM-yy', 'HH:mm");

    public static void printCurrentDate() {
        final Date now = new Date();
        System.out.format("Поточна дата і час: %s", dateFormat.format(now)).println();
    }

    public void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Введення значень вхідних даних");
        System.out.println("2. Виведення значень вхідних даних");
        System.out.println("3. Виведення обчислених значень функцій");
        System.out.println("4. Виведення поточної дати і часу");
        System.out.println("5. Вихід із меню");
    }

    public void runMenu() {
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Оберіть пункт меню: ");
            final int selected = scanner.nextInt();
            switch (selected) {
                case 1:
                    scanValues();
                    break;
                case 2:
                    printValues();
                    break;
                case 3:
                    printResults();
                    break;
                case 4:
                    printCurrentDate();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Уведене значення має бути у діапазоні 1..5");
            }
        }
    }

    public static void main(String[] args) {
        final Main main = new Main();
        System.out.println("Розпочато роботу програми.");
        main.printValues();
        main.runMenu();
        System.out.println("Роботу програми закінчено.");
    }
}