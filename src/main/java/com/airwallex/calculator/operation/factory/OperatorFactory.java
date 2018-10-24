/**  
 * Project Name:rpncalculator  <br/>
 * File Name:OperatorFactory.java  <br/>
 * Package Name:com.airwallex.calculator.operation.factory  <br/>
 * Date:2018年10月24日下午8:23:29  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation.factory;

import com.airwallex.calculator.base.OperatorType;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.operation.operator.Addition;
import com.airwallex.calculator.operation.operator.Clear;
import com.airwallex.calculator.operation.operator.Division;
import com.airwallex.calculator.operation.operator.Minus;
import com.airwallex.calculator.operation.operator.Multiplication;
import com.airwallex.calculator.operation.operator.Sqrt;
import com.airwallex.calculator.operation.operator.Undo;

/**
 * ClassName:OperatorFactory <br/>
 * Date: 2018年10月24日 下午8:23:29 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class OperatorFactory {
    public static IUserInput getOperator(final String str) {
        IUserInput userInput = null;
        try {
            OperatorType operator = OperatorType.findByString(str);
            switch (operator) {
            case ADD:
                userInput = new Addition();
                break;
            case MINUS:
                userInput = new Minus();
                break;
            case MULTIPLICATION:
                userInput = new Multiplication();
                break;
            case DIVISION:
                userInput = new Division();
                break;
            case SQRT:
                userInput = new Sqrt();
                break;
            case CLEAR:
                userInput = new Clear();
                break;
            case UNDO:
                userInput = new Undo();
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return userInput;
    }
}
