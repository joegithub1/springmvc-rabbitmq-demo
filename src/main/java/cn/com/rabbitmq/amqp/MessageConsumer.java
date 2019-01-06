package cn.com.rabbitmq.amqp;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import com.rabbitmq.client.Channel;

import cn.com.rabbitmq.service.OrderService;

public class MessageConsumer implements MessageListener,OrderService{

	private Logger logger = LoggerFactory.getLogger(MessageConsumer.class);
	public void onMessage(Message msg) {
		try {
			String result = new String(msg.getBody(),"UTF-8");
			logger.info("收到消息body："+result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		logger.info("成功消息是："+msg);
	}
	public void createOrder() {
		
		
	}

}
