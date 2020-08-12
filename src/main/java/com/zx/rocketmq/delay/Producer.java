package com.zx.rocketmq.delay;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

/**
 * @Package: com.zx.rocketmq.order
 * @ClassName: Producer
 * @Author: xz
 * @Date: 2020/8/12 17:12
 * @Version: 1.0
 */
public class Producer {
    public static void main(String[] args) throws Exception{
        DefaultMQProducer producer = new DefaultMQProducer("group1");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 10; i++) {
            Message message = new Message("base","Tag1",("hello world " + i).getBytes());
            message.setDelayTimeLevel(2);
            producer.send(message);
        }
        producer.shutdown();
    }
}
