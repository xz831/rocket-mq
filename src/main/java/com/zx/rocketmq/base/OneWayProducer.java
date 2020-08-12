package com.zx.rocketmq.base;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @Package: com.zx.rocketmq.base
 * @ClassName: OneWayProducer
 * @Author: xz
 * @Date: 2020/8/12 15:55
 * @Version: 1.0
 */
public class OneWayProducer {

    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base","Tag1",("hello world " + i).getBytes());
            producer.sendOneway(message);
        }
        producer.shutdown();
    }
}
