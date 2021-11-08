package com.microservice.camelmicroservice.routes.b;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqSenderRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// enpoint 1: timer
		from("timer:active-mq-timer?period=10000")
		.transform().constant("Mensaje encolado para Active MQ")
		.log("${body}")
		.to("activemq:my-activemq-queue");
		//enpoint 2: queue
		
	}

}
