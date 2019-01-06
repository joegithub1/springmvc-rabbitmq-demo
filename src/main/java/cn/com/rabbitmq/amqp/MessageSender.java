package cn.com.rabbitmq.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;

public class MessageSender {

	private Logger logger = LoggerFactory.getLogger(MessageSender.class);
	private AmqpTemplate amqpTemplate;
	private String routingKey;
	public AmqpTemplate getAmqpTemplate() {
		return amqpTemplate;
	}
	public void setAmqpTemplate(AmqpTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
	public String getRoutingKey() {
		return routingKey;
	}
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	
	public void sendDataToQueue(Object obj){
		amqpTemplate.convertAndSend(this.routingKey,obj);
		logger.info("发送消息成功...");
	}
	
	
}
