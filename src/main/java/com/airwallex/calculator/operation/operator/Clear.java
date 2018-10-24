package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.Save;

public class Clear implements IUserInput {

	@Override
	public void execute(Save save) {
		List<BigDecimal> elements = new ArrayList<BigDecimal>();
		BigDecimal digit;
		try {
			while (null != (digit = save.popDigit())) {
				elements.add(digit);
			}
		}
		catch (EmptyStackException e) {
			save.pushOperationRecord(getOperationRecord(elements));
		}
	}

	protected OperationRecord getOperationRecord(List<BigDecimal> elements) {
		if (CollectionUtils.isNotEmpty(elements)) {
			Collections.reverse(elements);
			return new OperationRecord(elements, this);
		}
		return null;
	}


}