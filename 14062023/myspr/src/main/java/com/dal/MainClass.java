package com.dal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new   ClassPathXmlApplicationContext("NewFile.xml");
		Welcome wel =(Welcome) context.getBean("welcome");
		System.out.println(wel.sayHi());
		System.out.println(wel.getName());
		System.out.println(wel.w.sayHi());
	}
	
   

}
