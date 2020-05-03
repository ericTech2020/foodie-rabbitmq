package com.bfxy.rabbitmq.api.common;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public  class RabbitMqSetting {

    private  String serverIp;
    private  String userName;
    private  String password;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RabbitMqSetting(){
        serverIp="10.211.55.12";
        userName="eric";
        password="eric";
    }
}
