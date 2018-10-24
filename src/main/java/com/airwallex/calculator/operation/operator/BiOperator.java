/**  
 * Project Name:rpncalculator  <br/>
 * File Name:BiOperator.java  <br/>
 * Package Name:com.airwallex.calculator.operation.operator  <br/>
 * Date:2018年10月24日下午8:28:25  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.airwallex.calculator.operation.operator;  

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.Save;

/**  
 * ClassName:BiOperator <br/>  
 * Date:     2018年10月24日 下午8:28:25 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public abstract class BiOperator implements IUserInput {
    private static final int TWO = 2;
    @Override
    public void execute(Save save) {

        if (isValidOperation(save)) {
            operate(save);
        }

    }
    protected OperationRecord getOperationRecord(BigDecimal first, BigDecimal second) {
        List<BigDecimal> params = Arrays.asList(second, first);
        return new OperationRecord(params, this);
    }
    
    protected boolean isValidOperation(Save save) {
        if (save.getDigitStackSize() < TWO) {
            throw new EmptyStackException();
        }
        return true;
    }
    protected abstract void operate(Save save);

}
  
