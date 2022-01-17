package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.DivideByZeroException;
import org.iesfm.calculator.exceptions.EmptyArrayException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatorMenu {

    private Scanner scanner;
    private Calculator calculator;

    public CalculatorMenu(Scanner scanner, Calculator calculator) {
        this.scanner = scanner;
        this.calculator = calculator;
    }

    private int askInteger(String message) {
        Integer number = null;
        while (number == null) {
            try {
                System.out.println(message);
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, no has introducido un número");
            } finally {
                scanner.nextLine();
            }
        }

        return number;
    }

    private double askDouble(String message) {
        Double number = null;
        while (number == null) {
            try {
                System.out.println(message);
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error, no has introducido un número");
            } finally {
                scanner.nextLine();
            }
        }

        return number;
    }

    private int askOperation() {
        System.out.println("Qué deseas hacer");
        System.out.println("1. Dividir");
        System.out.println("2. Media");
        System.out.println("3. Salir");
        int operation = askInteger("");

        while (operation != 1 && operation != 2 && operation != 3) {
            operation = askInteger("Opción inválida...");
        }

        return operation;
    }

    private int askSize() {
        int size = askInteger("Introduce el tamaño del array");
        while (size < 0) {
            size = askInteger("El tamaño debe ser mayor que cero, introduce el tamaño del array");
        }
        return size;
    }

    private double[] askNumbers() {
        double[] numbers = new double[askSize()];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = askDouble("Introduce un número");
        }
        return numbers;
    }

    public void run() {
        int operation = askOperation();
        while (operation != 3) {
            if (operation == 1) {
                try {
                    double res = calculator.divide(
                            askDouble("Introduce un número"),
                            askDouble("Introduce otro número")
                    );
                    System.out.println("El resultado es " + res);
                } catch (DivideByZeroException e) {
                    System.out.println("No es posible dividir entre cero");
                }
            } else if (operation == 2) {
                try {
                    double res = calculator.average(askNumbers());
                    System.out.println("La media es " + res);
                } catch (EmptyArrayException e) {
                    System.out.println("No se puede calcular la media de un array vacío");
                }
            } else {
                System.out.println("Opción desconocida");
            }

            operation = askOperation();
        }
    }
}
