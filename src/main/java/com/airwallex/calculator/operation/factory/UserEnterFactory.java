/**  
 * Project Name:rpncalculator  <br/>
 * File Name:UserEnterFactory.java  <br/>
 * Package Name:com.airwallex.calculator.operation.factory  <br/>
 * Date:2018年10月24日下午7:51:19  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation.factory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airwallex.calculator.operation.DigitalUserInput;
import com.airwallex.calculator.operation.IUserEnter;
import com.airwallex.calculator.operation.IUserInput;

/**
 * ClassName:UserEnterFactory <br/>
 * Date: 2018年10月24日 下午7:51:19 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public class UserEnterFactory implements IUserEnter {
    protected final Logger LOG = LoggerFactory.getLogger(UserEnterFactory.class);
    private static final String DIGIT_PATTERN = "^-*\\d+$";
    private Scanner scanner;

    public UserEnterFactory() {
        this(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public UserEnterFactory(InputStream in) {
        this.scanner = new Scanner(in);
    }

    public List<IUserInput> getUserInput() {
        List<IUserInput> userInputs = new ArrayList<IUserInput>();
        String userEntered = scanner.nextLine();
        if (StringUtils.isNoneBlank(userEntered)) {
            String[] strings = userEntered.split(IUserEnter.SPACE);
            for (String string : strings) {
                IUserInput userInput = this.buildIUserInput(string);
                if(userInput!=null){
                    userInputs.add(userInput);
                }
            }
        }
        return userInputs;
    }

    public IUserInput buildIUserInput(String str) {
        IUserInput userInput = null;
        if (StringUtils.isNotBlank(str)) {
            if (str.matches(DIGIT_PATTERN)) {
                userInput = getDigitalUserInput(str);
            } else {
                userInput = getOperatorUserInput(str);
            }
        }
        return userInput;
    }

    /**
     * 
     * getOperatorUserInput:得到操作对象. <br/>
     * 
     * @author snow.zhang
     * @param str
     * @return
     * @since JDK 1.7
     */
    private IUserInput getOperatorUserInput(String str) {

        IUserInput userInput = null;

        try {
            userInput = OperatorFactory.getOperator(str);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return userInput;
    }

    /**
     * 
     * getDigitalUserInput:得到数字对象. <br/>
     * 
     * @author snow.zhang
     * @param str
     * @return
     * @since JDK 1.7
     */
    private IUserInput getDigitalUserInput(String str) {

        IUserInput userInput = null;
        try {
            userInput = new DigitalUserInput(str);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }
        return userInput;
    }

}
