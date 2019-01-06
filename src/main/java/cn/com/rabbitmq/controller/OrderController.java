package cn.com.rabbitmq.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.com.rabbitmq.amqp.MessageSender;

@Controller
public class OrderController {

	private Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private MessageSender messageSender;
	
	public String main(){
		
		return "main";
	}
	@RequestMapping("/dovalid")
	@ResponseBody
	public String doValid(HttpServletRequest req){
		String msg = req.getParameter("msg");
		String roukingKey = req.getParameter("routingKey");
		messageSender.setRoutingKey(roukingKey);
		messageSender.sendDataToQueue(msg);
		logger.info("dovalid success");
		return "{\"key\" : \"value\"}";
	}
	
}
