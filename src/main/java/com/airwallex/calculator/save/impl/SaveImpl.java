/**  
 * Project Name:rpncalculator  <br/>
 * File Name:SaveImpl.java  <br/>
 * Package Name:com.airwallex.calculator.save.impl  <br/>
 * Date:2018年10月24日下午7:29:00  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.save.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserEnter;
import com.airwallex.calculator.save.Save;

/**
 * ClassName:SaveImpl <br/>
 * Date: 2018年10月24日 下午7:29:00 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class SaveImpl implements Save {
    private static final int MAX_DISPLAYED_DECIMAL_PLACES = 10;
    private static final int ZERO = 0;
    private Stack<BigDecimal> digitStack = new Stack<BigDecimal>();
    private Stack<OperationRecord> operationRecordStack = new Stack<OperationRecord>();

    public void pushDigit(BigDecimal userInput) {
        this.digitStack.push(userInput);
    }

    public BigDecimal popDigit() {
        return this.digitStack.pop();
    }
    /**
     * 
     * 打印stack信息  
     * @see com.airwallex.calculator.save.Save#printStack()
     */
    public void printStack() {
        System.out.print("Stack: ");
        List<BigDecimal> elements = new ArrayList<BigDecimal>(this.digitStack);
        for (BigDecimal element : elements) {
            System.out.print((ZERO == element.scale()) ? element : format10Digits(element.stripTrailingZeros()));
            System.out.print(IUserEnter.SPACE);
        }

        System.out.println();
    }

    protected String format10Digits(BigDecimal digit) {
        String result;
        if (MAX_DISPLAYED_DECIMAL_PLACES <= digit.scale()) {
            result = String.format("%.10f", digit.floatValue());
        } else {
            result = digit.toString();
        }
        return result;
    }

    public void pushOperationRecord(OperationRecord operationRecord) {

        this.operationRecordStack.push(operationRecord);

    }

    public OperationRecord popOperationRecord() {

        return this.operationRecordStack.pop();
    }

    @Override
    public int getDigitStackSize() {

        return this.digitStack.size();
    }

}
