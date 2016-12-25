package com.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

import com.kafka.baseconfig.channel.KafkaConsumerChannel;
import com.kafka.baseconfig.channel.SpringContextUtils;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableBinding(KafkaConsumerChannel.class)
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
		System.out.println("tonelink-win-message started");
		while(true){
			
		}
    }
    /**
	 * SpringContextUtils初始化
	 * @author tangdelong
	 * 2016年11月1日
	 */
	@Bean
	@ConditionalOnMissingBean
	public SpringContextUtils springContextUtils(){
		return new SpringContextUtils();
	}
}
