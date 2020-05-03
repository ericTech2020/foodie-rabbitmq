package com.bfxy.rabbitmq.api.helloworld;

import java.util.HashMap;
import java.util.Map;

import com.bfxy.rabbitmq.api.common.RabbitMqSetting;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;

public class Sender {




	
	public static void main(String[] args) throws Exception {


		RabbitMqSetting rabbitMqSetting=new RabbitMqSetting();
		//	1 创建ConnectionFactory
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setHost(rabbitMqSetting.getServerIp());
		connectionFactory.setPort(5672);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setUsername(rabbitMqSetting.getUserName());
		connectionFactory.setPassword(rabbitMqSetting.getPassword());
		
		//	2 创建Connection
		Connection connection = connectionFactory.newConnection();
		//	3 创建Channel
		Channel channel = connection.createChannel();  
		//	4 声明
		String queueName = "test001";  
        //	参数: queue名字,是否持久化,独占的queue（仅供此连接）,不使用时是否自动删除, 其他参数
		channel.queueDeclare(queueName, false, false, false, null);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		
		AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
		.deliveryMode(2)
		.contentEncoding("UTF-8")
		.headers(headers).build();
		
		
		for(int i = 0; i < 5;i++) {
			String msg = "Hello World RabbitMQ " + i;
			channel.basicPublish("", queueName , props , msg.getBytes()); 			
		}
	}
	
}
