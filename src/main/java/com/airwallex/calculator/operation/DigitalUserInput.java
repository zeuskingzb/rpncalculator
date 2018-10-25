/**  
 * Project Name:rpncalculator  <br/>
 * File Name:DigitalUserInputImpl.java  <br/>
 * Package Name:com.airwallex.calculator.operation  <br/>
 * Date:2018年10月24日下午8:05:29  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.save.ISave;

/**
 * ClassName:DigitalUserInput <br/>
 * Date: 2018年10月24日 下午8:05:29 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class DigitalUserInput implements IUserInput {
    private BigDecimal data;

    public DigitalUserInput(final String userInput) {
        this.data = new BigDecimal(userInput);
    }

    @Override
    public void execute(ISave save) {
        save.pushDigit(data);
        OperationRecord record = toOperationRecord(data);
        save.pushOperationRecord(record);
    }

    private OperationRecord toOperationRecord(BigDecimal data) {
        List<BigDecimal> params = Arrays.asList(data);
        return new OperationRecord(params, null);
    }

}
