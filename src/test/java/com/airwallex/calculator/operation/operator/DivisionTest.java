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
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.base.BaseCalculatorTest;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.ISave;

/**
 * ClassName:AdditionTest <br/>
 * Date: 2018年10月25日 上午12:13:55 <br/>
 *
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class DivisionTest {
    private Division instance;

    @BeforeMethod
    public void newInstance() {
        this.instance = new Division();
    }

    @AfterMethod
    public void setNull() {
        this.instance = null;
    }

    @Test
    public void whenTwoProvidedThenSaveUpdateWithOneResult() {
        ISave mockSave = BaseCalculatorTest.givenMockSave();
        instance.execute(mockSave);
        verify(mockSave).pushDigit(Matchers.eq(new BigDecimal(3).setScale(IUserInput.DECIMAL_LENGTH)));
        verify(mockSave, times(2)).popDigit();
        verify(mockSave).pushOperationRecord(Matchers.any(OperationRecord.class));
    }

    @Test
    public void whenDivisorIsZero() {
        ISave mockSave = BaseCalculatorTest.givenMockSave();
        PowerMockito.when(mockSave.popDigit()).thenReturn(BigDecimal.ZERO, new BigDecimal(6));
        PowerMockito.when(mockSave.getDigitStackSize()).thenReturn(2);
        instance.execute(mockSave);
        verify(mockSave, times(1)).pushDigit(Matchers.eq(BigDecimal.ZERO));
        verify(mockSave, times(1)).popDigit();
        verify(mockSave, times(0)).pushOperationRecord((OperationRecord) Matchers.any());
    }

    @Test
    public void whenTwoParamsProvidedThenAnOperationRecordShouldReturn() {
        OperationRecord record = this.instance.getOperationRecord(new BigDecimal(2), new BigDecimal(6));
        Assert.assertNotNull(record);
        Assert.assertTrue(2 == record.getParamList().size());
        Assert.assertEquals(this.instance, record.getInput());
        Assert.assertEquals(new BigDecimal(6), record.getParamList().get(0));
        Assert.assertEquals(new BigDecimal(2), record.getParamList().get(1));
    }
}
