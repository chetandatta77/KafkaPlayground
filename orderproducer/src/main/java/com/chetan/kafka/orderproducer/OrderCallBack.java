package com.chetan.kafka.orderproducer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallBack implements Callback {

	@Override
	public void onCompletion(RecordMetadata recordMetadata, Exception exception) {
		System.out.println(recordMetadata.partition());
		System.out.println(recordMetadata.offset());
		System.out.println("Message sent successfully");
		if(exception!=null) {
			exception.printStackTrace();
		}
	}
	

}
