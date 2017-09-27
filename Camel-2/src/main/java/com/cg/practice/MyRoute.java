package com.cg.practice;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


	@Component
	public class MyRoute extends RouteBuilder {

	 
	@Override
	  public void configure() {

	         
			from("file:D:\\inbox")
	         .choice().when()
	         .simple("${file:ext} == 'txt'")
	         .to("file:D:\\text")
	         .when()
	         .simple("${file:ext} == 'html'")
	         .to("file:D:\\pages")
	         .otherwise()
	           .to("file:D:\\outbox");
		
	}
}
