package com.cg.practice;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;





public class CamelRabbitmqApplication {

public static void main(String[] args) throws Exception {
		

        Producer queueProd = new Producer();
        queueProd.setupConnection();
        System.out.println(queueProd.toString());

        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {

            public void configure() throws Exception {
                System.out.println("hello world");
            	from("file:D:\\producer?noop=true")
        		
        		.aggregate(constant("all"), new KitAggregationStrategy()) 
        		.completionSize(2)
        		.to("rabbitmq://localhost:5672/MyExchange?username=guest&password=guest&autoDelete=false&routingKey=key&queue=Que");
                     

            }
        });

        context.start();
        Thread.sleep(4000);
        context.stop();
    }
}
