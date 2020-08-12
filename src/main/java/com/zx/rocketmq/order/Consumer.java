package com.zx.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;

/**
 * @Package: com.zx.rocketmq.base
 * @ClassName: Consumer
 * @Author: xz
 * @Date: 2020/8/12 16:13
 * @Version: 1.0
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
        consumer.setNamesrvAddr("127.0.0.1:9876");
        consumer.subscribe("base","Tag1");
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeConcurrentlyContext) -> {
            list.forEach(item->{
                System.out.println(new String(item.getBody()));
            });
            return ConsumeOrderlyStatus.SUCCESS;
        });
        consumer.start();
    }
}
