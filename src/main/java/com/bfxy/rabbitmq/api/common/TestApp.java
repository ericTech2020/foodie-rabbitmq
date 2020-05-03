package com.bfxy.rabbitmq.api.common;

import org.springframework.beans.factory.annotation.Autowired;

public class TestApp {




    public static void main(String[] args) {


        RabbitMqSetting rabbitMqSetting=new RabbitMqSetting();
        System.out.println(rabbitMqSetting.getServerIp());
    }
}
