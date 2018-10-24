package com.airwallex.calculator.operation.operator;

import java.math.BigDecimal;

import com.airwallex.calculator.OperationRecord;
import com.airwallex.calculator.operation.IUserInput;
import com.airwallex.calculator.save.Save;

public class Undo implements IUserInput {

    @Override
    public void execute(Save save) {
        OperationRecord record = save.popOperationRecord();

        IUserInput input = record.getInput();
        if ((null == input) || (!(input instanceof Clear))) {
            save.popDigit();
        }
        if (null != record.getInput()) {
            for (BigDecimal digit : record.getParamList()) {
                save.pushDigit(digit);
            }
        }
    }

}
