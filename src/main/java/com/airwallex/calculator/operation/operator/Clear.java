package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EmptyStackException;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.ISave;

/**
 * 
 * ClassName: Clear <br/>  
 * Function: 清除. <br/>  
 * date: 2018年10月25日 上午9:12:53 <br/>  
 *  
 * @author snow.zhang  
 * @version   
 * @since JDK 1.7
 */
public class Clear implements IUserInput {

	@Override
	public void execute(ISave save) {
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