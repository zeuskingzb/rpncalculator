package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.ISave;

/**
 * 
 * ClassName: Division <br/>  
 * Function: 除法. <br/>  
 * date: 2018年10月24日 下午10:52:14 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
public class Division extends IOperator {

	@Override
	protected void operate(ISave save) {
		BigDecimal first = save.popDigit();
		//0的时候特殊处理,除数不能为零
		if (BigDecimal.ZERO.equals(first)) {
			save.pushDigit(first);
			System.err.println("The denominator cannot be ZERO!");
			return;
		}
		BigDecimal second = save.popDigit();
		BigDecimal total = second.divide(first, IUserInput.DECIMAL_LENGTH, BigDecimal.ROUND_DOWN);
		save.pushDigit(total);
		OperationRecord record = this.getOperationRecord(first, second);
		save.pushOperationRecord(record);
	}

}