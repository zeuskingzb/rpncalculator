/**  
 * Project Name:rpncalculator  <br/>
 * File Name:Calculator.java  <br/>
 * Package Name:com.airwallex.calculator  <br/>
 * Date:2018年10月24日下午7:42:43  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator;

import java.io.InputStream;
import java.util.EmptyStackException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.airwallex.calculator.base.OperatorType;
import com.airwallex.calculator.operation.IUserEnter;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.operation.factory.UserEnterFactory;
import com.airwallex.calculator.save.ISave;
import com.airwallex.calculator.save.impl.SaveImpl;

/**
 * ClassName:Calculator <br/>
 * Date: 2018年10月24日 下午7:42:43 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class Calculator {
    private IUserEnter userEnter;
    private ISave save;

    public Calculator() {
        this(System.in);
    }

    public Calculator(InputStream in) {

        if (null == in) {
            throw new IllegalArgumentException("Input cannot be null!");
        }
        this.userEnter = new UserEnterFactory(in);
        this.save = new SaveImpl();
    }

    public void run() {
        List<IUserInput> userInputList = null;
        AtomicInteger counter = new AtomicInteger(1);
        while (null != (userInputList = this.userEnter.getUserInput())) {
            for (IUserInput i : userInputList) {
                try {
                    i.execute(this.save);
                    counter.incrementAndGet();
                } catch (EmptyStackException ese) {
                    System.err.println(formatErrorMessage(i, counter.get()));
                    break;
                }
            }
            save.printStack();
        }
    }

    protected String formatErrorMessage(IUserInput userInput, int counter) {
        StringBuilder buf = new StringBuilder("Operator: ");
        switch (userInput.getClass().getSimpleName()) {
        case "Addition":
            buf.append(OperatorType.ADD.getValue());
            break;
        case "Minus":
            buf.append(OperatorType.MINUS.getValue());
            break;
        case "Multiplication":
            buf.append(OperatorType.MULTIPLICATION.getValue());
            break;
        case "Division":
            buf.append(OperatorType.DIVISION.getValue());
            break;
        case "Sqrt":
            buf.append(OperatorType.SQRT.getValue());
            break;
        case "Undo":
            buf.append(OperatorType.UNDO.getValue());
            break;
        case "Clear":
            buf.append(OperatorType.CLEAR.getValue());
            break;

        default:
            buf.append(userInput.getClass().getSimpleName());
        }
        buf.append(" (position: ");
        buf.append(counter);
        buf.append("): Illegal parameters");
        return buf.toString();
    }

    public static void main(String[] argv) {
        new Calculator().run();
    }
}
