package com.kafka.baseconfig.listener;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import com.kafka.baseconfig.channel.KafkaConsumerChannel;


/**
 * 消息监听
 */
@EnableBinding(KafkaConsumerChannel.class)
public class TopicListener {
	
	private Logger log = LoggerFactory.getLogger(TopicListener.class);
	
	/**
	 * 手机短信消息队列
	 * 
	 * @author panrui 2016年12月15日
	 * @throws UnsupportedEncodingException
	 */
	@StreamListener(KafkaConsumerChannel.phone_ms_topic_name)
	public void receiverPhoneHandler(byte[] message) throws UnsupportedEncodingException {
		String msgContent = new String(message, "UTF-8");
		log.debug("手机短信消息消费:" + ",Content:" + msgContent);
		System.out.println("手机短信消息消费:" + ",Content:" + msgContent);
//		PhoneMsLogService phoneMsLogService = SpringContextUtils.getBean(PhoneMsLogService.class);
		String result = "0";//phoneMsLogService.sendMessage(msgContent);
		log.debug("手机短信消息消费:" + ",Content:" + msgContent + ",保存结果：" + result);
	}
}
