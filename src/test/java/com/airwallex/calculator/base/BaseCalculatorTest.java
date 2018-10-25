/**  
 * Project Name:rpncalculator  <br/>
 * File Name:CalculatorTest.java  <br/>
 * Package Name:com.airwallex.calculator.operation.operator  <br/>
 * Date:2018年10月25日上午12:17:06  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.airwallex.calculator.base;  

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.powermock.api.mockito.PowerMockito;

import com.airwallex.calculator.save.ISave;

/**  
 * ClassName:BaseCalculatorTest <br/>  
 * Date:     2018年10月25日 上午12:17:06 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public class BaseCalculatorTest {
    public static InputStream getInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        return in;
    }

    public static List<BigDecimal> getOneOperationList() {
        return Arrays.asList(new BigDecimal(3));
    }

    public static List<BigDecimal> getTwoOperationList() {
        return Arrays.asList(new BigDecimal(9), new BigDecimal(3));
    }

    public static ISave givenMockSave() {
        ISave mockSave = PowerMockito.mock(ISave.class);
        PowerMockito.when(mockSave.popDigit()).thenReturn(new BigDecimal(3),new BigDecimal(9));
        PowerMockito.when(mockSave.getDigitStackSize()).thenReturn(2);
        return mockSave;
    }
}
  
