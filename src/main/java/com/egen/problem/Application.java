package com.egen.problem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * Class Application is main class in ... 
 * 
 * @author Mourya,Rajala (rajala.mourya@gmail.com)
 * @created 07/16/2016 03:19:13 PM
 * @version 1.0
 * 
 */
@SpringBootApplication
@ImportResource({ "classpath:applicationContext.xml"})
public class Application {
	
	 /**
     * In the Java language, when you execute a class with the Java interpreter, 
     * the runtime system starts by calling the class's main() method.
     * 
     * @param args
     *             A single argument: An array of Strings
     * @throws Exception
     *             Throws an expection if anything goes wrong in main method
     *             
     */

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
