package com.cg.practice;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	 public static final String QUEUE_NAME = "Que";
	    public static Connection connection;

	    public void setupConnection() throws IOException, TimeoutException {
	        ConnectionFactory factory = new ConnectionFactory();
	        factory.setHost("localhost");
	        factory.setUsername("guest");
	        factory.setPassword("guest");

	        connection = factory.newConnection();
	        Channel channel = connection.createChannel();
	        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
	        channel.exchangeDeclare("MyExchange", "direct", true);
	        channel.queueBind(QUEUE_NAME, "MyExchange", "key");
	    }
}
