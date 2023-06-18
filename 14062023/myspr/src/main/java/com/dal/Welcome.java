package com.dal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Welcome {
	@Autowired
	WelcomeWelcome w ;
	
	@Value("hi hi")
	private String name;

	public WelcomeWelcome getW() {
		return w;
	}

	public void setW(WelcomeWelcome w) {
		this.w = w;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String sayHi() {
		return "hi kannan";
		
	}

	
}


@Configuration
class WelcomeWelcome {
	
	
	public String sayHi() {
		return "WelcomeWelcome kannan";
	}
	
 
	
	

}