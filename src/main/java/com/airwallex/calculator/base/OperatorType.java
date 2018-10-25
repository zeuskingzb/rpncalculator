/**  
 * Project Name:rpncalculator  <br/>
 * File Name:OperatorType.java  <br/>
 * Package Name:com.airwallex.calculator.base  <br/>
 * Date:2018年10月24日下午6:49:30  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.base;

import com.airwallex.calculator.ienum.IEnum;

/**
 * ClassName:OperatorType <br/>
 * Date: 2018年10月24日 下午6:49:30 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.8
 * @see
 */
public enum OperatorType implements IEnum {
    ADD("+"), MINUS("-"), MULTIPLICATION("*"), DIVISION("/"), SQRT("sqrt"), UNDO("undo"), CLEAR("clear");
    private String value;

    OperatorType(final String value) {
        this.value = value;
    }

    public String getValue() {

        return this.value;
    }

    public static OperatorType findByString(String input) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType.getValue().equals(input)) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("input cannot be [" +input+" ] ,Available operators are +, -, *, /, sqrt, undo, clear.");
    }

}
