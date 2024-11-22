package com.devrezaur.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SpringAopApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringAopApplication.class, args);
		
		AopClass aopClass = context.getBean(AopClass.class);
		aopClass.hello();
		aopClass.printSomething("DevRezaur");
		System.out.println(aopClass.sum(10, 20));
		
		AnotherClass anotherClass = context.getBean(AnotherClass.class);
		System.out.println(anotherClass.anotherMethod(10595));
	}
}
