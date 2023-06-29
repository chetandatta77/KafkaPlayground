package com.chetan.kafka.orderproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

//@SpringBootApplication
public class OrderproducerApplication {

	public static void main(String[] args) {
//		SpringApplication.run(OrderproducerApplication.class, args);
		
		Properties props = new Properties();
		props.setProperty("bootstrap.servers", "localhost:9092");
		props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer ");
		props.setProperty("value.serializer", "org.apache.kafka.common.serialization.IntegerSerializer ");
		
		KafkaProducer<String,Integer> producer = new KafkaProducer<String, Integer>(props);
		ProducerRecord<String, Integer> record = new ProducerRecord<>("Order-Topic", "Mac Book Pro",10);
		try {
			producer.send(record, new OrderCallBack());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}

}
