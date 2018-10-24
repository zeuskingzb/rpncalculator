/**  
 * Project Name:rpncalculator  <br/>
 * File Name:UserEnter.java  <br/>
 * Package Name:com.airwallex.calculator.operation  <br/>
 * Date:2018年10月24日下午7:49:30  <br/>
 * Copyright (c) 2018, zizaike.com All Rights Reserved.  
 *  
*/  
  
package com.airwallex.calculator.operation;  

import java.util.List;

/**  
 * ClassName:UserEnter <br/>  
 * Date:     2018年10月24日 下午7:49:30 <br/>  
 * @author   snow.zhang  
 * @version    
 * @since    JDK 1.7  
 * @see        
 */
public interface IUserEnter {
    String SPACE = " ";

    List<IUserInput> getUserInput();
}
  
