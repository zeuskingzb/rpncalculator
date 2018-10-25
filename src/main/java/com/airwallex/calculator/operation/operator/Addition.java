package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.save.ISave;

/**
 * 
 * ClassName: Addition <br/>  
 * Function: 求和. <br/>  
 * date: 2018年10月25日 上午9:13:05 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
public class Addition extends IOperator {

	@Override
	protected void operate(ISave save) {
		BigDecimal first = save.popDigit();
		BigDecimal second = save.popDigit();
		BigDecimal result = second.add(first);
		save.pushDigit(result);
		OperationRecord record = getOperationRecord(first, second);
		save.pushOperationRecord(record);
	}
}
