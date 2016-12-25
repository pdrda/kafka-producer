package com.kafka;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kafka.baseconfig.channel.KafkaConsumerChannel;
import com.kafka.baseconfig.channel.SpringContextUtils;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * kafka发送消息测试
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class AppTest {
	@Test
	public void send() throws InterruptedException{
		int i = 0;
		while(i<=1000000){
			System.out.println("----"+i);
			Random rnd = new Random();
			String ip = "5131.168.1112.----:" + i;
			String sms = "{'newIP':'"+ip+"'";
//			String sms = "{'originIP':'"+ip+"','phoneContent':'nihao','phoneNumber':'18010101010','token':'token'}";
			KafkaConsumerChannel kafkaSource = SpringContextUtils.getBean(KafkaConsumerChannel.class);
			kafkaSource.PHONE_MS_OUTPUT().send(MessageBuilder.withPayload(sms.getBytes()).build());
			i++;
//			Thread.sleep(100);
		}
	}
}
