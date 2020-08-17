package com.zx.rocketmq.base;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

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
        consumer.subscribe("base","Tag2");
//        consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.registerMessageListener((MessageListenerConcurrently) (list, consumeConcurrentlyContext) -> {
            list.forEach(item->{
                System.out.println(new String(item.getBody()));
            });
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
    }
}
