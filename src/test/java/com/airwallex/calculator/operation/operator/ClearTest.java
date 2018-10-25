/**  
 * Project Name:rpncalculator  <br/>
 * File Name:AdditionTest.java  <br/>
 * Package Name:com.airwallex.calculator.operation.operator  <br/>
 * Date:2018年10月25日上午12:13:55  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.base.BaseCalculatorTest;

/**
 * ClassName:ClearTest <br/>
 * Date: 2018年10月25日 上午12:13:55 <br/>
 *
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class ClearTest {
    private Clear instance;

    @BeforeMethod
    public void newInstance() {
        this.instance = new Clear();
    }

    @AfterMethod
    public void setNull() {
        this.instance = null;
    }

    @Test
    public void when2ElementsProvidedThenAnOperationRecordShouldReturn() {
        OperationRecord record = this.instance.getOperationRecord(BaseCalculatorTest.getTwoOperationList());
        Assert.assertNotNull(record);
        Assert.assertTrue(2 ==  record.getParamList().size());
        Assert.assertEquals(this.instance, record.getInput());
        Assert.assertEquals(new BigDecimal(3), record.getParamList().get(0));
        Assert.assertEquals(new BigDecimal(9), record.getParamList().get(1));
    }
   

}
