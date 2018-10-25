package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.save.ISave;

public class Multiplication extends IOperator {

	@Override
	protected void operate(ISave save) {
		BigDecimal first = save.popDigit();
		BigDecimal second = save.popDigit();
		BigDecimal result = second.multiply(first);
		save.pushDigit(result);
		OperationRecord record = this.getOperationRecord(first, second);
		save.pushOperationRecord(record);
	}

}
