package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.save.Save;

public class Multiplication extends BiOperator {

	@Override
	protected void operate(Save save) {
		BigDecimal first = save.popDigit();
		BigDecimal second = save.popDigit();
		BigDecimal result = second.multiply(first);
		save.pushDigit(result);
		OperationRecord record = this.getOperationRecord(first, second);
		save.pushOperationRecord(record);
	}

}