/**  
 * Project Name:rpncalculator  <br/>
 * File Name:OperationRecord.java  <br/>
 * Package Name:com.airwallex.calculator  <br/>
 * Date:2018年10月24日下午7:19:24  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.airwallex.calculator;  

import java.math.BigDecimal;
import java.util.List;

import com.airwallex.calculator.operation.IUserInput;

/**  
 * ClassName:OperationRecord <br/>  
 * Date:     2018年10月24日 下午7:19:24 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public class OperationRecord {
    private List<BigDecimal> paramList;
    private IUserInput input;
    public List<BigDecimal> getParamList() {
        return paramList;
    }
    public void setParamList(List<BigDecimal> paramList) {
        this.paramList = paramList;
    }
    public IUserInput getInput() {
        return input;
    }
    public void setInput(IUserInput input) {
        this.input = input;
    }
    public OperationRecord(List<BigDecimal> paramList,IUserInput input) {
        if (paramList.isEmpty()) {
            throw new IllegalArgumentException("paramList can't null");
        }
        this.paramList = paramList;
        this.input = input;
    }
    
    
}
  
