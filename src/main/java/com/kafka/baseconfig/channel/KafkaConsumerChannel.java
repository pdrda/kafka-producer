package com.kafka.baseconfig.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
/**
 * 配置kafka 的topic 通道
 * */
public interface KafkaConsumerChannel {
	/**
	 * Kafka消息
	 */
	String phone_ms_topic_name = "sms";
	
	@Output(KafkaConsumerChannel.phone_ms_topic_name)
	MessageChannel PHONE_MS_OUTPUT(); 
	
	@Input(KafkaConsumerChannel.phone_ms_topic_name)
	SubscribableChannel PHONE_MS_INTPUT(); 
	
	
}
