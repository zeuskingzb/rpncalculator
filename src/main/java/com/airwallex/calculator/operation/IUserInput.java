/**  
 * Project Name:rpncalculator  <br/>
 * File Name:UserInput.java  <br/>
 * Package Name:com.airwallex.calculator  <br/>
 * Date:2018年10月24日下午7:08:08  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
 */

package com.airwallex.calculator.operation;

import com.airwallex.calculator.save.Save;

/**
 * ClassName:UserInput <br/>
 * Date: 2018年10月24日 下午7:08:08 <br/>
 * 
 * @author snow.zhang
 * @version
 * @since JDK 1.7
 * @see
 */
public interface IUserInput {
    int DECIMAL_LENGTH = 15;
    
    void execute(Save save);
}
