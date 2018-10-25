package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.ISave;

public class Sqrt implements IUserInput, USER_EXCEPTION {

	@Override
	public void execute(ISave save) {
		BigDecimal first = save.popDigit();
        if (first.equals(first.abs())) {
			BigDecimal result = new BigDecimal(Math.sqrt(first.doubleValue())).setScale(IUserInput.DECIMAL_LENGTH, BigDecimal.ROUND_DOWN);
			save.pushDigit(result);
			OperationRecord record = this.getOperationRecord(first);
			save.pushOperationRecord(record);
		}
		else {
			save.pushDigit(first);
			System.err.println("Sqrt cannot be applied to " + first.stripTrailingZeros());
		}
	}

	protected OperationRecord getOperationRecord(BigDecimal digit) {
		List<BigDecimal> params = Arrays.asList(digit);
		return new OperationRecord(params, this);
	}

}