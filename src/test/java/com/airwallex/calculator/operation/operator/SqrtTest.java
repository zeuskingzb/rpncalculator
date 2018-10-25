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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.airwallex.calculator.save.ISave;

/**
 * ClassName:SqrtTest <br/>
 * Date: 2018年10月25日 上午12:13:55 <br/>
 *
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class SqrtTest {
    private Sqrt instance;

    @BeforeMethod
    public void newInstance() {
        this.instance = new Sqrt();
    }

    @AfterMethod
    public void setNull() {
        this.instance = null;
    }

    @Test
    public void SqrtDigit() {
        ISave mockSave = PowerMockito.mock(ISave.class);
        PowerMockito.when(mockSave.popDigit()).thenReturn(new BigDecimal(-9));
        instance.execute(mockSave);
        verify(mockSave, times(1)).pushDigit(Matchers.eq(new BigDecimal(-9)));
        verify(mockSave, times(1)).popDigit();
    }
    
}
