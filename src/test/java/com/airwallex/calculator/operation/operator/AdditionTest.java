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
 * ClassName:AdditionTest <br/>
 * Date: 2018年10月25日 上午12:13:55 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class AdditionTest {
    private Addition instance;

    @BeforeMethod
    public void newInstance() {
        this.instance = new Addition();
    }

    @AfterMethod
    public void setNull() {
        this.instance = null;
    }

    @Test
    public void when2ElementsProvidedThenSaveUpdateWithOneResult() {
        ISave mockSave = BaseCalculatorTest.givenMockSave();
        instance.execute(mockSave);
        //验证返回值
        verify(mockSave).pushDigit(Matchers.eq(new BigDecimal(12)));
        //验证调用过几次
        verify(mockSave, times(2)).popDigit();
        verify(mockSave).pushOperationRecord(Matchers.any(OperationRecord.class));
    }

    @Test
    public void when2ElementsProvidedThenAnOperationRecordShouldReturn() {
        OperationRecord record = this.instance.getOperationRecord(new BigDecimal(1), new BigDecimal(5));
        Assert.assertNotNull(record);
        Assert.assertTrue(2 == record.getParamList().size());
        Assert.assertEquals(this.instance, record.getInput());
        Assert.assertEquals(new BigDecimal(5), record.getParamList().get(0));
        Assert.assertEquals(new BigDecimal(1), record.getParamList().get(1));
    }
}
