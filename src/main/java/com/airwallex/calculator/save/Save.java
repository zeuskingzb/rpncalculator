/**  
 * Project Name:rpncalculator  <br/>
 * File Name:Save.java  <br/>
 * Package Name:com.airwallex.calculator.save  <br/>
 * Date:2018年10月24日下午7:12:32  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.save;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;

/**
 * ClassName:Save <br/>
 * Date: 2018年10月24日 下午7:12:32 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface Save {
    void pushDigit(BigDecimal userInput);

    BigDecimal popDigit();

    void printStack();

    void pushOperationRecord(OperationRecord operationRecord);

    OperationRecord popOperationRecord();

    int getDigitStackSize();
}
