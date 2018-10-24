/**  
 * Project Name:rpncalculator  <br/>
 * File Name:CalculatorTest.java  <br/>
 * Package Name:com.airwallex.calculator.operation.operator  <br/>
 * Date:2018年10月25日上午12:17:06  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.airwallex.calculator.fixture;  

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.powermock.api.mockito.PowerMockito;

import com.airwallex.calculator.save.Save;

/**  
 * ClassName:CalculatorTest <br/>  
 * Date:     2018年10月25日 上午12:17:06 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public class CalculatorTestFixture {
    public static InputStream getInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        return in;
    }

    public static List<BigDecimal> getOneOperationList() {
        return Arrays.asList(new BigDecimal(1));
    }

    public static List<BigDecimal> getTwoOperationList() {
        return Arrays.asList(new BigDecimal(1), new BigDecimal(2));
    }

    public static Save givenMockSave() {
        Save mockSave = PowerMockito.mock(Save.class);
        PowerMockito.when(mockSave.popDigit()).thenReturn(new BigDecimal(1),new BigDecimal(2));
        PowerMockito.when(mockSave.getDigitStackSize()).thenReturn(2);
        return mockSave;
    }
}
  
