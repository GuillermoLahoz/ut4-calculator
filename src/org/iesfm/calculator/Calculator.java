package org.iesfm.calculator;

import org.iesfm.calculator.exceptions.DivideByZeroException;
import org.iesfm.calculator.exceptions.EmptyArrayException;

public class Calculator {

    public double divide(double n1, double n2) throws DivideByZeroException {
        if (n2 == 0) {
            throw new DivideByZeroException();
        } else {
            return n1 / n2;
        }
    }

    public double average(double[] numbers) throws EmptyArrayException {
        if (numbers.length == 0) {
            throw new EmptyArrayException();
        } else{
            double sum = 0;
            for (double number: numbers) {
                sum += number;
            }
            return sum / numbers.length;
        }
    }
}
