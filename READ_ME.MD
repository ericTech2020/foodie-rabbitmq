1.Exchange:
    Type: direct,topic,fanout,headers

Durability: 是否持久化
Auto Delete: 最后一个绑定的队列删除后，自动删除exchange
Internal: 当前exchagne 是否为RabbitMq 内部使用


2.启动顺序
1.Receiver4DirectExchange
2.Sender4DirectExchange

Exchange和Queue 多对多的关系
工作中：
一种类型的数据绑定一个Exchange，然后由Exchange 发到多个队列

3.项目中，MQ 要做到以下两点就可以了
-生产端可靠性投递 （ack）
-消费端幂等性 （消息重复消费是避免不了的，消费端一定要有机制检查重复消费）

4.幂等性：
RabbitMq 不支持幂等 （消息仅有一次投递成功）， kafaka支持，对性能比较损耗

4.1 业务唯一ID+指纹码机制，利用数据库主键去重
   先查再insert->大概率去重
   if((select count(1) from order where id=uniqueId)==1)
   {insert }

update order set count=count-1 ,version=version+1
where version=1

5.可靠性投递



