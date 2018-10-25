/**  
 * Project Name:rpncalculator  <br/>
 * File Name:AdditionTest.java  <br/>
 * Package Name:com.airwallex.calculator.operation.operator  <br/>
 * Date:2018年10月25日上午12:13:55  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation.operator;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.mockito.Matchers;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.base.BaseCalculatorTest;
import com.airwallex.calculator.save.ISave;

/**
 * ClassName:MultiplicationTest <br/>
 * Date: 2018年10月25日 上午12:13:55 <br/>
 *
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class MultiplicationTest {
    private Multiplication instance;

    @BeforeMethod
    public void newInstance() {
        this.instance = new Multiplication();
    }

    @AfterMethod
    public void setNull() {
        this.instance = null;
    }

    @Test
    public void multiplicationTwoDigit() {
        ISave mockSave = BaseCalculatorTest.givenMockSave();
        instance.execute(mockSave);
        verify(mockSave).pushDigit(Matchers.eq(new BigDecimal(27)));
        verify(mockSave, times(2)).popDigit();
        verify(mockSave).pushOperationRecord(Matchers.any(OperationRecord.class));
    }
    
}
